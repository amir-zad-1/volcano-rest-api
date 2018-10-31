package com.upgrade.volcano.model.dto;

public class HomeDto {

    private String message;

    public HomeDto(String msg) {
        this.message = msg;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String msg) {
        this.message = msg;
    }
}
