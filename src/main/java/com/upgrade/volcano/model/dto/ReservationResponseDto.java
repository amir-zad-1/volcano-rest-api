package com.upgrade.volcano.model.dto;

import com.upgrade.volcano.model.entity.Reservation;

import java.util.Date;

public class ReservationResponseDto extends ReservationDto {

    private long id;
    private Date reservationDate;


    public ReservationResponseDto(Reservation reservation) {
        super(reservation);
        this.setId(reservation.getId());
        this.setReservationDate(reservation.getReservationDate());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

}
