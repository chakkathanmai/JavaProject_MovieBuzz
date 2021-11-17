package com.moviebuzz.service;

import java.util.List;

import com.moviebuzz.model.Review;
import com.moviebuzz.repository.IReviewRepository;
import com.moviebuzz.repository.ReviewRepository;

public class ReviewService implements IReviewService{
	
	IReviewRepository reviewRepository = new ReviewRepository();
	@Override
	public void addReview(Review review) {
		// TODO Auto-generated method stub
		reviewRepository.addReview(review);
	}

	@Override
	public void updateReview(Review review) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Review> getUserReviewForMovie(String movieName, String uniqueId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getReviewForMovie(String movieName, String language) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteReview(String uniqueId, String movieName) {
		// TODO Auto-generated method stub
		
	}

}
