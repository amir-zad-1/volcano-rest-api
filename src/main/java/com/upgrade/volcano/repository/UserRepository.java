package com.upgrade.volcano.repository;

import com.upgrade.volcano.contract.repository.UserRepositoryContract;
import com.upgrade.volcano.entity.User;

import java.util.List;

public class UserRepository implements UserRepositoryContract {
    @Override
    public User getById(int id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User add(User item) {
        return null;
    }

    @Override
    public User update(User item) {
        return null;
    }

    @Override
    public boolean remove(int id) {
        return false;
    }
}
