package com.upgrade.volcano.controller;

import com.upgrade.volcano.contract.controller.ReservationControllerContract;
import com.upgrade.volcano.contract.service.ReservationServiceContract;
import com.upgrade.volcano.model.entity.Reservation;
import com.upgrade.volcano.model.mapper.ReservationMapper;
import com.upgrade.volcano.model.dto.ApiJsonResponse;
import com.upgrade.volcano.model.dto.ReservationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
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

    @ResponseBody
    @GetMapping("/{reservationid}")
    @Override
    public ApiJsonResponse<ReservationDto> getById(@PathVariable("reservationid") long reservationid) {
        if (reservationid < 1) {
            throw new Http404Exception();
        }
        Reservation reservation = reservationService.get(reservationid);
        if (reservation == null) {
            throw new Http404Exception();
        }
        ApiJsonResponse<ReservationDto> response = new ApiJsonResponse<>();
        ReservationMapper reservationMapper = new ReservationMapper();
        response.setBody(reservationMapper.mapToDto(reservation));
        return response;
    }

    @Override
    @ResponseBody
    @PostMapping("")
    public ApiJsonResponse<ReservationDto> post(@RequestBody ReservationDto reservationDto, HttpServletResponse httpresponse) {
        if (reservationDto.getId() > 0) {
            throw new Http500Exception();
        }
        ReservationMapper reservationMapper = new ReservationMapper();
        Reservation reservationEntity = reservationMapper.mapToEntity(reservationDto);
        Reservation createReservation = reservationService.add(reservationEntity);
        ReservationDto createReservationDto = reservationMapper.mapToDto(createReservation);

        ApiJsonResponse<ReservationDto> response = new ApiJsonResponse<>();
        response.setBody(createReservationDto);
        httpresponse.setStatus(HttpServletResponse.SC_CREATED);
        return response;
    }

    @Override
    @ResponseBody
    @PutMapping("")
    public ApiJsonResponse<ReservationDto> put(@RequestBody ReservationDto reservationDto, HttpServletResponse httpservletresponse) {
        if (reservationDto.getId() == 0) {
            throw new Http500Exception();
        }
        ReservationMapper reservationMapper = new ReservationMapper();
        Reservation reservationEntity = reservationMapper.mapToEntity(reservationDto);
        Reservation updateReservation = reservationService.update(reservationEntity);
        if (updateReservation == null) {
            httpservletresponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return null;
        } else {
            ReservationDto updateReservationDto = reservationMapper.mapToDto(updateReservation);
            ApiJsonResponse<ReservationDto> response = new ApiJsonResponse<>();
            response.setBody(updateReservationDto);
            httpservletresponse.setStatus(HttpServletResponse.SC_OK);
            return response;
        }
    }

    @Override
    @ResponseBody
    @DeleteMapping("")
    public ApiJsonResponse<Boolean> delete(@RequestBody ReservationDto reservationDto, HttpServletResponse httpservletresponse) {
        boolean deleteResult = reservationService.delete(reservationDto.getId());
        if (deleteResult) {
            httpservletresponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } else {
            httpservletresponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
        return null;
    }

}
