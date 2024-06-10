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
    public Boolean addLoginDetails(LoginDetailsDto dto) {
        repo.save(modelMapper.map(dto, LoginEntity.class));
        return true;

    }

    @Override
    public LoginDetailsDto loginValidation(LoginDetailsDto dto) {
        System.out.println("1");
        Boolean isExist = repo.existsByEmailAndPassword(dto.getEmail(), dto.getPassword());
        if (isExist){
            LoginEntity loginEntity = repo.findByEmailAndPassword(dto.getEmail(), dto.getPassword());
            System.out.println(loginEntity);
            return modelMapper.map(loginEntity, LoginDetailsDto.class);
        }
        return null;
    }
}
