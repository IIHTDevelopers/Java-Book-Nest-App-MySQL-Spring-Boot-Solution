package com.booknest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.booknest.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

	@Query("SELECT r FROM Review r WHERE r.book.id = :bookId")
	List<Review> findByBookId(@Param("bookId") Long bookId);

	@Query("SELECT r FROM Review r WHERE r.user.id = :userId")
	List<Review> findByUserId(@Param("userId") Long userId);

	@Query("SELECT r FROM Review r")
	List<Review> findAllReviews();
}
