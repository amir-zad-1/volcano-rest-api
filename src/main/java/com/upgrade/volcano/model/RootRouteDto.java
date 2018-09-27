package com.upgrade.volcano.model;

public class RootRouteDto {

    private String message;

    public RootRouteDto(String msg) {
        this.message = msg;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String msg) {
        this.message = msg;
    }
}
