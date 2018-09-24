package com.upgrade.volcano.contract.repository;

import com.upgrade.volcano.model.Model;

import java.util.ArrayList;

public interface GenericRepositoryContract<T extends Model>  {

    T getById(int id);
    ArrayList<T> getAll();
    boolean add(T item);
    boolean update(T item);
    boolean remove(int id);

}
