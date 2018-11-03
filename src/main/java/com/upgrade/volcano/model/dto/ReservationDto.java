package com.upgrade.volcano.model.dto;

import com.upgrade.volcano.model.entity.Reservation;
import com.upgrade.volcano.service.DateUtility;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReservationDto {

    DateUtility dateUtility = new DateUtility();

    private String customerEmail;
    private String arrivalDate;
    private Date reservationDate;
    private int duration;

    public ReservationDto() {
    }

    public ReservationDto(Reservation reservation) {
        this.setArrivalDate(dateUtility.formateDate(reservation.getArrivalDate()));
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

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Reservation toRersevation() {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date arrivalDate = simpleDateFormat.parse(this.getArrivalDate());
            return new Reservation(null, this.getCustomerEmail(), arrivalDate, this.getDuration());
        } catch (Exception e) {
            return null;
        }
    }
}
