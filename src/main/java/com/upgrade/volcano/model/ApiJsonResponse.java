package com.upgrade.volcano.model;

import java.util.Date;

public class ApiJsonResponse<T> {

    private T body;
    private boolean isOk;
    private Date utcDatetime;

    public ApiJsonResponse() {
    }

    public ApiJsonResponse(boolean ok, T response) {
        this.isOk = ok;
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

    public void setIsOk(boolean isOk) {
        this.isOk = isOk;
    }

    public boolean getIsOk() {
        return this.isOk;
    }

    public Date getUtcDatetime() {
        return this.utcDatetime;
    }
}
