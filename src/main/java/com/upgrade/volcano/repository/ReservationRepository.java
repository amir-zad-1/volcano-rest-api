package com.upgrade.volcano.repository;

import com.upgrade.volcano.contract.repository.ReservationRepositoryContract;
import com.upgrade.volcano.entity.Reservation;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class ReservationRepository implements ReservationRepositoryContract {

    private HashMap<Integer, Reservation> database;

    public ReservationRepository() {
        this.database = new HashMap<>();
    }

    @Override
    public Reservation getById(int id) {
        return null;
    }

    @Override
    public List<Reservation> getAll() {
        return new ArrayList<>(this.database.values());
    }

    @Override
    public Reservation add(Reservation item) {
        int id = item.hashCode();
        if (item.getId() == 0) {
            item.setId(id);
        }
        this.database.put(id, item);
        return item;
    }

    @Override
    public Reservation update(Reservation item) {
        if (this.database.containsKey(item.getId())) {
            this.database.put(item.getId(), item);
            return item;
        } else {
            return null;
        }
    }

    @Override
    public boolean remove(int id) {
        if (this.database.containsKey(id)) {
            this.database.remove(id);
            return true;
        } else {
            return false;
        }
    }
}
