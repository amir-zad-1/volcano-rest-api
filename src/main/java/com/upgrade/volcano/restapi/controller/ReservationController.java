package com.upgrade.volcano.restapi.controller;

import com.upgrade.volcano.contract.model.Reservation;
import com.upgrade.volcano.contract.service.ReservationService;

public class ReservationController implements Reservation {

    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

}
