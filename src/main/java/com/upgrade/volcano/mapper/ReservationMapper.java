package com.upgrade.volcano.mapper;

import com.upgrade.volcano.contract.mapper.MapperContract;
import com.upgrade.volcano.entity.Reservation;
import com.upgrade.volcano.model.ReservationDto;

public class ReservationMapper implements MapperContract<Reservation, ReservationDto> {


    @Override
    public ReservationDto mapToDto(Reservation entity) {
        ReservationDto reservationDto = new ReservationDto();

        reservationDto.setId(entity.getId());
        reservationDto.setArrivalDateUTC(entity.getArrivalDateUTC());
        reservationDto.setCustomerEmail(entity.getCustomer().getEmail());
        reservationDto.setDepartureDateUTC(entity.getDepartureDateUTC());
        reservationDto.setReservationDateUTC(entity.getReservationDateUTC());

        return reservationDto;
    }

    @Override
    public Reservation mapToEntity(ReservationDto dto) {
        return null;
    }
}
