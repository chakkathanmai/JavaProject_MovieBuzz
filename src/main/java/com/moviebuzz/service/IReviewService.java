package com.moviebuzz.service;

import java.util.List;

import com.moviebuzz.model.Review;

public interface IReviewService {
	
	void addReview(Review review);
	void updateReview(Review review);
	List<Review> getUserReviewForMovie(String movieName,String uniqueId);
	void getReviewForMovie(String movieName, String language);
	void deleteReview(String uniqueId, String movieName);

}
