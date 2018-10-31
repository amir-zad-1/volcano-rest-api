package com.upgrade.volcano.contract.controller;

import com.upgrade.volcano.model.dto.ReservationDto;
import com.upgrade.volcano.model.dto.ReservationRequestDto;
import com.upgrade.volcano.model.dto.ReservationResponseDto;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface ReservationControllerContract {

    List<ReservationDto> getAllReservations();

    //    ReservationDto getById(@PathVariable("userid") long userid);
    ReservationResponseDto book(ReservationRequestDto reservationRequest);
//    ReservationDto put(ReservationDto reservation, HttpServletResponse httpservletresponse);
//    Boolean delete(ReservationDto reservation, HttpServletResponse httpservletresponse);
}
