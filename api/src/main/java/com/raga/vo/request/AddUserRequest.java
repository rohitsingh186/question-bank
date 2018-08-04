package com.raga.vo.request;

public class AddUserRequest {
    private String userName;
    private String fullName;

    @SuppressWarnings("unused")
    public AddUserRequest() {
    }

    public AddUserRequest(String userName, String fullName) {
        this.userName = userName;
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public String getFullName() {
        return fullName;
    }
}
