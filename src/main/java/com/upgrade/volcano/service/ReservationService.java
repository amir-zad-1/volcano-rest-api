package com.upgrade.volcano.service;


import com.upgrade.volcano.contract.repository.ReservationRepositoryContract;
import com.upgrade.volcano.contract.service.ReservationServiceContract;
import com.upgrade.volcano.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService implements ReservationServiceContract {

    @Autowired
    protected ReservationRepositoryContract reservationRepository;

    @Override
    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }

    @Override
    public Reservation add(Reservation reservation) {  // todo: validation
        return reservationRepository.add(reservation);
    }

    @Override
    public Reservation update(Reservation reservation) {
        return reservationRepository.update(reservation);
    }

    @Override
    public boolean delete(int reservationid) {
        return reservationRepository.remove(reservationid);
    }
}
