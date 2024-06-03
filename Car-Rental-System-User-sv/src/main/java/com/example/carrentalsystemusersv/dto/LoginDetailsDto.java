package com.example.carrentalsystemusersv.dto;

import com.example.carrentalsystemusersv.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDetailsDto {
    private String email;
    private String password;
    private UserRole userRole;
}
