/**
 * 
 */
package com.moviebuzz.repository;

import java.util.List;

import com.moviebuzz.exception.MovieNotFoundException;
import com.moviebuzz.exception.UserNotFoundException;
import com.moviebuzz.model.Review;

/**
 * @author SrimanthChinta
 *
 */
public interface IReviewRepository {

	void addReview(Review review);

	void updateReview(Review review) throws UserNotFoundException;

	List<Review> getUserReviewForMovie(String movieName, String uniqueId) throws MovieNotFoundException;

	List<Review> getReviewForMovie(String movieName, String language) throws MovieNotFoundException;

	void deleteReview(String uniqueId, String movieName) throws Exception;

}
