package com.upgrade.volcano.model.dto;

import com.upgrade.volcano.model.entity.Reservation;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReservationRequestDto extends ReservationDto {

    public Reservation toResevation() {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date arrivalDate = simpleDateFormat.parse(this.getArrivalDate());
            return new Reservation(null, this.getCustomerEmail(), arrivalDate, this.getDuration());
        } catch (Exception e) {
            return null;
        }
    }

}
