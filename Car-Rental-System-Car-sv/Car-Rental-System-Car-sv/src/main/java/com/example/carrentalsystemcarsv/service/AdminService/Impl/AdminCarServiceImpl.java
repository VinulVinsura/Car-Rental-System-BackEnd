package com.example.carrentalsystemcarsv.service.AdminService.Impl;

import com.example.carrentalsystemcarsv.dto.CarDto;
import com.example.carrentalsystemcarsv.dto.SearchCarDto;
import com.example.carrentalsystemcarsv.entity.CarEntity;
import com.example.carrentalsystemcarsv.repository.CarRepo;
import com.example.carrentalsystemcarsv.service.AdminService.AdminCarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Service
public class AdminCarServiceImpl implements AdminCarService {
    @Autowired
    private CarRepo carRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CarDto addCar(CarDto carDto) throws IOException {
        CarEntity carEntity=new CarEntity();
        carEntity.setBrand(carDto.getBrand());
        carEntity.setName(carDto.getName());
        carEntity.setColor(carDto.getColor());
        carEntity.setDescription(carDto.getDescription());
        carEntity.setPrice(carDto.getPrice());
        carEntity.setYear(carDto.getYear());
        carEntity.setType(carDto.getType());
        carEntity.setTransmission(carDto.getTransmission());
        String fileName=StringUtils.cleanPath(carDto.getImage().getOriginalFilename());
        if (carDto.getImage()!=null){
            carEntity.setImg(carDto.getImage().getBytes());
        }
        CarEntity car = carRepo.save(carEntity);
//Creat a folder path for save Image
        String uploadDir="./car-img/"+car.getId();
        Path uploadPath=Paths.get(uploadDir);
        if (!Files.exists(uploadPath)){
            Files.createDirectories(uploadPath);
        }
       try ( InputStream inputStream=carDto.getImage().getInputStream()) {
           Path filePath=uploadPath.resolve(fileName);
           Files.copy(inputStream,filePath, StandardCopyOption.REPLACE_EXISTING);
       }catch (IOException e){
           throw new IOException("Could not save upload File" +fileName);
       }
       return modelMapper.map(car, CarDto.class);

    }

    @Override
    public List<CarDto> getAllCar() {
        List<CarEntity> allCars = carRepo.findAll();
        return modelMapper.map(allCars,new TypeToken<List<CarDto>>(){}.getType());
    }

    @Override
    public Boolean deleteCar(Integer id) {
        if (carRepo.existsById(id)){
            carRepo.deleteById(id);

            return true;
        }
        return false;
    }

    @Override
    public CarDto getCarById(Integer id) {
        return modelMapper.map(carRepo.findById(id), CarDto.class);
    }

    @Override
    public CarDto updateCar(CarDto carDto) {
        if (carRepo.existsById(carDto.getId())){
            Optional<CarEntity> carEntity = carRepo.findById(carDto.getId());
            CarEntity car = carEntity.get();
            car.setBrand(carDto.getBrand());
            car.setName(carDto.getName());
            car.setType(carDto.getType());
            car.setPrice(carDto.getPrice());
            car.setYear(carDto.getYear());
            car.setTransmission(carDto.getTransmission());
            car.setColor(carDto.getColor());
            car.setDescription(carDto.getDescription());
            return modelMapper.map(carRepo.save(car), CarDto.class);

        }
        return null;
    }

    @Override
    public List<CarDto> searchCar(SearchCarDto searchCarDto) {
        ExampleMatcher exampleMatcher=
                ExampleMatcher.matchingAll()
                        .withMatcher("brand",ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                        .withMatcher("type",ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                        .withMatcher("transmission",ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                        .withMatcher("color",ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());
        Example<CarEntity> carEntityExample=Example.of(modelMapper.map(searchCarDto, CarEntity.class),exampleMatcher);

        List<CarEntity> carEntityList = carRepo.findAll(carEntityExample);
      
       return modelMapper.map(carEntityList,new TypeToken<List<CarDto>>(){}.getType());

    }
}
