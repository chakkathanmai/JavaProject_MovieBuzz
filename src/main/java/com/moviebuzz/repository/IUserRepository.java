/**
 * 
 */
package com.moviebuzz.repository;

import com.moviebuzz.exception.UserNotFoundException;
import com.moviebuzz.model.User;

/**
 * @author SrimanthChinta
 *
 */
public interface IUserRepository {
	
	void registerUser(User user);
	
	void loginUser(User user) throws UserNotFoundException;
	
	void deleteUser(User user) throws UserNotFoundException;
	
}
