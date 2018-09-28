package com.upgrade.volcano.model;

import java.util.Date;

public class ReservationDto {

    private int id;
    private Date reservationDateUTC;
    private String customerEmail;
    private Date arrivalDateUTC;
    private Date departureDateUTC;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getReservationDateUTC() {
        return reservationDateUTC;
    }

    public void setReservationDateUTC(Date reservationDateUTC) {
        this.reservationDateUTC = reservationDateUTC;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Date getArrivalDateUTC() {
        return arrivalDateUTC;
    }

    public void setArrivalDateUTC(Date arrivalDateUTC) {
        this.arrivalDateUTC = arrivalDateUTC;
    }

    public Date getDepartureDateUTC() {
        return departureDateUTC;
    }

    public void setDepartureDateUTC(Date departureDateUTC) {
        this.departureDateUTC = departureDateUTC;
    }

}
