package com.example.importify.Model;

import java.io.Serializable;

public class ErrorMessage implements Serializable {
    private int userId;
    private String message;

    public ErrorMessage(){}

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setExportValue(String message) {
        this.message = message;
    }
}
