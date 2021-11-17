/**
 * 
 */
package com.moviebuzz.repository;

import java.util.List;

import com.moviebuzz.model.Review;

/**
 * @author SrimanthChinta
 *
 */
public interface IReviewRepository {
	
	void addReview(Review review);
	void updateReview(Review review);
	List<Review> getUserReviewForMovie(String movieName,String uniqueId);
	void getReviewForMovie(String movieName, String language);
	void deleteReview(String uniqueId, String movieName);
	
}
