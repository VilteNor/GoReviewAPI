package com.example.GoReview.components;


import com.example.GoReview.models.*;
import com.example.GoReview.repositories.RestaurantRepository;
import com.example.GoReview.repositories.ReviewRepository;
import com.example.GoReview.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        User user1 = new User("alice1", "Alice One", "alice1@mail.com");
        userRepository.save(user1);

        User user2 = new User("john2", "John Two", "john2@mail.com");
        userRepository.save(user2);

        Restaurant restaurant1 = new Restaurant("Nandos","Glasgow");
        restaurantRepository.save(restaurant1);

        Restaurant restaurant2 = new Restaurant("Dominos","London");
        restaurantRepository.save(restaurant2);

        Restaurant restaurant3 = new Restaurant("PizzaHut","Leeds");
        restaurantRepository.save(restaurant3);

        Review review1 = new Review(user1,restaurant1,"21/1/2022", Rating.EXCELLENT);
        reviewRepository.save(review1);

        Review review2 = new Review(user1,restaurant2,"1/10/2022", Rating.AVERAGE);
        reviewRepository.save(review2);

        Review review3 = new Review(user2,restaurant2,"5/12/2022", Rating.GOOD);
        reviewRepository.save(review3);

        Review review4 = new Review(user2,restaurant3,"17/3/2022", Rating.GOOD);
        reviewRepository.save(review4);

        Review review5 = new Review(user2,restaurant1,"6/4/2022", Rating.COMPLETELY_DISSATISFIED);
        reviewRepository.save(review5);

        Review review6 = new Review(user2,restaurant3,"09/09/09",Rating.GOOD);
        review6.setPricing(Pricing.££££);
        Collections.addAll(review6.getAccessibility()  , Accessibility.ACCESSIBLE_BATHROOMS,Accessibility.ACCESSIBLE_MENU);
        //review6.addAccessibility(Accessibility.ACCESSIBLE_BATHROOMS);
        //review6.addAccessibility(Accessibility.ACCESSIBLE_MENU);
        review6.addDiet(Diet.DAIRY_FREE);
        review6.addDiet(Diet.NUT_FREE);
        reviewRepository.save(review6);

    }
}
