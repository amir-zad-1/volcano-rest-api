package com.upgrade.volcano.contract.controller;

import com.upgrade.volcano.model.ApiJsonResponse;
import com.upgrade.volcano.model.ReservationDto;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface ReservationControllerContract {

    ApiJsonResponse<List<ReservationDto>> get();
    ApiJsonResponse<ReservationDto> getById(@PathVariable("userid") long userid);
    ApiJsonResponse<ReservationDto> post(ReservationDto reservation, HttpServletResponse httpservletresponse);
    ApiJsonResponse<ReservationDto> put(ReservationDto reservation, HttpServletResponse httpservletresponse);
    ApiJsonResponse<Boolean> delete(ReservationDto reservation, HttpServletResponse httpservletresponse);
}
