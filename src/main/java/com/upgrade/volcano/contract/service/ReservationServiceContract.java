package com.upgrade.volcano.contract.service;

import com.upgrade.volcano.model.entity.Reservation;

import java.util.Date;
import java.util.List;

public interface ReservationServiceContract {

    List<Reservation> getAll();

//    Reservation getById(Long reservationId);
//
//    List<Date> getAvailableDates();
//
//    List<Date> getAvailableDates(Date startDate, Date endDate);
//
//    Boolean validate(Reservation reservation);
//
//    Boolean reserve(Reservation reservation);
//
//    Boolean update(Reservation reservation);
//
//    Boolean cancel(Reservation reservation);

}
