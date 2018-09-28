package com.upgrade.volcano.mapper;

import com.upgrade.volcano.contract.mapper.MapperContract;
import com.upgrade.volcano.entity.User;
import com.upgrade.volcano.model.UserDto;

public class CustomerMapper implements MapperContract<User, UserDto> {

    @Override
    public UserDto mapToDto(User entity) {
        return new UserDto(
                entity.getId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getEmail());
    }

    @Override
    public User mapToEntity(UserDto dto) {
        return new User(
                dto.getId(),
                dto.getFirstName(),
                dto.getLastName(),
                dto.getEmail()
        );
    }
}
