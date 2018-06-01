package ar.com.redbee.socialmediaaggregator.domain.dto;

import java.util.List;

public class UserFeedDto {
private String userName;
private List<TopicDto> userTopics;
private List<TopicDto> interestTopics;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<TopicDto> getUserTopics() {
        return userTopics;
    }

    public void setUserTopics(List<TopicDto> userTopics) {
        this.userTopics = userTopics;
    }

    public List<TopicDto> getInterestTopics() {
        return interestTopics;
    }

    public void setInterestTopics(List<TopicDto> interestTopics) {
        this.interestTopics = interestTopics;
    }
}
