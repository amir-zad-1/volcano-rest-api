package com.upgrade.volcano.restapi.controller;

import com.upgrade.volcano.contract.service.CustomerService;
import com.upgrade.volcano.restapi.contract.Customer;

public class CustomerController implements Customer {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

}
