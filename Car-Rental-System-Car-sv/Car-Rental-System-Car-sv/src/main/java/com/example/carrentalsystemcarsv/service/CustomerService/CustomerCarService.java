package com.example.carrentalsystemcarsv.service.CustomerService;

import com.example.carrentalsystemcarsv.dto.CarDto;
import com.example.carrentalsystemcarsv.dto.SearchCarDto;

import java.util.List;

public interface CustomerCarService {
    List<CarDto> getAllCars();
    List<CarDto> searchCar(SearchCarDto searchCarDto);

    CarDto getCarById(Integer id);
}
