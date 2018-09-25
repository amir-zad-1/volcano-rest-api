package com.upgrade.volcano.controller;

import com.upgrade.volcano.contract.service.CustomerServiceContract;
import com.upgrade.volcano.contract.controller.CustomerControllerContract;

public class CustomerController implements CustomerControllerContract {

    private CustomerServiceContract customerService;

    public CustomerController(CustomerServiceContract customerService) {
        this.customerService = customerService;
    }

}
