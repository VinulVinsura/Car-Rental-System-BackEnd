package com.example.carrentalsystembookcarsv.dto;

import com.example.carrentalsystembookcarsv.enums.BookCarStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.lang.annotation.Aspect;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookCarDto {
    private Integer id;
    private Date fromDate;
    private Date toDate;
    private Long price;
    private Long userId;
    private Integer carId;
    private Long days;
    private BookCarStatus status;

}
