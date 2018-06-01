package ar.com.redbee.socialmediaaggregator.commons.http;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.view.View;

import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.HashMap;

import ar.com.redbee.socialmediaaggregator.activities.commons.LoadingActivity;
import ar.com.redbee.socialmediaaggregator.commons.Callback;
import ar.com.redbee.socialmediaaggregator.commons.logger.LoggerHelper;
import ar.com.redbee.socialmediaaggregator.commons.utils.Constants;
import ar.com.redbee.socialmediaaggregator.commons.utils.GenericUtils;
import ar.com.redbee.socialmediaaggregator.commons.web.model.HttpSimpleRequest;
import ar.com.redbee.socialmediaaggregator.commons.web.type.ContentType;

public class GetRequest {

    OkHttpClient client;
    Request request;
    Context context;
    Integer resourceLoading = null;
    LoadingActivity loadingActivity = null;
    Boolean showLoading = true;
    Boolean isSync = false;

    public GetRequest(Context context, HttpSimpleRequest simpleRequest) {
        this.context = context;
        if (context instanceof LoadingActivity) {
            loadingActivity = (LoadingActivity) context;
            this.resourceLoading = loadingActivity.getLoadingResource();
        }
        client = new OkHttpClient();

        Cache cache;
        cache = new Cache(new File(context.getApplicationContext().getCacheDir(), "http-requests"), Constants.FIVE_MEGABYTES_IN_BYTES);
        client.setCache(cache);

        Request.Builder requestBuilder = new Request.Builder().url(simpleRequest.getUrl());

        if (simpleRequest.getContentType() != null) {
            requestBuilder.addHeader(ContentType.CONTENT_TYPE, ContentType.JSON.getContentType());
        }

        if (simpleRequest.getPostParameters() != null) {
            for (HashMap.Entry<String, String> item : simpleRequest.getPostParameters().entrySet()) {
                requestBuilder.addHeader(item.getKey(), item.getValue());
            }
        }

        requestBuilder.addHeader(Constants.HEADER_CLIENT_REQUEST_NAME, Constants.HEADER_CLIENT_REQUEST_VALUE);

        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            requestBuilder.addHeader(Constants.HEADER_CLIENT_VERSION_REQUEST_NAME, String.valueOf(info.versionCode));
        } catch (PackageManager.NameNotFoundException e) {
            LoggerHelper.e(e, GetRequest.class.getName());
        }

        request = requestBuilder.build();
    }

    public GetRequest setSync(Boolean value) {
        isSync = value;
        return this;
    }

    public GetRequest showLoading(Boolean value) {
        showLoading = value;
        return this;
    }

    public void execute(final Callback.HttpService<String> callback) {
        final Handler mainHandler = new Handler(context.getMainLooper());

        // Make loading appear
        if (showLoading && loadingActivity != null) {
            if (((Activity) context).getWindow().getDecorView().findViewById(resourceLoading) != null)
                ((Activity) context).getWindow().getDecorView().findViewById(resourceLoading).setVisibility(View.VISIBLE);
            loadingActivity.onLoadingStart();
        }

        if (isSync) {
            try {
                Response response = client.newCall(request).execute();
                final Integer code = response.code();
                final String body = GenericUtils.buildStringFromInputStream(response.body().byteStream());
                if (callback != null)
                    callback.execute(code, body);
            } catch (IOException e) {
                LoggerHelper.e(e, GetRequest.class.getName());
                callback.fireError(HttpURLConnection.HTTP_NOT_FOUND, e);
            }
        } else {
            client.newCall(request).enqueue(new com.squareup.okhttp.Callback() {
                @Override
                public void onFailure(Request request, final IOException e) {
                    mainHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            // Make loading disappear
                            if (showLoading && loadingActivity != null) {
                                if (((Activity) context).getWindow().getDecorView().findViewById(resourceLoading) != null)
                                    ((Activity) context).getWindow().getDecorView().findViewById(resourceLoading).setVisibility(View.GONE);

                                loadingActivity.onLoadingFail(HttpURLConnection.HTTP_GATEWAY_TIMEOUT, e.getMessage());
                            } else if (callback != null)
                                callback.fireError(HttpURLConnection.HTTP_GATEWAY_TIMEOUT, e);
                        }
                    });
                }

                @Override
                public void onResponse(final Response response) throws IOException {
                    final Integer code = response.code();
                    final String body = GenericUtils.buildStringFromInputStream(response.body().byteStream());

                    mainHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            // Make loading disappear
                            if (showLoading && loadingActivity != null) {
                                if (((Activity) context).getWindow().getDecorView().findViewById(resourceLoading) != null)
                                    ((Activity) context).getWindow().getDecorView().findViewById(resourceLoading).setVisibility(View.GONE);

                                if (code >= HttpURLConnection.HTTP_BAD_REQUEST)
                                    loadingActivity.onLoadingFail(code, null);
                                else
                                    loadingActivity.onLoadingSuccess();
                            }
                            if (callback != null)
                                if (code >= HttpURLConnection.HTTP_BAD_REQUEST)
                                    callback.fireError(code, new Exception(body));
                                else
                                    callback.execute(code, body);
                        }
                    });
                }
            });
        }
    }
}

