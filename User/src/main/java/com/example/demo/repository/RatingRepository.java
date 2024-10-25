package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Rating;

/*Author: Sanket Nadargi*/

@Repository
public interface RatingRepository extends JpaRepository<Rating,Long>{
	
	// Custom query to calculate the average rating for a specific app
	@Query("SELECT AVG(r.value) FROM Rating r WHERE r.app.id = :appId")
    double calculateAverageRating(@Param("appId") Long appId);
}
