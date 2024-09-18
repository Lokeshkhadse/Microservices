package com.example.user.service.Controller;

import com.example.user.service.Entity.User;
import com.example.user.service.Service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.Getter;
import lombok.extern.flogger.Flogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger = LoggerFactory.getLogger(UserController.class);

     @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
      //  return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);

         User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    int retrycnt = 1;
    @GetMapping("/{userId}")
  //  @CircuitBreaker(name="ratingHotelBreaker" , fallbackMethod = "ratingHotelFallBack")
    //@Retry(name="ratingHotelService" , fallbackMethod = "ratingHotelFallBack")
    @RateLimiter(name="userRateLimiter", fallbackMethod = "ratingHotelFallBack")
    public ResponseEntity<User> getUserById(@PathVariable("userId") String userId){
         logger.info("get single user handler!!!!!");
        logger.info("retry count : " + retrycnt);
         retrycnt++;

        User user = userService.getUser(userId);
         return ResponseEntity.ok(user);
    }


    //create ratingHotelFallBack method
    public ResponseEntity<User> ratingHotelFallBack(String userId, Exception ex) {
        // Logging the exception as an error
        logger.info("Fallback method is executed because the service is down: {}", ex.getMessage());

        // Creating a dummy user object
        User user = User.builder()
                .email("dummy@gmail.com")
                .name("dummy")
                .about("dummy user, system is down")
                .userId("12345")
                .build();

        // Returning the dummy user with HTTP status OK
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
         List<User>users = userService.getAllUsers();
         return ResponseEntity.ok(users);

    }

}
