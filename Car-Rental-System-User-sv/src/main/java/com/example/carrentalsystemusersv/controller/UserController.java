package com.example.carrentalsystemusersv.controller;

import com.example.carrentalsystemusersv.dto.LoginDetailsDto;
import com.example.carrentalsystemusersv.dto.UserDto;
import com.example.carrentalsystemusersv.enums.UserRole;
import com.example.carrentalsystemusersv.service.LoginService;
import com.example.carrentalsystemusersv.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final LoginService loginService;

    @PostMapping("/add-user")
    public UserDto addUser(@RequestBody UserDto userDto){

        if (userDto.getEmail()!=null &&
            userDto.getPassword()!=null &&
            userDto.getUsername()!=null){
            if (userService.isExistEmail(userDto.getEmail())){
                return null;
            }else {
                UserDto user = userService.addUser(userDto);
                loginService.addLoginDetails(new LoginDetailsDto(null,
                                             userDto.getEmail(),
                                             userDto.getPassword(),
                                             UserRole.Admin));
                return user;
            }
        }
        return null;
    }

    @GetMapping("/get-user-byId/{id}")

    public UserDto getUserById(@PathVariable Long id){
        return userService.getUsrById(id);
    }

    @GetMapping("/getRestCountries")    //

    public ResponseEntity<List> getRestCountries(){
        System.out.println("1");
        ResponseEntity<List> restCountries = userService.getRestCountries();
        return restCountries;

    }

    @GetMapping("/getCarById/{id}")
    public ResponseEntity<Object> getAllCars(@PathVariable Integer id){
        return userService.getCarById(id);



    }


}
