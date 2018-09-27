package com.upgrade.volcano.repository;

import com.upgrade.volcano.contract.repository.CustomerRepositoryContract;
import com.upgrade.volcano.entity.Customer;

import java.util.List;

public class CustomerRepository implements CustomerRepositoryContract<Customer> {
    @Override
    public Customer getById(int id) {
        return null;
    }

    @Override
    public List<Customer> getAll() {
        return null;
    }

    @Override
    public boolean add(Customer item) {
        return false;
    }

    @Override
    public boolean update(Customer item) {
        return false;
    }

    @Override
    public boolean remove(int id) {
        return false;
    }
}
