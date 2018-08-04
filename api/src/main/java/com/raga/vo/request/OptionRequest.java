package com.raga.vo.request;

import com.raga.vo.CorrectOption;

public class OptionRequest {
    private String text;
    private CorrectOption correctOption;

    @SuppressWarnings("unused")
    public OptionRequest() {
    }

    public OptionRequest(String text, CorrectOption correctOption) {
        this.text = text;
        this.correctOption = correctOption;
    }

    public String getText() {
        return text;
    }

    public CorrectOption getCorrectOption() {
        return correctOption;
    }
}
