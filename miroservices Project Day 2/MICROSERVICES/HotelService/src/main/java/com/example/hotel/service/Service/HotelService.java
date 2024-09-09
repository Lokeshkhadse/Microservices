package com.example.hotel.service.Service;

import com.example.hotel.service.Entity.Hotel;

import java.util.List;

public interface HotelService {

    Hotel saveHotel(Hotel hotel);

    Hotel getHotelById(String id);

    List<Hotel> getAllHotels();
}
