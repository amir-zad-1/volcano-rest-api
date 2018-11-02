package com.upgrade.volcano.model.dto;

import com.upgrade.volcano.model.entity.Reservation;

public class ReservationUpdateRequestDto extends ReservationDto {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Long id;

    @Override
    public Reservation toRersevation() {
        Reservation reservation = super.toRersevation();
        reservation.setId(this.getId());
        return reservation;
    }


}
