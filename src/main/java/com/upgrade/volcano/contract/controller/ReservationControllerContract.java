package com.upgrade.volcano.contract.controller;

import com.upgrade.volcano.model.dto.ApiJsonResponse;
import com.upgrade.volcano.model.dto.ReservationDto;
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
