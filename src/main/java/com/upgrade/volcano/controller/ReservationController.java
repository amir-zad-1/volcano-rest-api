package com.upgrade.volcano.controller;

import com.upgrade.volcano.contract.controller.ReservationControllerContract;
import com.upgrade.volcano.contract.service.ReservationServiceContract;
import com.upgrade.volcano.model.dto.ReservationDto;
import com.upgrade.volcano.model.dto.ReservationRequestDto;
import com.upgrade.volcano.model.dto.ReservationResponseDto;
import com.upgrade.volcano.model.entity.Reservation;
import com.upgrade.volcano.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/reservations")
public class ReservationController implements ReservationControllerContract {

    @Autowired
    private ReservationServiceContract reservationService;

    @Autowired
    private CalendarService calendarService;

    @ResponseBody
    @GetMapping("/availabledates")
    @Override
    public List<Date> getAvailableDates() {
        return calendarService.getAvailableDates();
    }

    @ResponseBody
    @GetMapping("")
    @Override
    public List<ReservationDto> getAll() {
        List<Reservation> reservationList = reservationService.getAll();
        return reservationList.stream()
                .map(ReservationResponseDto::new)
                .collect(Collectors.toList());
    }

    @ResponseBody
    @PostMapping("")
    @Override
    public ReservationResponseDto book(@Valid @RequestBody ReservationRequestDto reservationRequest) {
        Reservation reservation;
        try {
            reservation = reservationRequest.toResevation();
            this.reservationService.book(reservation);
        } catch (NotValidException | NotAvailableException e) {
            throw new Http400Exception(e.getMessage());
        }
        return new ReservationResponseDto(reservation);
    }

    @ResponseBody
    @PutMapping("")
    @Override
    public ReservationResponseDto update(@Valid @RequestBody ReservationRequestDto reservationRequest) {
        return null;
    }

    @ResponseBody
    @DeleteMapping("/{reservationid}")
    @Override
    public Boolean cancel(@PathVariable("reservationid") long reservationid) {
        return false;
    }


    @ResponseBody
    @GetMapping("/{reservationid}")
    @Override
    public ReservationDto getById(@PathVariable("reservationid") long reservationid) {
        return null;
    }

}
