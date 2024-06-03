package com.example.carrentalsystemusersv.service.Impl;

import com.example.carrentalsystemusersv.dto.UserDto;
import com.example.carrentalsystemusersv.entity.UserEntity;
import com.example.carrentalsystemusersv.repository.UserRepo;
import com.example.carrentalsystemusersv.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override

    public UserDto addUser(UserDto userDto) {
        UserEntity userEntity = userRepo.save(modelMapper.map(userDto, UserEntity.class));
        return modelMapper.map(userEntity, UserDto.class);
    }

    @Override
    public boolean isExistEmail(String email) {
       return userRepo.existsByEmail(email);

    }
}
