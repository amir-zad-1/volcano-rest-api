package com.upgrade.volcano.model.dto;

import com.upgrade.volcano.model.entity.Reservation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class ReservationDto {

    private String customerEmail;
    private String arrivalDate;
    private int duration;

    public ReservationDto() {
    }

    public ReservationDto(Reservation reservation) {
        this.setArrivalDate(reservation.getArrivalDate().toString());
        this.setCustomerEmail(reservation.getEmail());
        this.setDuration(reservation.getDuration());
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }


}
