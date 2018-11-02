package com.upgrade.volcano.service;


import com.upgrade.volcano.contract.service.CalendarServiceContract;
import com.upgrade.volcano.contract.service.ReservationServiceContract;
import com.upgrade.volcano.controller.NotAvailableException;
import com.upgrade.volcano.controller.NotValidException;
import com.upgrade.volcano.model.entity.Reservation;
import com.upgrade.volcano.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
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
        for (Date day : dates) {
            this.calendarService.updateAvailableDate(day, false);
        }
        return reservation;

    }

    @Override
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public Reservation update(Reservation reservation) {
        // Step 1: Get the reservation
        Reservation reservationEntity = this.reservationRepository.getOne(reservation.getId());
        if (reservationEntity == null) throw new NotValidException();

        // Step 2: Validate it
        if (!this.validate(reservation)) throw new NotValidException();

        // Step 3: Make its days available
        Date[] dates = this.dateUtility.getDateRange(reservationEntity.getArrivalDate(),
                reservationEntity.getDuration());
        for (Date day : dates) {
            this.calendarService.updateAvailableDate(day, true);
        }

        // Step 4: Book it with new arrival date and duration
        if (!this.calendarService.isAvailable(reservation.getArrivalDate(), reservation.getDuration()))
            throw new NotAvailableException();

        dates = this.dateUtility.getDateRange(reservation.getArrivalDate(), reservation.getDuration());
        for (Date day : dates) {
            this.calendarService.updateAvailableDate(day, false);
        }

        reservationEntity.setArrivalDate(reservation.getArrivalDate());
        reservationEntity.setEmail(reservation.getEmail());
        reservationEntity.setDuration(reservation.getDuration());
        this.reservationRepository.save(reservationEntity);

        return reservationEntity;
    }

    @Override
    public Boolean cancel(Long reservationid) {//        try {
        Reservation reservation = this.getById(reservationid);
        Date[] dates = this.dateUtility.getDateRange(reservation.getArrivalDate(),
                reservation.getDuration());
        for (Date day : dates) {
            this.calendarService.updateAvailableDate(day, true);
        }
        this.reservationRepository.delete(reservation);
        return true;
    }

    @Override
    public Reservation getById(Long reservationid) {
        return this.reservationRepository.getOne(reservationid);
    }

}
