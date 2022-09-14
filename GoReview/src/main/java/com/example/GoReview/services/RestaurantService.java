package com.example.GoReview.services;

import com.example.GoReview.models.Reply;
import com.example.GoReview.models.Restaurant;
import com.example.GoReview.models.Review;
import com.example.GoReview.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    private List<Review> reviews;



    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Optional<Restaurant> getRestaurantById(Long id){
        return restaurantRepository.findById(id);
    }

    public Restaurant saveRestaurant(Restaurant restaurant){
        restaurantRepository.save(restaurant);
        return restaurant;
    }
    public Reply addNewRestaurant (Restaurant restaurant) {
        saveRestaurant(restaurant);
        return new Reply(String.format("Restaurant %s was successfully created!", restaurant.getName()));
    }

    // in restaurant service:
// getRestaurantByRating(int) : List<Restaurants>
//    public List<Restaurant> getRestaurantByRating(int rating){
//        return reviewRepository.findByRating(rating);
//    }


// getRestaurantByFeatures() : List<Restaurant>


}
