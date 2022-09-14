package com.example.GoReview.controllers;

import com.example.GoReview.models.Reply;
import com.example.GoReview.models.Restaurant;
import com.example.GoReview.models.Review;
import com.example.GoReview.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
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

//    @PostMapping
//    public ResponseEntity<Reply> addNewUser(@RequestBody Map<String, String> userParams) {
//        Reply reply = userService.processUser(userParams);
//        return new ResponseEntity<>(reply, HttpStatus.CREATED);
//    }


    @GetMapping(value = "/findreviewsforuser/{user_id}")
    public ResponseEntity<Restaurant> getRestaurantsByUserId(@PathVariable long user_id) {
        Optional<Restaurant> restaurant = restaurantService.getRestaurantByUserId(user_id);
        return new ResponseEntity<>(restaurant.get(),HttpStatus.OK);
    }



    @DeleteMapping(value = "/delete-restaurant/{id}")
    public ResponseEntity deleteRestaurant(@PathVariable long id){
        restaurantService.deleteRestaurant(id);
        return new ResponseEntity(null,HttpStatus.NO_CONTENT);

    }


}
