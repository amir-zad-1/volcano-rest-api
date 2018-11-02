package com.upgrade.volcano.model.dto;

import com.upgrade.volcano.model.entity.Reservation;

public class ReservationResponseDto extends ReservationDto {

    private long id;

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

}
