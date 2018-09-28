package com.upgrade.volcano.service;

import com.upgrade.volcano.contract.service.UserServiceContract;
import com.upgrade.volcano.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceContract {

    @Autowired
    protected UserServiceContract customerRepository;

    @Override
    public List<User> getAll() {
        return customerRepository.getAll();
    }

}
