package com.example.GoReview.components;


import com.example.GoReview.models.Rating;
import com.example.GoReview.models.Restaurant;
import com.example.GoReview.models.Review;
import com.example.GoReview.models.User;
import com.example.GoReview.repositories.RestaurantRepository;
import com.example.GoReview.repositories.ReviewRepository;
import com.example.GoReview.repositories.UserRepository;
import com.example.GoReview.services.RestaurantService;
import com.example.GoReview.services.ReviewService;
import com.example.GoReview.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    RestaurantService restaurantService;
    @Autowired
    UserService userService;
    @Autowired
    ReviewService reviewService;

    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        User user1 = new User("alice1", "Alice One", "alice1@mail.com");
        userService.saveUser(user1);

        User user2 = new User("john2", "John Two", "john2@mail.com");
        userService.saveUser(user2);

        Restaurant restaurant1 = new Restaurant(1,"Nandos","Glasgow");
        restaurantService.saveRestaurant(restaurant1);

        Restaurant restaurant2 = new Restaurant(2,"Dominos","London");
        restaurantService.saveRestaurant(restaurant2);

        Restaurant restaurant3 = new Restaurant(3,"PizzaHut","Leeds");
        restaurantService.saveRestaurant(restaurant3);

        Review review1 = new Review(user1,restaurant1,"21/1/2022", Rating.EXCELLENT);
        reviewService.processReview(review1);

        Review review2 = new Review(user1,restaurant2,"1/10/2022", Rating.AVERAGE);
        reviewService.processReview(review2);

        Review review3 = new Review(user2,restaurant2,"5/12/2022", Rating.GOOD);
        reviewService.processReview(review3);

        Review review4 = new Review(user2,restaurant3,"17/3/2022", Rating.GOOD);
        reviewService.processReview(review4);

        Review review5 = new Review(user2,restaurant1,"6/4/2022", Rating.COMPLETELY_DISSATISFIED);
        reviewService.processReview(review5);


    }
}
