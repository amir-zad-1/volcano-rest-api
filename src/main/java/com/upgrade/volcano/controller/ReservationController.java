package com.upgrade.volcano.controller;

import com.upgrade.volcano.contract.controller.ReservationControllerContract;
import com.upgrade.volcano.contract.service.ReservationServiceContract;
import com.upgrade.volcano.entity.Reservation;
import com.upgrade.volcano.mapper.ReservationMapper;
import com.upgrade.volcano.model.ApiJsonResponse;
import com.upgrade.volcano.model.ReservationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/reservation")
public class ReservationController implements ReservationControllerContract {

    @Autowired
    private ReservationServiceContract reservationService;

    @ResponseBody
    @RequestMapping("")
    public ApiJsonResponse<List<ReservationDto>> getAllReservations() {

        ApiJsonResponse<List<ReservationDto>> response = new ApiJsonResponse<>();

        List<Reservation> reservationList = reservationService.getAll();
        List<ReservationDto> reservationDtos = reservationList.stream()
                .map(reservation -> new ReservationMapper().mapToDto(reservation))
                .collect(Collectors.toList());
        response.setBody(reservationDtos);
        return response;
    }

}
