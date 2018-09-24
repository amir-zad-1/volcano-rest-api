package com.upgrade.volcano.repository;

import com.upgrade.volcano.model.Model;

import java.util.ArrayList;

public class GenericRepository<T extends Model> implements com.upgrade.volcano.contract.repository.GenericRepository<T> {
    @Override
    public T getById(int id) {
        return null;
    }

    @Override
    public ArrayList<T> getAll() {
        return null;
    }

    @Override
    public boolean add(T item) {
        return false;
    }

    @Override
    public boolean update(T item) {
        return false;
    }

    @Override
    public boolean remove(int id) {
        return false;
    }
}
