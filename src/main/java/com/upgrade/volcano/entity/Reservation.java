package com.upgrade.volcano.entity;

import java.util.Date;

public class Reservation extends Model{

    private int id;
    private Date reservationDateUTC;
    private User customer;
    private Date arrivalDateUTC;
    private Date departureDateUTC;

    public Reservation() {
    }

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

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
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
