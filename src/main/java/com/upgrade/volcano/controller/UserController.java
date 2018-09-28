package com.upgrade.volcano.controller;

import com.upgrade.volcano.contract.service.UserServiceContract;
import com.upgrade.volcano.contract.controller.UserControllerContract;
import com.upgrade.volcano.model.ApiJsonResponse;
import com.upgrade.volcano.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController implements UserControllerContract {

    @Autowired
    private UserServiceContract customerService;

    @GetMapping("")
    @ResponseBody
    public ApiJsonResponse<UserDto> getCurrentUser() {
        ApiJsonResponse<UserDto> response = new ApiJsonResponse<>();
        UserDto currentCustomerDto = null;
        response.setBody(currentCustomerDto);
        return response;
    }

}
