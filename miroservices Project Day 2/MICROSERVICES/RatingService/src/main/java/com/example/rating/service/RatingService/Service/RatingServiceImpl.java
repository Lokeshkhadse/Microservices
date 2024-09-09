package com.example.rating.service.RatingService.Service;

import com.example.rating.service.RatingService.Entity.Rating;
import com.example.rating.service.RatingService.Exception.ResourceNotFoundException;
import com.example.rating.service.RatingService.Repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService{

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating createRating(Rating rating) {
        String random = UUID.randomUUID().toString();
        rating.setRatingId(random);
        return ratingRepository.save(rating);
    }

    @Override
    public Rating getRatingById(String ratingId) {
        return ratingRepository.findById(ratingId).orElseThrow(() -> new ResourceNotFoundException("user is not present on the server!!" + ratingId ));
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return ratingRepository.findByuserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return ratingRepository.findByhotelId(hotelId);
    }
}
