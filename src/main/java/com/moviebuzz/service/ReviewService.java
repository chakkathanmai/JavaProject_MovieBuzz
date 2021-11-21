package com.moviebuzz.service;

import java.util.List;

import com.moviebuzz.exception.MovieNotFoundException;

import com.moviebuzz.exception.UserNotFoundException;
import com.moviebuzz.model.Review;
import com.moviebuzz.repository.IReviewRepository;
import com.moviebuzz.repository.ReviewRepositoryImpl;

public class ReviewService implements IReviewService {

	IReviewRepository reviewRepository = new ReviewRepositoryImpl();

	@Override
	public void addReview(Review review) {
		// TODO Auto-generated method stub
		reviewRepository.addReview(review);
	}

	@Override
	public void updateReview(Review review) throws UserNotFoundException {
		// TODO Auto-generated method stub
		reviewRepository.updateReview(review);
	}

	@Override
	public void deleteReview(String uniqueId, String movieName) throws Exception {
		// TODO Auto-generated method stub
		reviewRepository.deleteReview(uniqueId, movieName);
	}

	@Override
	public List<Review> getUserReviewForMovie(String movieName, String uniqueId) throws MovieNotFoundException {
		// TODO Auto-generated method stub
		return reviewRepository.getUserReviewForMovie(movieName, uniqueId);
	}

	@Override
	public List<Review> getReviewForMovie(String movieName, String language) throws MovieNotFoundException {
		// TODO Auto-generated method stub
		return reviewRepository.getReviewForMovie(movieName, language);
	}

	@Override
	public List<Review> getOtherUserResponses(String uniqueId) throws MovieNotFoundException {
		// TODO Auto-generated method stub
		return reviewRepository.getOtherUserResponses(uniqueId);
	}

	
}
