package com.example.user.service.Entity;

import jakarta.persistence.*;
import lombok.*;

import javax.lang.model.element.Name;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    private String userId;
    private String name;
    private String email;
    private String about;

    @Transient
    private List<Rating> ratings = new ArrayList<>();// [] he aala new arraylist nast takla tr null yeta
}
