package com.example.GoReview.services;
import com.example.GoReview.models.*;
import com.example.GoReview.repositories.RestaurantRepository;
import com.example.GoReview.repositories.ReviewRepository;
import com.example.GoReview.repositories.UserRepository;
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
    UserRepository userRepository;

    public ReviewService(){}

    public List<Review> getAllReviews(){
        return reviewRepository.findAll();
    }


    public Optional<Review> getReviewById(long id){
        return reviewRepository.findById(id);
    }

    public List<Review> getAllReviewsByUserId(long id){
        return reviewRepository.findAllByUserId(id);
    }

    public Reply processReview(Review review, String username, Long restaurantId) {
        if (!userRepository.findByUsername(username).isPresent() && !restaurantRepository.findById(restaurantId).isPresent()) {
            return new Reply(String.format("Could not find user %s and restaurant id %d. Please create a new user and add a new restaurant to our database.", username, restaurantId));
        } else if (!userRepository.findByUsername(username).isPresent()) {
            return new Reply(String.format("Could not find user %s. Please create a new user.", username));
        } else if (!restaurantRepository.findById(restaurantId).isPresent()) {
            return new Reply(String.format("Could not find restaurant id %d. Please add a new restaurant to our database.", restaurantId));
        } else {
            User user = userRepository.findByUsername(username).get();
            Restaurant restaurant = restaurantRepository.findById(restaurantId).get();
            review.setUser(user);
            review.setRestaurant(restaurant);
            reviewRepository.save(review);
            return new Reply(String.format("Review id %d submitted successfully by user %s!", review.getId(), review.getUser().getUsername()));
        }
    }


    //    get all reviews by username
    public List<Review> getAllReviewsByUsername(String username){
        return reviewRepository.findAllByUserUsername(username);
    }

    //    get all reviews by restaurant id
    public List<Review> getAllReviewsByRestaurantId(long id){
        return reviewRepository.findAllByRestaurantId(id);
    }

//    get restaurant average rating
    public Reply getAverageRestaurantRating(long id){
        List<Review> reviews= getAllReviewsByRestaurantId(id);
        String restaurant_name= restaurantRepository.findById(id).get().getName();
        float rating=0;
        for (Review review:reviews){
            rating+=review.getRating().getValue();
        }
        float averageRating=rating/reviews.size();
        return new Reply(String.format("The average rating for %s restaurant is %.2f out of 5!", restaurant_name, averageRating));
    }


    public List<Review> getAllReviewsByDiet(Diet diet){
        return reviewRepository.findByDiet(diet);
    }

    public List<Review> getAllReviewsByAccessibility(Accessibility accessibility){
        return reviewRepository.findByAccessibility(accessibility);
    }

//  delete a review by review ID

    public void deleteReview(long id){
        reviewRepository.deleteById(id);
    }


// get all reviews by pricing
    public List<Review> getAllReviewsByPricing(Pricing pricing){
        return reviewRepository.findByPricing(pricing);
    }


    // get all reviews by rating
    public List<Review> getAllReviewsByRating(Rating rating){
        return reviewRepository.findByRating(rating);
    }


}
