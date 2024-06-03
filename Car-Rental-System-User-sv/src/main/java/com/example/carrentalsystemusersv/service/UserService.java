package com.example.carrentalsystemusersv.service;

import com.example.carrentalsystemusersv.dto.UserDto;

public interface UserService {
    UserDto addUser(UserDto userDto);
    boolean isExistEmail(String email);
}
