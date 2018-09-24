package com.upgrade.volcano.restapi;

import com.upgrade.volcano.contract.service.CustomerServiceContract;
import com.upgrade.volcano.restapi.contract.CustomerControllerContract;

public class CustomerController implements CustomerControllerContract {

    private CustomerServiceContract customerService;

    public CustomerController(CustomerServiceContract customerService) {
        this.customerService = customerService;
    }

}
