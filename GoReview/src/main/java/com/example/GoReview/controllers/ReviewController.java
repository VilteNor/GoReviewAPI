package com.example.GoReview.controllers;


import com.example.GoReview.models.Reply;
import com.example.GoReview.models.Review;
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

    @PostMapping
    public ResponseEntity<Reply> submitNewReview(@RequestBody Map<String, String> params){
        Reply reply = reviewService.processReview(params);
        return new ResponseEntity<>(reply, HttpStatus.CREATED);
    }
    //    get all reviews by username
    @GetMapping(value="/username/{username}")
    public ResponseEntity<List<Review>> getAllReviewsByUsername(@PathVariable String username){
        List<Review> reviews= reviewService.getAllReviewsByUsername(username);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    //    delete a review by ID
    @DeleteMapping(value = "{id}")
    public ResponseEntity deleteReviewById(@PathVariable long id){
        reviewService.deleteReview(id);
        return new ResponseEntity(null, HttpStatus.NO_CONTENT);
    }

}
