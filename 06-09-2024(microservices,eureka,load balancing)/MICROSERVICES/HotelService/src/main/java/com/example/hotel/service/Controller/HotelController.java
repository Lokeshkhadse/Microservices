package com.example.hotel.service.Controller;

import com.example.hotel.service.Entity.Hotel;
import com.example.hotel.service.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel>createHotel(@RequestBody Hotel hotel){
        return new ResponseEntity<>(hotelService.saveHotel(hotel), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Hotel> getHotelById(@PathVariable("id")String id){
        return new ResponseEntity<>(hotelService.getHotelById(id),HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels() {
        List<Hotel> hotels = hotelService.getAllHotels();
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }





}
