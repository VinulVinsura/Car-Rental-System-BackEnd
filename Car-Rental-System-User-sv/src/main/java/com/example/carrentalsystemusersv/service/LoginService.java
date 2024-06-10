package com.example.carrentalsystemusersv.service;

import com.example.carrentalsystemusersv.dto.LoginDetailsDto;

public interface LoginService {
    Boolean addLoginDetails(LoginDetailsDto dto);
    LoginDetailsDto loginValidation(LoginDetailsDto dto);
}
