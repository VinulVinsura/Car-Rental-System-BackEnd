package com.example.carrentalsystemusersv.controller;

import ch.qos.logback.classic.spi.ConfiguratorRank;
import com.example.carrentalsystemusersv.dto.LoginDetailsDto;
import com.example.carrentalsystemusersv.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
@CrossOrigin

public class LoginController {
    @Autowired
    private LoginService loginService;
    @PostMapping("/validation")
    public LoginDetailsDto loginValidation(@RequestBody LoginDetailsDto dto){

       return loginService.loginValidation(dto);
    }

}
