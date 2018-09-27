package com.upgrade.volcano.contract.controller;

import com.upgrade.volcano.model.ApiJsonResponse;
import com.upgrade.volcano.model.ReservationDto;

import java.util.List;

public interface ReservationControllerContract {

    ApiJsonResponse<List<ReservationDto>> getAllReservations();
}
