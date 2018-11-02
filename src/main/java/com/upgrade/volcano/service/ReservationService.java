package com.upgrade.volcano.service;


import com.upgrade.volcano.contract.service.CalendarServiceContract;
import com.upgrade.volcano.contract.service.ReservationServiceContract;
import com.upgrade.volcano.controller.NotAvailableException;
import com.upgrade.volcano.controller.NotValidException;
import com.upgrade.volcano.model.entity.Reservation;
import com.upgrade.volcano.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReservationService implements ReservationServiceContract {

    @Autowired
    protected ReservationRepository reservationRepository;

    @Autowired
    CalendarServiceContract calendarService;

    @Autowired
    DateUtility dateUtility;


    @Override
    public List<Reservation> getAll() {
        return this.reservationRepository.findAll();
    }

    private Boolean validate(Reservation reservation) {
        // todo reservation validation
        return true;
    }

    @Override
    public Reservation book(Reservation reservation) {
        if (!this.validate(reservation)) throw new NotValidException();
        if (!this.calendarService.isAvailable(reservation.getArrivalDate(), reservation.getDuration()))
            throw new NotAvailableException();

        this.reservationRepository.save(reservation);
        Date[] dates = this.dateUtility.getDateRange(reservation.getArrivalDate(), reservation.getDuration());
        for (Date day: dates) {
            this.calendarService.updateAvailableDate(day, false);
        }
        return reservation;

    }

//
//    @Override
//    public Reservation update(Reservation reservation) {
//        return null;
//    }
//
//    @Override
//    public Boolean cancel(Reservation reservation) {
//        return null;
//    }
}
