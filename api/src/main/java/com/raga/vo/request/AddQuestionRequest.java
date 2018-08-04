package com.raga.vo.request;

import java.util.List;
import java.util.Set;

public class AddQuestionRequest {
    private String text;
    private String topicId;
    private String levelId;
    private String submitterId;
    private List<OptionRequest> optionRequests;

    @SuppressWarnings("unused")
    public AddQuestionRequest() {
    }

    public AddQuestionRequest(String text, String topicId, String levelId, String submitterId, List<OptionRequest> optionRequests) {
        this.text = text;
        this.topicId = topicId;
        this.levelId = levelId;
        this.submitterId = submitterId;
        this.optionRequests = optionRequests;
    }

    public String getText() {
        return text;
    }

    public String getTopicId() {
        return topicId;
    }

    public String getLevelId() {
        return levelId;
    }

    public String getSubmitterId() {
        return submitterId;
    }

    public List<OptionRequest> getOptionRequests() {
        return optionRequests;
    }
}
