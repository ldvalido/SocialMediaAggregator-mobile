package ar.com.redbee.socialmediaaggregator.services.topic;

import ar.com.redbee.socialmediaaggregator.commons.Callback;
import ar.com.redbee.socialmediaaggregator.domain.dto.UserFeedDto;

public interface TopicService {
    void getByUserName(String userName, Callback.HttpService<UserFeedDto> callback);
}
