package com.example.GoReview.controllers;

import com.example.GoReview.models.Restaurant;
import com.example.GoReview.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;


    @GetMapping
    public ResponseEntity<List<Restaurant>> getAllRestaurants(){
        List<Restaurant> restaurants = restaurantService.getAllRestaurants();
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Restaurant> getRestaurantsById(@PathVariable long id){
        Optional<Restaurant> restaurant = restaurantService.getRestaurantById(id);
        if (restaurant.isPresent()){
            return new ResponseEntity<>(restaurant.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Restaurant> addNewRestaurant(@RequestBody Restaurant restaurant){
        Restaurant savedRestaurant = restaurantService.saveRestaurant(restaurant);
        return  new ResponseEntity<>(savedRestaurant, HttpStatus.OK);
    }
}
