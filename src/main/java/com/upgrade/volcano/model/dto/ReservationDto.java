package com.upgrade.volcano.model.dto;

import com.upgrade.volcano.model.entity.Reservation;

import java.util.Date;

public class ReservationDto {

    private String customerEmail;
    private Date arrivalDate;
    private Date departureDate;

    public ReservationDto() {
    }

    public ReservationDto(Reservation reservation) {
        this.setArrivalDate(reservation.getArrivalDate());
        this.setCustomerEmail(reservation.getEmail());
        this.setDepartureDate(reservation.getDepartureDate());
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

}
