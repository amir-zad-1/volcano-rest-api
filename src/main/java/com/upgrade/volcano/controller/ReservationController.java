package com.upgrade.volcano.controller;

import com.upgrade.volcano.contract.controller.ReservationControllerContract;
import com.upgrade.volcano.contract.service.ReservationServiceContract;
import com.upgrade.volcano.entity.Reservation;
import com.upgrade.volcano.mapper.ReservationMapper;
import com.upgrade.volcano.model.ApiJsonResponse;
import com.upgrade.volcano.model.ReservationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/reservations")
public class ReservationController implements ReservationControllerContract {

    @Autowired
    private ReservationServiceContract reservationService;

    @ResponseBody
    @GetMapping("")
    @Override
    public ApiJsonResponse<List<ReservationDto>> get() {
        List<Reservation> reservationList = reservationService.getAll();
        List<ReservationDto> reservationDtos = reservationList.stream()
                .map(reservation -> new ReservationMapper().mapToDto(reservation))
                .collect(Collectors.toList());

        ApiJsonResponse<List<ReservationDto>> response = new ApiJsonResponse<>();
        response.setBody(reservationDtos);
        return response;
    }

    @Override
    @ResponseBody
    @PostMapping("")
    public ApiJsonResponse<ReservationDto> post(@RequestBody ReservationDto reservationDto) {
        ReservationMapper reservationMapper = new ReservationMapper();
        Reservation reservationEntity = reservationMapper.mapToEntity(reservationDto);
        Reservation savedReservation = reservationService.add(reservationEntity);
        ReservationDto savedReservationDto = reservationMapper.mapToDto(savedReservation);

        ApiJsonResponse<ReservationDto> response = new ApiJsonResponse<>();
        response.setBody(savedReservationDto);
        return response;
    }

}
