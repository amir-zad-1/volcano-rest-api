package com.upgrade.volcano.restapi;

import com.upgrade.volcano.model.Reservation;
import com.upgrade.volcano.contract.service.ReservationServiceContract;
import com.upgrade.volcano.restapi.contract.ReservationControllerContract;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@Controller

@RestController
@RequestMapping("/")
public class ReservationController implements ReservationControllerContract {

    private ReservationServiceContract reservationService;

    public ReservationController() {
        this.reservationService = new com.upgrade.volcano.service.ReservationService();
    }

    @ResponseBody
    @RequestMapping("")
    public ArrayList<Reservation> getAllReservations() {
        System.out.println("here");
        ArrayList<Reservation> result = reservationService.getAll();
        return result;
    }

}
