package com.upgrade.volcano.restapi.contract;

import com.upgrade.volcano.model.Reservation;

import java.util.ArrayList;

public interface ReservationControllerContract {

    ArrayList<Reservation> getAllReservations();
}
