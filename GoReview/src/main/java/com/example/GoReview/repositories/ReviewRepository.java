package com.example.GoReview.repositories;

import com.example.GoReview.models.Diet;
import com.example.GoReview.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {





    List<Review> findByUserId(long id);

    List<Review> findByRating(int rating);
    List<Review> findAllByUserId(long id);

    List<Review> findAllByUserUsername(String username);

    @Query("SELECT r FROM reviews r JOIN r.diets d WHERE d=?1")
    List<Review> findByDiet(Diet diet);


    /*
    @Query(
            "SELECT g FROM games g " // from now on, will use g to refer to the games table
                    + "WHERE g.complete = TRUE "
                    + "AND (:word IS NULL OR g.word = :word) "
                    + "AND (:guesses IS NULL OR g.guesses < :guesses)" // Strings into an SQL query
    )
    List<Game> findByMultiOptionalParams(@Param("word") String word, @Param("guesses") Integer guesses); // injecting Strings into an SQL query - "" should match


     */
}


