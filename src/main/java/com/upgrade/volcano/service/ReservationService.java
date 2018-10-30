package com.upgrade.volcano.service;


import com.upgrade.volcano.contract.service.ReservationServiceContract;
import com.upgrade.volcano.model.entity.Reservation;
import com.upgrade.volcano.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService implements ReservationServiceContract {

    @Autowired
    protected ReservationRepository reservationRepository;


    @Override
    public List<Reservation> getAll() {
        return this.reservationRepository.findAll();
    }
}
