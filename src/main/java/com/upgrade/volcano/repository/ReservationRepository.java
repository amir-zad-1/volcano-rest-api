package com.upgrade.volcano.repository;

import com.upgrade.volcano.contract.repository.ReservationRepositoryContract;
import com.upgrade.volcano.entity.User;
import com.upgrade.volcano.entity.Reservation;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class ReservationRepository implements ReservationRepositoryContract<Reservation> {
    @Override
    public Reservation getById(int id) {
        return null;
    }

    @Override
    public List<Reservation> getAll() {
        List<Reservation> list = new ArrayList<>();
        Reservation reservation = new Reservation();
        reservation.setCustomer(new User(1,"Amir", "Hosseinzadeh", "am1hosseinzadeh@gmail.com"));
        reservation.setId(1);
        reservation.setArrivalDateUTC(new Date());
        reservation.setDepartureDateUTC(new Date());
        reservation.setReservationDateUTC(new Date());
        list.add(reservation);
        return list;
    }

    @Override
    public boolean add(Reservation item) {
        return false;
    }

    @Override
    public boolean update(Reservation item) {
        return false;
    }

    @Override
    public boolean remove(int id) {
        return false;
    }
}
