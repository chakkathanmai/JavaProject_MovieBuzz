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

	void registerUser(User user);

	public List<User> loginUser(User user) throws UserNotFoundException;

	void deleteUser(User user) throws UserNotFoundException;

}
