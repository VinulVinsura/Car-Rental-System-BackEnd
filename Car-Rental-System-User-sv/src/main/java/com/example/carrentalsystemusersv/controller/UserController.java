package com.example.carrentalsystemusersv.controller;

import com.example.carrentalsystemusersv.dto.LoginDetailsDto;
import com.example.carrentalsystemusersv.dto.UserDto;
import com.example.carrentalsystemusersv.enums.UserRole;
import com.example.carrentalsystemusersv.service.LoginService;
import com.example.carrentalsystemusersv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private LoginService loginService;

    @PostMapping("/add-user")
    public UserDto addUser(@RequestBody UserDto userDto){
        if (userService.isExistEmail(userDto.getEmail())){
            return null;
        }else {
            UserDto user = userService.addUser(userDto);
            if (user!=null){
                loginService.addLoginDetails(new LoginDetailsDto(userDto.getEmail(),
                        userDto.getPassword(),
                        UserRole.Customer));
                return user;
            }
            return null;
        }


    }

}
