package com.example.hotel.service.Service;

import com.example.hotel.service.Entity.Hotel;
import com.example.hotel.service.Exception.ResourceNotFoundException;
import com.example.hotel.service.Repositroy.HotelRespositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelSeviceImpl implements HotelService {

    @Autowired
    private HotelRespositroy hotelRespositroy;

    @Override
    public Hotel saveHotel(Hotel hotel) {

         String randomID = UUID.randomUUID().toString();
         hotel.setId(randomID);
        return hotelRespositroy.save(hotel);
    }

    @Override
    public Hotel getHotelById(String id) {
        return hotelRespositroy.findById(id).orElseThrow(() -> new ResourceNotFoundException("hotel given id is not found!!!!"));
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRespositroy.findAll();
    }
}
