package com.example.GoReview.controllers;


import com.example.GoReview.models.*;
import com.example.GoReview.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value="/reviews")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    //    get all reviews
    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(){
        List<Review> reviews = reviewService.getAllReviews();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

//    get a review by ID

    @GetMapping(value="/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable long id){
        Optional<Review> review= reviewService.getReviewById(id);
        if (review.isPresent()){
            return new ResponseEntity<>(review.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    //    get all reviews by user ID

    @GetMapping(value="/users/{id}")
    public ResponseEntity<List<Review>> getAllReviewsByUserId(@PathVariable long id){
        List<Review> reviews= reviewService.getAllReviewsByUserId(id);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

//    check existing restaurant and submit a review

    // request params, rest id and username, and then update process to review to not take map, find user and rest, through process review and the output the review.
    @PostMapping
    public ResponseEntity<Reply> submitNewReview(@RequestBody Review review, @RequestParam String username, @RequestParam Long restaurantId){

        Reply reply = reviewService.processReview(review, username, restaurantId);
        return new ResponseEntity<>(reply, HttpStatus.CREATED);
    }
    //    get all reviews by username
    @GetMapping(value="/username/{username}")
    public ResponseEntity<List<Review>> getAllReviewsByUsername(@PathVariable String username){
        List<Review> reviews= reviewService.getAllReviewsByUsername(username);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @GetMapping(value="/diet")
    public ResponseEntity<List<Review>> getAllReviewsByDiet(@RequestBody Diet diet){
        List<Review> reviews= reviewService.getAllReviewsByDiet(diet);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @GetMapping(value="/accessibility")
    public ResponseEntity<List<Review>> getAllReviewsByDiet(@RequestBody Accessibility accessibility){
        List<Review> reviews= reviewService.getAllReviewsByAccessibility(accessibility);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    //    delete a review by ID
    @DeleteMapping(value = "{id}")
    public ResponseEntity deleteReviewById(@PathVariable long id){
        reviewService.deleteReview(id);
        return new ResponseEntity(null, HttpStatus.NO_CONTENT);
    }

//  get all reviews by pricing
    @GetMapping(value="/pricing")
    public ResponseEntity<List<Review>> getReviewsByPricing(@RequestBody Pricing pricing){
        List<Review> reviews= reviewService.getAllReviewsByPricing(pricing);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    //  get all reviews by rating
    @GetMapping(value="/rating")
    public ResponseEntity<List<Review>> getReviewsByRating(@RequestBody Rating rating){
        List<Review> reviews= reviewService.getAllReviewsByRating(rating);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

}
