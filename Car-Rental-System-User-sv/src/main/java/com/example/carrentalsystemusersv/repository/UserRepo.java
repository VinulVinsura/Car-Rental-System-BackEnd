package com.example.carrentalsystemusersv.repository;

import com.example.carrentalsystemusersv.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity,Long> {
    boolean existsByEmail(String email);

}
