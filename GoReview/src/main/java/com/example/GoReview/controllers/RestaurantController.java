package com.example.GoReview.controllers;

import com.example.GoReview.models.*;
import com.example.GoReview.services.RestaurantService;
import com.example.GoReview.services.ReviewService;
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
    @Autowired
    ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<Restaurant>> getAllRestaurants(){
        List<Restaurant> restaurants = restaurantService.getAllRestaurants();
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Restaurant> getRestaurantsById(@PathVariable long id){
        Optional<Restaurant> restaurant = restaurantService.getRestaurantById(id);
        if (restaurant.isPresent()){
            return new ResponseEntity<>(restaurant.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Reply> addNewRestaurant(@RequestBody Restaurant restaurant){
        Reply reply = restaurantService.addNewRestaurant(restaurant);
        return new ResponseEntity<>(reply, HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteRestaurant(@PathVariable long id){
        restaurantService.deleteRestaurant(id);
        return new ResponseEntity(null,HttpStatus.NO_CONTENT);

    }

    @GetMapping(value="/cuisine")
    public ResponseEntity<List<Restaurant>> getAllRestaurantsByCuisine(@RequestBody Cuisine cuisine){
        List<Restaurant> restaurants = restaurantService.getAllRestaurantsByCuisine(cuisine);
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }

    @GetMapping(value="/rating/{id}")
    public ResponseEntity<Reply> getAverageRestaurantRating(@PathVariable long id){
        Reply reply = reviewService.getAverageRestaurantRating(id);
        return new ResponseEntity<>(reply, HttpStatus.OK);
    }

}
