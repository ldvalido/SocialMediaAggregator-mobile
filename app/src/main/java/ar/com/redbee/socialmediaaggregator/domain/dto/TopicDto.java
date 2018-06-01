package ar.com.redbee.socialmediaaggregator.domain.dto;

public class TopicDto {
    String patternFind;
    boolean userTopic;

    public String getPatternFind() {
        return patternFind;
    }

    public void setPatternFind(String patternFind) {
        this.patternFind = patternFind;
    }

    public boolean isUserTopic() {
        return userTopic;
    }

    public void setUserTopic(boolean userTopic) {
        this.userTopic = userTopic;
    }
}
