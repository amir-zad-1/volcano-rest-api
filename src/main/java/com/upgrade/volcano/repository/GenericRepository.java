package com.upgrade.volcano.repository;

import com.upgrade.volcano.contract.repository.GenericRepositoryContract;
import com.upgrade.volcano.entity.Model;

import java.util.ArrayList;

public class GenericRepository<T extends Model> implements GenericRepositoryContract<T> {
    @Override
    public T getById(int id) {
        return null;
    }

    @Override
    public ArrayList<T> getAll() {
        return new ArrayList<>();
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
