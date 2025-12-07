package com.bing.queen.ai.common.core.domain.dto;

public class AiSessionDTO {
    private long sessionID;
    private String topic;

    public long getSessionID() {
        return sessionID;
    }

    public void setSessionID(long sessionID) {
        this.sessionID = sessionID;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
