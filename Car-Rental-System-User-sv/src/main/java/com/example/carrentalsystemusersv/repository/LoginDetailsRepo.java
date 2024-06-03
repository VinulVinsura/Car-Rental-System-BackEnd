package com.example.carrentalsystemusersv.repository;

import com.example.carrentalsystemusersv.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginDetailsRepo extends JpaRepository<LoginEntity,Long> {
}
