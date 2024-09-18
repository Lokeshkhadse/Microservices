package com.example.hotel.service.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "hotels")
public class Hotel {
    @Id
    private String id;
    private String name;
    private String location;
    private String about;

}
