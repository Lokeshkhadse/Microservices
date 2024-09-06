package com.example.hotel.service.Repositroy;

import com.example.hotel.service.Entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRespositroy extends JpaRepository<Hotel, String> {
}
