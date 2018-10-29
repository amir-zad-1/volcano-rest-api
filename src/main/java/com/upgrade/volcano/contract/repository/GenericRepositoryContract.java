package com.upgrade.volcano.contract.repository;

import com.upgrade.volcano.model.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;

public interface GenericRepositoryContract<T extends BaseEntity>  {

    T getById(long id);
    List<T> getAll();
    T add(T item);
    T update(T item);
    boolean remove(long id);

}
