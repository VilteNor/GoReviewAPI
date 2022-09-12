package com.example.GoReview.services;


import com.example.GoReview.models.Restaurant;
import com.example.GoReview.models.Review;
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
    UserService userService;

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


//  submitReview(long) : ResponseEntity<Review>


// in restaurant service:
// getRestaurantByRating(int) : List<Restaurants>
//    public List<Restaurant> getRestaurantByRating(int rating){
//        return reviewRepository.findByRating(rating);
//    }


// getRestaurantByFeatures() : List<Restaurant>


}
