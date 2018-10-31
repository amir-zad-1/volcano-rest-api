package com.upgrade.volcano.controller;

import com.upgrade.volcano.model.dto.HomeDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping("")
    @ResponseBody
    public HomeDto getHome() {
        HomeDto response = new HomeDto("Volcano RESTful API 0.1.0");
        return response;
    }

}
