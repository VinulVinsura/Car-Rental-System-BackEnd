package com.example.carrentalsystemcarsv.service.CustomerService.Impl;

import com.example.carrentalsystemcarsv.dto.CarDto;
import com.example.carrentalsystemcarsv.dto.SearchCarDto;
import com.example.carrentalsystemcarsv.entity.CarEntity;
import com.example.carrentalsystemcarsv.repository.CarRepo;
import com.example.carrentalsystemcarsv.service.CustomerService.CustomerCarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerCarServiceImpl implements CustomerCarService {

    @Autowired
    private CarRepo carRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<CarDto> getAllCars() {
        List<CarEntity> carEntityList = carRepo.findAll();
        return modelMapper.map(carEntityList,new TypeToken<List<CarDto>>(){}.getType());

    }

    @Override
    public List<CarDto> searchCar(SearchCarDto searchCarDto) {
        ExampleMatcher exampleMatcher=
                ExampleMatcher.matchingAll()
                        .withMatcher("brand", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                        .withMatcher("type",ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                        .withMatcher("transmission",ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                        .withMatcher("color",ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());
        Example<CarEntity> carEntityExample = Example.of(modelMapper.map(searchCarDto, CarEntity.class), exampleMatcher);
        List<CarEntity> carEntityList = carRepo.findAll(carEntityExample);
        return modelMapper.map(carEntityList,new TypeToken<List<CarDto>>(){}.getType());

    }

    @Override
    public CarDto getCarById(Integer id) {
        if (carRepo.existsById(id)){
            Optional<CarEntity> carEntity = carRepo.findById(id);
            return modelMapper.map(carEntity, CarDto.class);
        }
        return null;
    }
}
