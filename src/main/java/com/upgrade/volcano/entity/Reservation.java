package com.upgrade.volcano.entity;

import java.util.Date;

public class Reservation extends Entity {

    private int id;
    private Date reservationDateUTC;
    private String email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
