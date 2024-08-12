package com.example.carrentalsystembookcarsv.service.Impl;

import com.example.carrentalsystembookcarsv.dto.BookCarDto;
import com.example.carrentalsystembookcarsv.entity.BookCarEntity;
import com.example.carrentalsystembookcarsv.enums.BookCarStatus;
import com.example.carrentalsystembookcarsv.repository.BookCarRepo;
import com.example.carrentalsystembookcarsv.service.BookCarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
@Service

public class BookCarServiceImpl implements BookCarService {

    @Autowired
    private BookCarRepo bookCarRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public BookCarDto bookCarDetails(BookCarDto bookCarDto) {
        BookCarEntity carEntity=new BookCarEntity();
        carEntity.setFromDate(bookCarDto.getFromDate());
        carEntity.setToDate(bookCarDto.getToDate());
        Long diffMilliSecond=bookCarDto.getToDate().getTime()- bookCarDto.getFromDate().getTime();
        Long days=TimeUnit.MILLISECONDS.toDays(diffMilliSecond);
        carEntity.setDays(days);
        carEntity.setTotalPrice(bookCarDto.getPrice() * days);
        carEntity.setStatus(BookCarStatus.PENDING);
        carEntity.setUserId(bookCarDto.getUserId());
        carEntity.setCarId(bookCarDto.getCarId());
        BookCarEntity bookCarEntity = bookCarRepo.save(carEntity);
        return bookCarDto !=null ? modelMapper.map(bookCarEntity, BookCarDto.class) : null;

    }

    @Override
    public List<BookCarDto> getBookCarDetails(Long userId) {
        List<BookCarEntity> carEntityList = bookCarRepo.findByUserId(userId);
        return modelMapper.map(carEntityList,new TypeToken<List<BookCarDto>>(){}.getType());
    }

    @Override
    public List<BookCarDto> getAllBookCarDetails() {
        return modelMapper.map(bookCarRepo.findAll(),new TypeToken<List<BookCarDto>>(){}.getType());
    }

    @Override
    public boolean changeBookingStatus(Integer id, String status) {
        if ( bookCarRepo.existsById(id)){
            Optional<BookCarEntity> bookCarEntity = bookCarRepo.findById(id);
            BookCarEntity carEntity = bookCarEntity.get();
            if ( status.equals("Approve")){
                carEntity.setStatus(BookCarStatus.APPROVED);
            }else {
                carEntity.setStatus(BookCarStatus.REJECTED);
            }

            bookCarRepo.save(carEntity);
            return true;

        }
        return false;
    }
}
