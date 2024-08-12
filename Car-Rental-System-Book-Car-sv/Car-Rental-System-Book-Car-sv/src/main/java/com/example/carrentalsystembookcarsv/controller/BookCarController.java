package com.example.carrentalsystembookcarsv.controller;

import com.example.carrentalsystembookcarsv.dto.BookCarDto;
import com.example.carrentalsystembookcarsv.service.BookCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/book-car")
@RestController
@CrossOrigin
public class BookCarController {

    @Autowired
    private BookCarService bookCarService;

    @PostMapping("/save-car")
    public BookCarDto bookCarDetails(@RequestBody BookCarDto bookCarDto){
        return bookCarService.bookCarDetails(bookCarDto);
    }

    @GetMapping("/findBy-userId/{userId}")
    public List<BookCarDto> getBookCarDetails(@PathVariable Long userId){
        System.out.println("1");
        return bookCarService.getBookCarDetails(userId);
    }

    @GetMapping("/get-all-bookings")

    public List<BookCarDto> getAllBookings(){
        return bookCarService.getAllBookCarDetails();
    }

    @GetMapping("/changStatus/{id}/{status}")
    public Boolean changeBookingStatus(@PathVariable Integer id, @PathVariable String status){
        return bookCarService.changeBookingStatus(id, status);

    }
}
