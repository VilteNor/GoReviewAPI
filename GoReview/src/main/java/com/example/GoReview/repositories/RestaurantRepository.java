package com.example.GoReview.repositories;

import com.example.GoReview.models.Diet;
import com.example.GoReview.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    //Optional<Restaurant> findAllByDiet(Diet diet);

    /*
    @Query(value = "SELECT r FROM restaurants r INNER JOIN reviews ON reviews.restaurant_id = r.id JOIN reviews_diets d WHERE d.diet =?1", nativeQuery = true)
    List<Restaurant> getRestaurantsByDiet(int ordinal);


     */
}