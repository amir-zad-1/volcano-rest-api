package com.upgrade.volcano.contract.repository;

import com.upgrade.volcano.entity.Model;

import java.util.List;

public interface GenericRepositoryContract<T extends Model>  {

    T getById(int id);
    List<T> getAll();
    boolean add(T item);
    boolean update(T item);
    boolean remove(int id);

}
