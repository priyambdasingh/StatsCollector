package com.example.StatsCollector.service;

import com.example.StatsCollector.dto.RestaurantDto;
import com.example.StatsCollector.model.Restaurant;
import com.example.StatsCollector.model.Users;
import com.example.StatsCollector.request.CreateRestaurantRequest;

import java.util.List;

public interface RestaurantService {
    public Restaurant createRestaurant(CreateRestaurantRequest req, Users users);

    public Restaurant updateRestaurant(Long restaurantId, CreateRestaurantRequest updatedRestaurant) throws Exception;
    public void  deleteRestaurant (Long restaurantId) throws Exception;
    public List<Restaurant>getAllRestaurant();
    public List<Restaurant>searchRestaurant(String keyword);
    public Restaurant findRestaurantById(Long id) throws Exception;
    public Restaurant getRestaurantByUsersId(Long usersId)throws Exception;
    public RestaurantDto addToFavorites(Long restaurantId,Users users)throws Exception;
    public Restaurant updateRestaurantStatus(Long id)throws Exception;

}
