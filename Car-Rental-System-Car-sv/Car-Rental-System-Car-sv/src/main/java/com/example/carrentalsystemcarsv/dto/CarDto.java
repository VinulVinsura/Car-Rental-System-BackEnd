package com.example.carrentalsystemcarsv.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {

    private Integer id;
    private String brand;
    private String name;
    private String type;
    private String transmission;
    private String color;
    private String year;
    private String description;
    private Integer price;
    private MultipartFile image;
    private byte[] img;
}
