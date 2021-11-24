package com.moviebuzz.service;

import java.util.List;

import com.moviebuzz.exception.MovieNotFoundException;

import com.moviebuzz.exception.UserNotFoundException;
import com.moviebuzz.model.Review;

public interface IReviewService {

	/**
	 * 
	 * @param review
	 */
	void addReview(Review review);

	/**
	 * 
	 * @param review
	 * @throws UserNotFoundException
	 */

	public boolean updateReview(Review review) throws UserNotFoundException;

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
	 * @param movieName
	 * @param uniqueId
	 * @return
	 * @throws MovieNotFoundException
	 */
	List<Review> getOtherUserResponses(String uniqueId) throws MovieNotFoundException;

}
