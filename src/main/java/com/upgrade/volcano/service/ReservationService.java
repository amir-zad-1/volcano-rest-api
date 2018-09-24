package com.upgrade.volcano.service;


import com.upgrade.volcano.contract.repository.ReservationRepositoryContract;
import com.upgrade.volcano.contract.service.ReservationServiceContract;
import com.upgrade.volcano.model.Reservation;
import com.upgrade.volcano.repository.ReservationRepository;

import java.util.ArrayList;

public class ReservationService implements ReservationServiceContract {

    protected ReservationRepositoryContract reservationRepository;

    public ReservationService() {
        reservationRepository = new ReservationRepository();
    }

    @Override
    public ArrayList<Reservation> getAll() {
        return reservationRepository.getAll();
    }
}
