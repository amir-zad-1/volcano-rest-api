package com.upgrade.volcano.model.dto;

public class ReservationCancelResponse {

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    private Boolean success;

    public ReservationCancelResponse(Boolean success) {
        this.success = success;
    }

}
