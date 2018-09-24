package com.upgrade.volcano.repository;

import com.upgrade.volcano.contract.repository.CustomerRepositoryContract;
import com.upgrade.volcano.model.Customer;

public class CustomerRepository extends GenericRepository<Customer> implements CustomerRepositoryContract<Customer> {
}
