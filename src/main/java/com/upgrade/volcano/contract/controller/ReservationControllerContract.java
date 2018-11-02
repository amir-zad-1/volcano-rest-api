package com.upgrade.volcano.contract.controller;

import com.upgrade.volcano.model.dto.*;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

public interface ReservationControllerContract {

    List<Date> getAvailableDates ();

    List<ReservationResponseDto> getAll ();

    ReservationResponseDto getById(long reservationid);

    ReservationResponseDto book(ReservationRequestDto reservationRequest);

    ReservationResponseDto update(ReservationUpdateRequestDto reservationRequest);

    ReservationCancelResponse cancel(long reservationid);
}
