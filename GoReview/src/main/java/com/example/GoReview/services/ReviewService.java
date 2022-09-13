package com.example.GoReview.services;


import com.example.GoReview.models.Reply;
import com.example.GoReview.models.Restaurant;
import com.example.GoReview.models.Review;
import com.example.GoReview.repositories.RestaurantRepository;
import com.example.GoReview.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    UserService userService;
    @Autowired
    RestaurantService restaurantService;

    public ReviewService(){}

    public List<Review> getAllReviews(){
        return reviewRepository.findAll();
    }


    public Optional<Review> getReviewById(long id){
        return reviewRepository.findById(id);
    }


//    getReviewByUserId(long) : List<Review>
    public List<Review> getAllReviewsByUserId(long id){
        return reviewRepository.findByUserId(id);
    }

    public Reply processReview(Review review) {
        reviewRepository.save(review);
        return new Reply(String.format("Review id %d submitted successfully by user %s!", review.getId(), review.getUser().getUsername()));
    }

    public Reply checkExistingRestaurant (Review review) {
        if(restaurantService.getAllRestaurants().contains(review.getRestaurant())) {
            return processReview(review);
        } else {
            return new Reply(String.format("Could not find restaurant %s. Would you like to add this restaurant to the list?",
                    review.getRestaurant().getName()));
        }
    }

    public Reply addNewRestaurant (Restaurant restaurant) {
        restaurantService.saveRestaurant(restaurant);
        return new Reply(String.format("Restaurant %s was successfully created!", restaurant.getName()));
    }

//  submitReview(long) : ResponseEntity<Review>

// average rating for a specific restaurant

}
