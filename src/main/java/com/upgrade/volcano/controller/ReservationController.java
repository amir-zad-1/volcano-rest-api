package com.upgrade.volcano.controller;

import com.upgrade.volcano.contract.controller.ReservationControllerContract;
import com.upgrade.volcano.contract.service.ReservationServiceContract;
import com.upgrade.volcano.model.dto.ReservationDto;
import com.upgrade.volcano.model.dto.ReservationRequestDto;
import com.upgrade.volcano.model.dto.ReservationResponseDto;
import com.upgrade.volcano.model.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public List<ReservationDto> getAllReservations() {
        List<Reservation> reservationList = reservationService.getAll();
        List<ReservationDto> reservationDtoList = reservationList.stream()
                .map(reservation -> new ReservationResponseDto(reservation))
                .collect(Collectors.toList());
        return reservationDtoList;
    }

    @ResponseBody
    @PostMapping("")
    @Override
    public ReservationResponseDto book(@Valid @RequestBody ReservationRequestDto reservationRequest) {
        Reservation r = new Reservation(10L, reservationRequest.getCustomerEmail(),
                reservationRequest.getArrivalDate(),
                reservationRequest.getArrivalDate()
                );

        return new ReservationResponseDto(r);
    }


//    @ResponseBody
//    @GetMapping("/{reservationid}")
//    @Override
//    public ReservationDto getById(@PathVariable("reservationid") long reservationid) {
////        if (reservationid < 1) {
////            throw new Http404Exception();
////        }
////        Reservation reservation = reservationService.get(reservationid);
////        if (reservation == null) {
////            throw new Http404Exception();
////        }
////        ApiJsonResponse<ReservationDto> response = new ApiJsonResponse<>();
////        ReservationMapper reservationMapper = new ReservationMapper();
////        response.setBody(reservationMapper.mapToDto(reservation));
////        return response;
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    @ResponseBody
//    @PostMapping("")
//    public ReservationDto post(@RequestBody ReservationDto reservationDto, HttpServletResponse httpresponse) {
////        if (reservationDto.getId() > 0) {
////            throw new Http500Exception();
////        }
////        ReservationMapper reservationMapper = new ReservationMapper();
////        Reservation reservationEntity = reservationMapper.mapToEntity(reservationDto);
////        Reservation createReservation = reservationService.add(reservationEntity);
////        ReservationDto createReservationDto = reservationMapper.mapToDto(createReservation);
////
////        ApiJsonResponse<ReservationDto> response = new ApiJsonResponse<>();
////        response.setBody(createReservationDto);
////        httpresponse.setStatus(HttpServletResponse.SC_CREATED);
////        return response;
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    @ResponseBody
//    @PutMapping("")
//    public ReservationDto put(@RequestBody ReservationDto reservationDto, HttpServletResponse httpservletresponse) {
////        if (reservationDto.getId() == 0) {
////            throw new Http500Exception();
////        }
////        ReservationMapper reservationMapper = new ReservationMapper();
////        Reservation reservationEntity = reservationMapper.mapToEntity(reservationDto);
////        Reservation updateReservation = reservationService.update(reservationEntity);
////        if (updateReservation == null) {
////            httpservletresponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
////            return null;
////        } else {
////            ReservationDto updateReservationDto = reservationMapper.mapToDto(updateReservation);
////            ApiJsonResponse<ReservationDto> response = new ApiJsonResponse<>();
////            response.setBody(updateReservationDto);
////            httpservletresponse.setStatus(HttpServletResponse.SC_OK);
////            return response;
////        }
//        throw new UnsupportedOperationException();
//    }
//
//    @Override
//    @ResponseBody
//    @DeleteMapping("")
//    public Boolean delete(@RequestBody ReservationDto reservationDto, HttpServletResponse httpservletresponse) {
////        boolean deleteResult = reservationService.delete(reservationDto.getId());
////        if (deleteResult) {
////            httpservletresponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
////        } else {
////            httpservletresponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
////        }
////        return null;
//        throw new UnsupportedOperationException();
//    }

}
