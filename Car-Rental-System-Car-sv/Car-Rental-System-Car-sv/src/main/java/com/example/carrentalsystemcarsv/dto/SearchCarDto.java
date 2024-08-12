package com.example.carrentalsystemcarsv.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchCarDto {
    private String brand;
    private String type;
    private String transmission;
    private String color;
}
