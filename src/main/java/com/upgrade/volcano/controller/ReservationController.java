package com.upgrade.volcano.controller;

import com.upgrade.volcano.contract.controller.ReservationControllerContract;
import com.upgrade.volcano.contract.service.ReservationServiceContract;
import com.upgrade.volcano.entity.Reservation;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@Configuration
@EnableAutoConfiguration
@ComponentScan

@RestController
@RequestMapping("/")
public class ReservationController implements ReservationControllerContract {

    private ReservationServiceContract reservationService;

    public ReservationController() {
        this.reservationService = new com.upgrade.volcano.service.ReservationService();
    }

    @ResponseBody
    @RequestMapping("") // todo: sample endpoints
    public ArrayList<Reservation> getAllReservations() {
        ArrayList<Reservation> result = reservationService.getAll();
        return result;
    }

}
