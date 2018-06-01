package ar.com.redbee.socialmediaaggregator.activities.commons;

import android.support.v7.app.AppCompatDialog;

public interface LoadingActivity {
    Integer getLoadingResource();

    Integer getResourceToHide();

    void onLoadingStart();

    void onLoadingFail(Integer code, String message);

    void onLoadingSuccess();

    AppCompatDialog getActiveDialog();
}
