package com.upgrade.volcano.contract.service;

import com.upgrade.volcano.model.Model;

import java.util.ArrayList;

public interface Service<T extends Model>  {

    T getById(int id);
    ArrayList<T> getAll();
    boolean add(T item);
    boolean update(T item);
    boolean remove(int id);

}
