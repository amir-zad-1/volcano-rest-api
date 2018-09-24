package com.upgrade.volcano.service;

public class OperationResult{

    private boolean ok;
    private String message;

    public OperationResult(boolean ok, String msg) {
        message = msg;
        this.ok = ok;
    }

    public boolean isOk() {
        return ok;
    }

    @Override
    public String toString() {
        return message;
    }

}
