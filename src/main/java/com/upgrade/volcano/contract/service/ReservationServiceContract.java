package com.upgrade.volcano.contract.service;

import com.upgrade.volcano.entity.Reservation;

import java.util.List;

public interface ReservationServiceContract {

    List<Reservation> getAll();
    Reservation get(long reservationid);
    Reservation add(Reservation reservation);
    Reservation update(Reservation reservation);
    boolean delete(long reservationid);

}
