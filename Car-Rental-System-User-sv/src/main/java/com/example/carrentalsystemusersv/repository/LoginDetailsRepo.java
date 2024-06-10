package com.example.carrentalsystemusersv.repository;

import com.example.carrentalsystemusersv.dto.LoginDetailsDto;
import com.example.carrentalsystemusersv.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDetailsRepo extends JpaRepository<LoginEntity,Long> {

    Boolean existsByEmailAndPassword(String email, String password);
    LoginEntity findByEmailAndPassword(String email, String password);
}
