package com.example.carrentalsystemusersv.controller;

import com.example.carrentalsystemusersv.dto.UserDto;
import com.example.carrentalsystemusersv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add-user")
    public UserDto addUser(@RequestBody UserDto userDto){
         return userService.addUser(userDto);
    }

}
