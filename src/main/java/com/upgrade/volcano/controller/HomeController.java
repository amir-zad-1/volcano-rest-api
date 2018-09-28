package com.upgrade.volcano.controller;

import com.upgrade.volcano.model.ApiJsonResponse;
import com.upgrade.volcano.model.RootRouteDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping("")
    @ResponseBody
    public ApiJsonResponse<RootRouteDto> getHome() {
        ApiJsonResponse<RootRouteDto> response = new ApiJsonResponse<>();
        RootRouteDto responseBody = new RootRouteDto("Volcano RESTful API 0.1.0");
        response.setBody(responseBody);
        return response;
    }

}
