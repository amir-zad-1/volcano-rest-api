package com.upgrade.volcano.contract.repository;

import com.upgrade.volcano.entity.Entity;

import java.util.List;

public interface GenericRepositoryContract<T extends Entity>  {

    T getById(int id);
    List<T> getAll();
    T add(T item);
    T update(T item);
    boolean remove(int id);

}
