package com.upgrade.volcano.controller;

import com.upgrade.volcano.model.dto.HomeDto;
import com.upgrade.volcano.model.dto.ResetDto;
import com.upgrade.volcano.service.CalendarService;
import com.upgrade.volcano.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    ReservationService reservationService;

    @Autowired
    CalendarService calendarService;

    @GetMapping("")
    @ResponseBody
    public HomeDto getHome() {
        HomeDto response = new HomeDto("Volcano RESTful API 0.1.0");
        return response;
    }

    @PostMapping("/reset")
    @ResponseBody
    public ResetDto reset() {
        this.calendarService.deleteAll();
        this.reservationService.deleteAll();
        this.calendarService.initialize();
        return new ResetDto(true);
    }

}
