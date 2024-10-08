package com.example.user.service.Service;

import com.example.user.service.Entity.Hotel;
import com.example.user.service.Entity.Rating;
import com.example.user.service.Entity.User;
import com.example.user.service.Exception.ResourceNotFoundException;
import com.example.user.service.Repository.UserRepository;
import com.example.user.service.external.service.HotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceimpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

   // @Autowired
   // private WebClient.Builder webClientBuilder;

        private Logger logger = LoggerFactory.getLogger(UserServiceimpl.class);

    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public User getUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user is not present on the server!!" + userId));

        //fetching data from ratingsservice by using userId number
        //http://localhost:9002/ratings/users/7517f3b7-f2e1-410d-9836-a45e2e7450c2

        Rating[] ratingsofusers = restTemplate.getForObject("http://RATINGSERVICE/ratings/users/"+user.getUserId(), Rating[].class);
        logger.info("{}",ratingsofusers); //print

//        (fetch data using webclient)
//         Fetch ratings using WebClient
//        Mono<Rating[]> ratingMono = webClientBuilder.build()
//                .get()
//                .uri("http://RATINGSERVICE/ratings/users/" + user.getUserId())
//                .retrieve()
//                .bodyToMono(Rating[].class);
//
//        Rating[] ratingsofusers = ratingMono.block(); // Blocking call (for learning; async is better in production)
//        logger.info("{}", ratingsofusers);


        //convert [] into list
        List<Rating> ratings = Arrays.stream(ratingsofusers).toList();


        //fetching hotel depend on (by using) ratingid()
        List<Rating> ratingList = ratings.stream().map(rating  -> {

                    //api call to hotel service to get hotel
                    //http://localhost:9001/hotels/d50e732f-b607-41c9-83b9-779d31da2c42

           // ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTELSERVICE/hotels/"+rating.getHotelId(), Hotel.class);
 /*(FeignClient)*/ Hotel hotel = hotelService.getHotel(rating.getHotelId()); //forEntity.getBody();
           // logger.info("response Statuse Code {} ", forEntity.getStatusCode());

                    //set the hotel to rating
                    rating.setHotel(hotel);

                    return rating;
                }).collect(Collectors.toList());

        //je pn ratings cha data bhetel toh set kela tya user la
           user.setRatings(ratingList);

      return  user;

    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
