package com.example.StatsCollector.controller;

import com.example.StatsCollector.model.Restaurant;
import com.example.StatsCollector.model.Users;
import com.example.StatsCollector.request.CreateRestaurantRequest;
import com.example.StatsCollector.response.MessageResponse;
import com.example.StatsCollector.service.RestaurantService;
import com.example.StatsCollector.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/restaurant")
public class AdminRestaurantController {
    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private UserService userService;
    @PostMapping()
    public ResponseEntity<Restaurant>createRestaurant(
            @RequestBody CreateRestaurantRequest req,
            @RequestHeader("Authorization")String jwt
            ) throws Exception {
        Users users=userService.findUsersByJwtToken(jwt);
        Restaurant restaurant=restaurantService.createRestaurant(req,users);
        return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Restaurant>updateRestaurant(
            @RequestBody CreateRestaurantRequest req,
            @RequestHeader("Authorization")String jwt,
            @PathVariable Long id
    ) throws Exception {
        Users users=userService.findUsersByJwtToken(jwt);
        Restaurant restaurant=restaurantService.updateRestaurant(id,req);
        return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse>deleteRestaurant(

            @RequestHeader("Authorization")String jwt,
            @PathVariable Long id
    ) throws Exception {
        Users users=userService.findUsersByJwtToken(jwt);
        restaurantService.deleteRestaurant(id);
        MessageResponse res=new MessageResponse();
        res.setMessage("restaurant delete successfully");
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    @PutMapping("/{id}/status")
    public ResponseEntity<Restaurant>updateRestaurantStatus(

            @RequestHeader("Authorization")String jwt,
            @PathVariable Long id
    ) throws Exception {
        Users users=userService.findUsersByJwtToken(jwt);
      Restaurant restaurant =  restaurantService.updateRestaurantStatus(id);

        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }
    @GetMapping("/user")
    public ResponseEntity<Restaurant>findRestaurantByUsersId(
            @RequestHeader("Authorization")String jwt

    ) throws Exception {
        Users users=userService.findUsersByJwtToken(jwt);
        Restaurant restaurant =  restaurantService.findRestaurantById(users.getId());

        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }
}
