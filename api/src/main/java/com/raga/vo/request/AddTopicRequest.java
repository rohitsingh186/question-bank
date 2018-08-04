package com.raga.vo.request;

public class AddTopicRequest {
    private String name;

    @SuppressWarnings("unused")
    public AddTopicRequest() {
    }

    public AddTopicRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
