package com.upgrade.volcano.contract.service;

import com.upgrade.volcano.model.entity.Reservation;

import java.util.List;

public interface ReservationServiceContract {

    List<Reservation> getAll();

    void deleteAll();

    Reservation book(Reservation reservation);

    Reservation update(Reservation reservation);

    Boolean cancel(Long reservationid);

    Reservation getById(Long reservationid);

}
