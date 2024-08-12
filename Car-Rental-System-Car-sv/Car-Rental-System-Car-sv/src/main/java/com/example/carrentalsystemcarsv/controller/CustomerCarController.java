package com.example.carrentalsystemcarsv.controller;

import com.example.carrentalsystemcarsv.dto.CarDto;
import com.example.carrentalsystemcarsv.dto.SearchCarDto;
import com.example.carrentalsystemcarsv.service.CustomerService.CustomerCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/car/customer")
@CrossOrigin
public class CustomerCarController {

    @Autowired
    private CustomerCarService carService;


    @GetMapping("/get-car")
    List<CarDto> getAllCars(){
        return carService.getAllCars();
    }

    @PostMapping("/search-car")

    public List<CarDto> searchCar(@RequestBody SearchCarDto searchCarDto){
        return carService.searchCar(searchCarDto);
    }

    @GetMapping("/get-car-byId/{id}")

    public CarDto getCarByID(@PathVariable Integer id){
        return carService.getCarById(id);
    }
}
