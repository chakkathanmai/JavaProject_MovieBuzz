/**
 * 
 */
package com.moviebuzz.service;

import java.util.List;

import com.moviebuzz.exception.UserNotFoundException;
import com.moviebuzz.model.User;

/**
 * @author SrimanthChinta
 *
 */
public interface IUserService {
	/**
	 * 
	 * @param user
	 */
	void registerUser(User user);
	/**
	 * 
	 * @param user
	 * @return
	 * @throws UserNotFoundException
	 */

	public List<User> loginUser(User user) throws UserNotFoundException;
	/**
	 * 
	 * @param user
	 * @throws UserNotFoundException
	 */
	void deleteUser(User user) throws UserNotFoundException;
	/**
	 * 
	 * @param user
	 * @throws UserNotFoundException
	 */
	public void deleteReviewByUser(User user) throws UserNotFoundException;
}
