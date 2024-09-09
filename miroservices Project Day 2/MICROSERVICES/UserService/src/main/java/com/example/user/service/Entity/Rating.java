package com.example.user.service.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Rating {


    private String ratingId;
    private  String userId;
    private String hotelId;

    private int rating;
    private String feedback;

    private Hotel hotel;
}
