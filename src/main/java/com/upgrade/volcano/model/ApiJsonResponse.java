package com.upgrade.volcano.model;

import java.util.Date;

public class ApiJsonResponse<T> {

    private T body;
    private Date utcDatetime;

    public ApiJsonResponse() {
    }

    public ApiJsonResponse(T response) {
        this.body = response;
        this.utcDatetime = new Date();
    }

    public void setBody(T body) {
        this.body = body;
        this.utcDatetime = new Date();
    }

    public T getBody() {
        return this.body;
    }

    public Date getUtcDatetime() {
        return this.utcDatetime;
    }
}
