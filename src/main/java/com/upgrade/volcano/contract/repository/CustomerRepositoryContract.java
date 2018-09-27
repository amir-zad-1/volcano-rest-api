package com.upgrade.volcano.contract.repository;

import com.upgrade.volcano.entity.Model;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepositoryContract<T extends Model> extends GenericRepositoryContract<T> {

}
