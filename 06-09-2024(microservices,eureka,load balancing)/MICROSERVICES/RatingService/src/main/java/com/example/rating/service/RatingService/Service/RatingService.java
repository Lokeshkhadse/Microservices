package com.example.rating.service.RatingService.Service;

import com.example.rating.service.RatingService.Entity.Rating;
import org.hibernate.sql.exec.spi.StandardEntityInstanceResolver;

import java.util.List;

public interface RatingService {

    Rating createRating(Rating rating);

    Rating getRatingById(String ratingId);


    List<Rating> getAllRatings();

    List<Rating>getRatingByUserId(String userId);

    List<Rating> getRatingByHotelId(String hotelId);
}
