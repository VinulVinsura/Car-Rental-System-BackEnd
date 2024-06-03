package com.example.carrentalsystemusersv.service.Impl;

import com.example.carrentalsystemusersv.dto.LoginDetailsDto;
import com.example.carrentalsystemusersv.entity.LoginEntity;
import com.example.carrentalsystemusersv.repository.LoginDetailsRepo;
import com.example.carrentalsystemusersv.service.LoginService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDetailsRepo repo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public void addLoginDetails(LoginDetailsDto dto) {
        repo.save(modelMapper.map(dto, LoginEntity.class));
    }
}
