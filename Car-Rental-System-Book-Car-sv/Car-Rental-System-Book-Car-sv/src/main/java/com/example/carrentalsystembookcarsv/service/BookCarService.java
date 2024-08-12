package com.example.carrentalsystembookcarsv.service;

import com.example.carrentalsystembookcarsv.dto.BookCarDto;
import com.example.carrentalsystembookcarsv.entity.BookCarEntity;

import java.util.List;

public interface BookCarService {

    BookCarDto bookCarDetails(BookCarDto bookCarDto);
    List<BookCarDto> getBookCarDetails(Long userId);

    List<BookCarDto> getAllBookCarDetails();
    boolean changeBookingStatus(Integer id, String status);
}
