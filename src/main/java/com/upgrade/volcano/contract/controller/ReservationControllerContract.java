package com.upgrade.volcano.contract.controller;

import com.upgrade.volcano.model.dto.ReservationDto;
import com.upgrade.volcano.model.dto.ReservationRequestDto;
import com.upgrade.volcano.model.dto.ReservationResponseDto;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

public interface ReservationControllerContract {

    List<Date> getAvailableDates ();

    List<ReservationDto> getAll ();

    ReservationDto getById(long reservationid);

    ReservationResponseDto book(ReservationRequestDto reservationRequest);

    ReservationResponseDto update(ReservationRequestDto reservationRequest);

    Boolean cancel(long reservationid);
}
