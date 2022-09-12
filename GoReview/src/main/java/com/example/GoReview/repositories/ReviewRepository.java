package com.example.GoReview.repositories;

import com.example.GoReview.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {





    List<Review> findByUserId(long id);
}
