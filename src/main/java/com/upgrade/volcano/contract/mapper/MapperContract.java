package com.upgrade.volcano.contract.mapper;

public interface MapperContract<S, T> {

    T mapToDto(S entity);
    S mapToEntity(T dto);

}
