package com.upgrade.volcano.model.mapper;

import com.upgrade.volcano.contract.mapper.MapperContract;
import com.upgrade.volcano.model.entity.Reservation;
import com.upgrade.volcano.model.dto.ReservationDto;

public class ReservationMapper implements MapperContract<Reservation, ReservationDto> {


    @Override
    public ReservationDto mapToDto(Reservation entity) {
        ReservationDto reservationDto = new ReservationDto();

        reservationDto.setId(entity.getId());
        reservationDto.setArrivalDateUTC(entity.getArrivalDateUTC());
        reservationDto.setCustomerEmail(entity.getEmail());
        reservationDto.setDepartureDateUTC(entity.getDepartureDateUTC());
        reservationDto.setReservationDateUTC(entity.getReservationDateUTC());

        return reservationDto;
    }

    @Override
    public Reservation mapToEntity(ReservationDto dto) {
        Reservation reservationEntity = new Reservation();
        reservationEntity.setId(dto.getId());
        reservationEntity.setReservationDateUTC(dto.getReservationDateUTC());
        reservationEntity.setArrivalDateUTC(dto.getArrivalDateUTC());
        reservationEntity.setDepartureDateUTC(dto.getDepartureDateUTC());
        reservationEntity.setEmail(dto.getCustomerEmail());

        return reservationEntity;
    }
}
