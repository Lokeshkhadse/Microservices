package com.example.rating.service.RatingService.Repository;

import com.example.rating.service.RatingService.Entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating,String> {

    //custom finder method

    List<Rating> findByuserId(String userId);
    List<Rating> findByhotelId(String hotelId);
}
