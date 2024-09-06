package com.example.user.service.Controller;

import com.example.user.service.Entity.User;
import com.example.user.service.Service.UserService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

     @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
      //  return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);

         User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") String userId){
         User user = userService.getUser(userId);
         return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
         List<User>users = userService.getAllUsers();
         return ResponseEntity.ok(users);

    }

}
