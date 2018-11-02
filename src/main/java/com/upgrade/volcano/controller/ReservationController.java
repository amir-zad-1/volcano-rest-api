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
    public List<Date> getAvailableDates () {
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
        Reservation r = new Reservation(10L, reservationRequest.getCustomerEmail(),
                reservationRequest.getArrivalDate(),
                reservationRequest.getArrivalDate()
        );
        return new ReservationResponseDto(r);
    }

    @ResponseBody
    @PutMapping("")
    @Override
    public ReservationResponseDto update(@Valid @RequestBody ReservationRequestDto reservationRequest) {
        Reservation r = new Reservation(11L, reservationRequest.getCustomerEmail(),
                reservationRequest.getArrivalDate(),
                reservationRequest.getArrivalDate()
        );
        return new ReservationResponseDto(r);
    }

    @ResponseBody
    @DeleteMapping("/{reservationid}")
    @Override
    public ReservationResponseDto cancel(@PathVariable("reservationid") long reservationid) {
        Reservation r = new Reservation(12L, "email",
                new Date(),
                new Date()
        );
        return new ReservationResponseDto(r);
    }


    @ResponseBody
    @GetMapping("/{reservationid}")
    @Override
    public ReservationDto getById(@PathVariable("reservationid") long reservationid) {
        Reservation r = new Reservation(13L, "email",
                new Date(),
                new Date()
        );
        return new ReservationResponseDto(r);
    }

}
