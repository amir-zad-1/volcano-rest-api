package com.upgrade.volcano.service;

import com.upgrade.volcano.contract.service.Service;
import com.upgrade.volcano.model.Model;

import java.util.ArrayList;

public class GenericService<T extends Model> implements Service<T> {
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
