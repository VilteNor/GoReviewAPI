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

        Restaurant restaurant1 = new Restaurant("YO SUSHI","Glasgow");
        restaurant1.setCuisine(Cuisine.JAPANESE);
        restaurantRepository.save(restaurant1);

        Restaurant restaurant2 = new Restaurant("Dominos","London");
        restaurant2.setCuisine(Cuisine.AMERICAN);
        restaurantRepository.save(restaurant2);

        Restaurant restaurant3 = new Restaurant("Bella Italia","Leeds");
        restaurant3.setCuisine(Cuisine.ITALIAN);
        restaurantRepository.save(restaurant3);

        Review review1 = new Review(user1,restaurant1,"21/1/2022", Rating.EXCELLENT);
        Collections.addAll(review1.getDiet(), Diet.DAIRY_FREE, Diet.HALAL);
        review1.setPricing(Pricing.£££);
        review1.setOptionalMessage("I loved the salmon sushi in here!");
        reviewRepository.save(review1);

        Review review2 = new Review(user1,restaurant2,"1/10/2022", Rating.AVERAGE);
        Collections.addAll(review2.getDiet(), Diet.FISH_FREE, Diet.HALAL);
        Collections.addAll(review2.getAccessibility(), Accessibility.DOG_FRIENDLY,Accessibility.WHEELCHAIR_ACCESS);
        review2.setPricing(Pricing.££);
        review2.setOptionalMessage("good pizza, great deals for big groups.");
        reviewRepository.save(review2);

        Review review3 = new Review(user2,restaurant2,"5/12/2022", Rating.GOOD);
        Collections.addAll(review3.getDiet(), Diet.GLUTEN_FREE, Diet.FISH_FREE);
        review3.setPricing(Pricing.£);
        reviewRepository.save(review3);

        Review review4 = new Review(user1,restaurant3,"17/3/2022", Rating.COMPLETELY_DISSATISFIED);
        review4.setPricing(Pricing.££);
        Collections.addAll(review4.getAccessibility(), Accessibility.CHILD_FRIENDLY,Accessibility.WHEELCHAIR_ACCESS);
        Collections.addAll(review4.getDiet(), Diet.GLUTEN_FREE, Diet.VEGAN);
        review4.setOptionalMessage("not impressed, expected better service.");
        reviewRepository.save(review4);

        Review review5 = new Review(user2,restaurant1,"6/4/2022", Rating.GOOD);
        Collections.addAll(review5.getDiet(), Diet.FISH_FREE, Diet.VEGAN);
        review5.setPricing(Pricing.£££££);
        reviewRepository.save(review5);

        Review review6 = new Review(user2,restaurant3,"09/09/09",Rating.NOT_SATISFIED);
        review6.setPricing(Pricing.£££);
        Collections.addAll(review6.getAccessibility(), Accessibility.ACCESSIBLE_BATHROOMS,Accessibility.ACCESSIBLE_MENU);
        Collections.addAll(review6.getDiet(), Diet.DAIRY_FREE, Diet.NUT_FREE);
        review6.setOptionalMessage("could have more dairy free options on the menu");
        reviewRepository.save(review6);

    }
}
