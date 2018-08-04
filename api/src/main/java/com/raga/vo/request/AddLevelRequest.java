package com.raga.vo.request;

public class AddLevelRequest {
    private String code;

    @SuppressWarnings("unused")
    public AddLevelRequest() {
    }

    public AddLevelRequest(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
