package org.example.spring.review.repository;

import org.example.spring.review.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface reviewRepository extends JpaRepository<Review, Integer> {

}
