package com.example.carrentalsystemcarsv.controller;

import com.example.carrentalsystemcarsv.annotation.AuditTime;
import com.example.carrentalsystemcarsv.dto.CarDto;
import com.example.carrentalsystemcarsv.dto.SearchCarDto;
import com.example.carrentalsystemcarsv.service.AdminService.AdminCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/car")
@CrossOrigin
public class AdminCarController {
    @Autowired
    private AdminCarService carService;

    @PostMapping("/add-car")
    public CarDto addCar(@RequestParam("brand") String brand,
                         @RequestParam("name") String name,
                         @RequestParam("type") String type,
                         @RequestParam("transmission") String transmission,
                         @RequestParam("color") String color,
                         @RequestParam("year") String  year,
                         @RequestParam("description") String description,
                         @RequestParam("price") Integer price,
                         @RequestParam("image") MultipartFile file) throws IOException {

        CarDto carDto=new CarDto();

        carDto.setBrand(brand);
        carDto.setName(name);
        carDto.setType(type);
        carDto.setTransmission(transmission);
        carDto.setColor(color);
        carDto.setYear(year);
        carDto.setDescription(description);
        carDto.setPrice(price);
        carDto.setImage(file);
        System.out.println(carDto);
        return carService.addCar(carDto);


    }

    @GetMapping("/get-all-cars")
    @AuditTime       // Creat our Annotation
    public List<CarDto> getAllCar(){
        return carService.getAllCar();
    }

    @DeleteMapping("/delete-car/{id}")
    public String deleteCarById(@PathVariable Integer id){
        if (carService.deleteCar(id)){
            return "Car Deleted !";
        }
        return "Car Not Deleted !";
    }


    @GetMapping("/get-carById/{id}")
    public CarDto getCarById(@PathVariable Integer id){
       
        CarDto carDto = carService.getCarById(id);
        if (carDto !=null){
            return carDto;
        }
        return null;
    }

    @PutMapping("update-car")
    public CarDto updateCar(@RequestBody CarDto carDto){
        return carService.updateCar(carDto);
    }


    @PostMapping("/search-car") // Search car api
    public List<CarDto> searchCar(@RequestBody SearchCarDto searchCarDto){
               return carService.searchCar(searchCarDto);
    }

}
