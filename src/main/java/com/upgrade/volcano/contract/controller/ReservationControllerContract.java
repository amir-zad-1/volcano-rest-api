package com.upgrade.volcano.contract.controller;

import com.upgrade.volcano.model.dto.ReservationDto;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface ReservationControllerContract {

    List<ReservationDto> get();
    ReservationDto getById(@PathVariable("userid") long userid);
    ReservationDto post(ReservationDto reservation, HttpServletResponse httpservletresponse);
    ReservationDto put(ReservationDto reservation, HttpServletResponse httpservletresponse);
    Boolean delete(ReservationDto reservation, HttpServletResponse httpservletresponse);
}
