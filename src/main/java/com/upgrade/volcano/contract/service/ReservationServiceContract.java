package com.upgrade.volcano.contract.service;

import com.upgrade.volcano.entity.Reservation;

import java.util.List;

public interface ReservationServiceContract {

    List<Reservation> getAll();
    Reservation add(Reservation reservation);

}
