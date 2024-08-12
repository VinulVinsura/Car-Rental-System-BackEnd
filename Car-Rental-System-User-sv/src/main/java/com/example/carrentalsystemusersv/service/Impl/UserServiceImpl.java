package com.example.carrentalsystemusersv.service.Impl;

import com.example.carrentalsystemusersv.dto.UserDto;
import com.example.carrentalsystemusersv.entity.UserEntity;
import com.example.carrentalsystemusersv.repository.UserRepo;
import com.example.carrentalsystemusersv.service.UserService;
import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    private final ModelMapper modelMapper;

    private final RestTemplate restTemplate;
    @Override

    public UserDto addUser(UserDto userDto) {
        UserEntity userEntity = userRepo.save(modelMapper.map(userDto, UserEntity.class));
        return modelMapper.map(userEntity, UserDto.class);
    }

    @Override
    public boolean isExistEmail(String email) {
       return userRepo.existsByEmail(email);

    }

    @Override
    public UserDto getUsrById(Long id) {
         return modelMapper.map( userRepo.findById(id), UserDto.class);

    }

    @Override    // creat restTemplate find anoth database asses
    public ResponseEntity<List> getRestCountries() {
        ResponseEntity<List> exchange = restTemplate.exchange("https://restcountries.com/v3.1/all",
                HttpMethod.GET, null, List.class);
        System.out.println(3);
        return exchange;

    }

    @Override
    public ResponseEntity<Object> getCarById(Integer id) {


        System.out.println(2);
        ResponseEntity<Object> exchange = restTemplate.exchange("http://localhost:9001/api/car/customer/get-car-byId/" + id,
                HttpMethod.GET, null, Object.class);
        System.out.println(3);
        return  exchange;
    }


}
