package com.example.carrentalsystemcarsv.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.Scanner;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Car")

public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String brand;
    private String name;
    private String type;
    private String transmission;
    private String color;
    private String year;
    private String description;
    private Integer price;
    @Column(columnDefinition = "longblob")
    private byte[]  img;

}
