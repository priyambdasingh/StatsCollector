//package com.example.StatsCollector.service;
//
//import com.example.StatsCollector.dto.RestaurantDto;
//import com.example.StatsCollector.model.Adress;
//import com.example.StatsCollector.model.Restaurant;
//import com.example.StatsCollector.model.Users;
//import com.example.StatsCollector.repository.AddressRepository;
//import com.example.StatsCollector.repository.RestaurantRepository;
//import com.example.StatsCollector.repository.UsersRepository;
//import com.example.StatsCollector.request.CreateRestaurantRequest;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class RestaurantServiceImp implements RestaurantService{
//    @Autowired
//    private RestaurantRepository restaurantRepository;
//    @Autowired
//    private AddressRepository addressRepository;
//    @Autowired
//    private UsersRepository usersRepository;
//
//    public RestaurantServiceImp(RestaurantRepository restaurantRepository, AddressRepository addressRepository, UsersRepository usersRepository) {
//        this.restaurantRepository = restaurantRepository;
//        this.addressRepository = addressRepository;
//        this.usersRepository = usersRepository;
//    }
//
//    @Override
//    public Restaurant createRestaurant(CreateRestaurantRequest req, Users users) {
//        Adress adress=addressRepository.save(req.getAddress());
//        Restaurant restaurant=new Restaurant();
//        restaurant.setAdress(adress);
//        restaurant.setContactInformaton(req.getContactInformation());
//        restaurant.setCuisineType(req.getCuisineType());
//        restaurant.setDescription(req.getDescription());
//        restaurant.setImages(req.getImages());
//        restaurant.setName(req.getName());
//        restaurant.setOpeningHours(req.getOpningHours());
//        restaurant.setRegistrationDate(LocalDateTime.now());
//        restaurant.setOwner(users);
//
//        return restaurantRepository.save(restaurant);
//    }
//
//    @Override
//    public Restaurant updateRestaurant(Long restaurantId, CreateRestaurantRequest updatedRestaurant) throws Exception {
//        Restaurant restaurant=findRestaurantById(restaurantId);
//        if (restaurant.getCuisineType()!=null){
//            restaurant.setCuisineType(updatedRestaurant.getCuisineType());
//        }
//        if (restaurant.getDescription()!=null){
//            restaurant.setDescription(updatedRestaurant.getDescription());
//        }
//        if (restaurant.getName()!=null){
//            restaurant.setName(updatedRestaurant.getName());
//        }
//
//
//        return restaurantRepository.save(restaurant);
//    }
//
//    @Override
//    public void deleteRestaurant(Long restaurantId) throws Exception {
//        Restaurant restaurant=findRestaurantById(restaurantId);
//        restaurantRepository.delete(restaurant);
//
//    }
//
//    @Override
//    public List<Restaurant> getAllRestaurant() {
//        return restaurantRepository.findAll();
//    }
//
//    @Override
//    public List<Restaurant> searchRestaurant(String keyword) {
//        return restaurantRepository.findBySearchQuery(keyword);
//    }
//
//    @Override
//    public Restaurant findRestaurantById(Long id) throws Exception {
//        Optional<Restaurant>opt = restaurantRepository.findById(id);
//        if(opt.isEmpty()){
//            throw new Exception("restaurant not found with id"+id);
//        }
//        return opt.get();
//    }
//
//    @Override
//    public Restaurant getRestaurantByUsersId(Long usersId) throws Exception {
//        Restaurant restaurant=restaurantRepository.findByOwnerId(usersId);
//        if (restaurant==null){
//            throw new Exception("restaurant not found with owner id"+usersId);
//        }
//        return restaurant;
//    }
//
//    @Override
//    public RestaurantDto addToFavorites(Long restaurantId, Users users) throws Exception {
//        Restaurant restaurant=findRestaurantById(restaurantId);
//        RestaurantDto dto=new RestaurantDto();
//        dto.setDescription(restaurant.getDescription());
//        dto.setImages(restaurant.getImages());
//        dto.setTitle(restaurant.getName());
//        dto.setId(restaurantId);
//        if (users.getFavorites().contains(dto)){
//            users.getFavorites().remove(dto);
//        }
//        else users.getFavorites().add(String.valueOf(dto));
//        usersRepository.save(users);
//
//        return dto;
//    }
//
//    @Override
//    public Restaurant updateRestaurantStatus(Long id) throws Exception {
//        Restaurant restaurant=findRestaurantById(id);
//        restaurant.setOpen(!restaurant.isOpen());
//        return restaurantRepository.save(restaurant);
//    }
//}
package com.example.StatsCollector.service;

import com.example.StatsCollector.dto.RestaurantDto;
import com.example.StatsCollector.model.Adress;

import com.example.StatsCollector.model.Restaurant;
import com.example.StatsCollector.model.Users;
import com.example.StatsCollector.repository.AddressRepository;
import com.example.StatsCollector.repository.RestaurantRepository;
import com.example.StatsCollector.repository.UsersRepository;
import com.example.StatsCollector.request.CreateRestaurantRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImp implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public Restaurant createRestaurant(CreateRestaurantRequest req, Users users) {
        Adress address = addressRepository.save(req.getAddress());
        Restaurant restaurant = new Restaurant();
        restaurant.setAdress(address);
        restaurant.setContactInformaton(req.getContactInformation());
        restaurant.setCuisineType(req.getCuisineType());
        restaurant.setDescription(req.getDescription());
        restaurant.setImages(req.getImages());
        restaurant.setName(req.getName());
        restaurant.setOpeningHours(req.getOpningHours());
        restaurant.setRegistrationDate(LocalDateTime.now());
        restaurant.setOwner(users);

        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant updateRestaurant(Long restaurantId, CreateRestaurantRequest updatedRestaurant) throws Exception {
        Restaurant restaurant = findRestaurantById(restaurantId);
        if (restaurant.getCuisineType() != null) {
            restaurant.setCuisineType(updatedRestaurant.getCuisineType());
        }
        if (restaurant.getDescription() != null) {
            restaurant.setDescription(updatedRestaurant.getDescription());
        }
        if (restaurant.getName() != null) {
            restaurant.setName(updatedRestaurant.getName());
        }

        return restaurantRepository.save(restaurant);
    }

    @Override
    public void deleteRestaurant(Long restaurantId) throws Exception {
        Restaurant restaurant = findRestaurantById(restaurantId);
        restaurantRepository.delete(restaurant);
    }

    @Override
    public List<Restaurant> getAllRestaurant() {
        return restaurantRepository.findAll();
    }

    @Override
    public List<Restaurant> searchRestaurant(String keyword) {
        return restaurantRepository.findBySearchQuery(keyword);
    }

    @Override
    public Restaurant findRestaurantById(Long id) throws Exception {
        Optional<Restaurant> opt = restaurantRepository.findById(id);
        if (opt.isEmpty()) {
            throw new Exception("Restaurant not found with id " + id);
        }
        return opt.get();
    }

    @Override
    public Restaurant getRestaurantByUsersId(Long usersId) throws Exception {
        Restaurant restaurant = restaurantRepository.findByOwnerId(usersId);
        if (restaurant == null) {
            throw new Exception("Restaurant not found with owner id " + usersId);
        }
        return restaurant;
    }

    @Override
    public RestaurantDto addToFavorites(Long restaurantId, Users users) throws Exception {
        Restaurant restaurant = findRestaurantById(restaurantId);
        RestaurantDto dto = new RestaurantDto();
        dto.setDescription(restaurant.getDescription());
        dto.setImages(restaurant.getImages());
        dto.setTitle(restaurant.getName());
        dto.setId(restaurantId);
        if (users.getFavorites().contains(dto)) {
            users.getFavorites().remove(dto);
        } else {
            users.getFavorites().add(String.valueOf(dto));
        }
        usersRepository.save(users);

        return dto;
    }

    @Override
    public Restaurant updateRestaurantStatus(Long id) throws Exception {
        Restaurant restaurant = findRestaurantById(id);
        restaurant.setOpen(!restaurant.isOpen());
        return restaurantRepository.save(restaurant);
    }
}
