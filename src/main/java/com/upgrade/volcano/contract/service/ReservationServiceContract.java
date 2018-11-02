package com.upgrade.volcano.contract.service;

import com.upgrade.volcano.model.entity.Reservation;

import java.util.List;

public interface ReservationServiceContract {

    List<Reservation> getAll();

//    List<Date> getAvailableDates(Date startDate, Date endDate);

    Reservation book(Reservation reservation);

    Reservation update(Reservation reservation);

    Boolean cancel(Long reservationid);

    Reservation getById(Long reservationid);

}
