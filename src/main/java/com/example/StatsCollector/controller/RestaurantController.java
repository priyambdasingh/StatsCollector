package com.example.StatsCollector.controller;

import com.example.StatsCollector.dto.RestaurantDto;
import com.example.StatsCollector.model.Restaurant;
import com.example.StatsCollector.model.Users;
import com.example.StatsCollector.request.CreateRestaurantRequest;
import com.example.StatsCollector.service.RestaurantService;
import com.example.StatsCollector.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/restaurants")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private UserService userService;
    @GetMapping("/search")
    public ResponseEntity <List<Restaurant>> searchRestaurant(
            @RequestHeader("Authorization")String jwt,
            @RequestParam String keyword
    ) throws Exception {
        Users users=userService.findUsersByJwtToken(jwt);
       List< Restaurant> restaurant=restaurantService.searchRestaurant(keyword);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity <List<Restaurant>> getAllRestaurant(
            @RequestHeader("Authorization")String jwt

    ) throws Exception {
        Users users=userService.findUsersByJwtToken(jwt);
        List< Restaurant> restaurant=restaurantService.getAllRestaurant();
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity <Restaurant>findRestaurantById(
            @RequestHeader("Authorization")String jwt,
            @PathVariable Long id

    ) throws Exception {
        Users users=userService.findUsersByJwtToken(jwt);
         Restaurant restaurant=restaurantService.findRestaurantById(id);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }
    @PutMapping("/{id}/add-favorites")
    public ResponseEntity <RestaurantDto>addToFavorites(
            @RequestHeader("Authorization")String jwt,
            @PathVariable Long id

    ) throws Exception {
        Users users=userService.findUsersByJwtToken(jwt);
        RestaurantDto restaurant=restaurantService.addToFavorites(id,users);

        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }
}
