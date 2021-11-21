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
	/**
	 * ss
	 * 
	 * @param review
	 */
	void addReview(Review review);

	/**
	 * 
	 * @param review
	 * @throws UserNotFoundException
	 */

	void updateReview(Review review) throws UserNotFoundException;

	/**
	 * 
	 * @param movieName
	 * @param uniqueId
	 * @return
	 * @throws MovieNotFoundException
	 */
	List<Review> getUserReviewForMovie(String movieName, String uniqueId) throws MovieNotFoundException;

	/**
	 * 
	 * @param movieName
	 * @param language
	 * @return
	 * @throws MovieNotFoundException
	 */
	List<Review> getReviewForMovie(String movieName, String language) throws MovieNotFoundException;

	/**
	 * 
	 * @param uniqueId
	 * @param movieName
	 * @throws Exception
	 */
	void deleteReview(String uniqueId, String movieName) throws Exception;

	/**
	 * 
	 * @param uniqueId
	 * @return
	 * @throws MovieNotFoundException
	 */
	List<Review> getOtherUserResponses(String uniqueId) throws MovieNotFoundException;

}
