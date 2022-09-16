package com.example.GoReview.repositories;

import com.example.GoReview.models.Cuisine;
import com.example.GoReview.models.Restaurant;
import com.example.GoReview.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    @Query("SELECT r FROM restaurants r WHERE cuisine=?1")
    List<Restaurant> findByCuisine(Cuisine cuisine);

}