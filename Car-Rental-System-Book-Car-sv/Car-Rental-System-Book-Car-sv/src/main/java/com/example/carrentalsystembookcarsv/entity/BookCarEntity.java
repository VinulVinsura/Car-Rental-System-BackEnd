package com.example.carrentalsystembookcarsv.entity;

import com.example.carrentalsystembookcarsv.enums.BookCarStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Book_Car")
public class BookCarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date fromDate;
    private Date toDate;
    private Long days;
    private Long totalPrice;
    private BookCarStatus status;
    private Long userId;
    private Integer carId;
}
