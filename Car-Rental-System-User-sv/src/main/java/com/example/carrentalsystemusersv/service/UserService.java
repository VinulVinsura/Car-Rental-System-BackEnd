package com.example.carrentalsystemusersv.service;

import com.example.carrentalsystemusersv.dto.UserDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    UserDto addUser(UserDto userDto);
    boolean isExistEmail(String email);
    UserDto getUsrById(Long id);
    ResponseEntity<List> getRestCountries();
    ResponseEntity<Object> getCarById(Integer id);
}
