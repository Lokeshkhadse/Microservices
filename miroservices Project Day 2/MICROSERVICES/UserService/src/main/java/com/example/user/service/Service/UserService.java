package com.example.user.service.Service;

import com.example.user.service.Entity.User;
import com.example.user.service.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {


    User saveUser(User user);

    User getUser(String id);

    List<User>getAllUsers();

}
