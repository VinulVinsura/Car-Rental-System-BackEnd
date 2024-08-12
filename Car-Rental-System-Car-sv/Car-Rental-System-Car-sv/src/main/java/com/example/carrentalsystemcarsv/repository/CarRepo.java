package com.example.carrentalsystemcarsv.repository;

import com.example.carrentalsystemcarsv.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface CarRepo extends JpaRepository<CarEntity,Integer> {

    List<CarEntity> findAllByBrandOrTypeOrColorOrTransmission(String brand ,String type ,String color, String transmission);

}
