package ar.com.redbee.socialmediaaggregator.services.topic.impl;

import android.content.Context;

import ar.com.redbee.socialmediaaggregator.commons.Callback;
import ar.com.redbee.socialmediaaggregator.commons.http.GetRequest;
import ar.com.redbee.socialmediaaggregator.commons.utils.Constants;
import ar.com.redbee.socialmediaaggregator.commons.web.model.HttpSimpleRequest;
import ar.com.redbee.socialmediaaggregator.commons.web.type.ContentType;
import ar.com.redbee.socialmediaaggregator.commons.web.type.HttpRequestMethodType;
import ar.com.redbee.socialmediaaggregator.domain.dto.UserFeedDto;
import ar.com.redbee.socialmediaaggregator.services.topic.TopicService;

public class TopicServiceImpl implements TopicService {

    Context context;
    public TopicServiceImpl(Context context){
        this.context = context;
    }
    @Override
    public void getByUserName(String userName, final Callback.HttpService<UserFeedDto> callback) {
        GetRequest get = new GetRequest(
                context,
                new HttpSimpleRequest(String.format(Constants.HOST_DEV_URL,String.format("boards/%s",userName)),
                HttpRequestMethodType.GET,
                null,
                ContentType.JSON));
        get.showLoading(true);
        get.execute(new Callback.JsonHttpService<UserFeedDto>(callback) {
            @Override
            protected UserFeedDto mapper(Class<UserFeedDto> clazz, String data) {
                UserFeedDto userData = super.mapper(clazz, data);
                return userData;
            }
        });
    }
}
