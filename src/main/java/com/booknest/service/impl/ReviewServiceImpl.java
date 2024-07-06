package com.booknest.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booknest.dto.ReviewDTO;
import com.booknest.entity.Review;
import com.booknest.exception.NotFoundException;
import com.booknest.repo.ReviewRepository;
import com.booknest.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ReviewDTO addReview(ReviewDTO reviewDTO) {
		Review review = modelMapper.map(reviewDTO, Review.class);
		Review savedReview = reviewRepository.save(review);
		return modelMapper.map(savedReview, ReviewDTO.class);
	}

	@Override
	public List<ReviewDTO> getReviewsForBook(Long bookId) {
		List<Review> reviews = reviewRepository.findByBookId(bookId);
		return reviews.stream().map(review -> modelMapper.map(review, ReviewDTO.class)).collect(Collectors.toList());
	}

	@Override
	public ReviewDTO updateReview(Long reviewId, ReviewDTO reviewDTO) {
		Review review = reviewRepository.findById(reviewId)
				.orElseThrow(() -> new NotFoundException("Review not found"));
		review.setRating(reviewDTO.getRating());
		review.setComment(reviewDTO.getComment());
		Review updatedReview = reviewRepository.save(review);
		return modelMapper.map(updatedReview, ReviewDTO.class);
	}

	@Override
	public void deleteReview(Long reviewId) {
		Review review = reviewRepository.findById(reviewId)
				.orElseThrow(() -> new NotFoundException("Review not found"));
		reviewRepository.delete(review);
	}

	@Override
	public List<ReviewDTO> getReviewsForUser(Long userId) {
		List<Review> reviews = reviewRepository.findByUserId(userId);
		return reviews.stream().map(review -> modelMapper.map(review, ReviewDTO.class)).collect(Collectors.toList());
	}

	@Override
	public List<ReviewDTO> getAllReviews() {
		List<Review> reviews = reviewRepository.findAllReviews();
		return reviews.stream().map(review -> modelMapper.map(review, ReviewDTO.class)).collect(Collectors.toList());
	}
}
