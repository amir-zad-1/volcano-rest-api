package com.upgrade.volcano.repository;

import com.upgrade.volcano.contract.repository.UserRepositoryContract;
import com.upgrade.volcano.entity.User;

import java.util.List;

public class UserRepository implements UserRepositoryContract<User> {
    @Override
    public User getById(int id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public boolean add(User item) {
        return false;
    }

    @Override
    public boolean update(User item) {
        return false;
    }

    @Override
    public boolean remove(int id) {
        return false;
    }
}
