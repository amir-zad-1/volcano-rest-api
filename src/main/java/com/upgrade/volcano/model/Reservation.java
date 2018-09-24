package com.upgrade.volcano.model;

import java.util.Date;

public class Reservation extends Model{

    private int id;
    private Date reservationDateUTC;
    private Customer customer;
    private Date arrivalDateUTC;
    private Date departureDateUTC;

    public Reservation() {
    }

}
