/**
 * 
 */
package com.moviebuzz.service;

import java.util.List;

import com.moviebuzz.exception.UserNotFoundException;
import com.moviebuzz.model.User;
import com.moviebuzz.repository.IUserRepository;
import com.moviebuzz.repository.UserRepositroyImpl;

/**
 * @author SrimanthChinta
 *
 */
public class UserService implements IUserService {

	IUserRepository userRepository = new UserRepositroyImpl();

	@Override
	public void registerUser(User user) {
		// TODO Auto-generated method stub
		userRepository.registerUser(user);
	}

	@Override
	public List<User> loginUser(User user) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return userRepository.loginUser(user);
	}

	@Override
	public void deleteUser(User user) throws UserNotFoundException {
		// TODO Auto-generated method stub
		userRepository.deleteUser(user);
	}

	@Override
	public void deleteReviewByUser(User user) throws UserNotFoundException {
		// TODO Auto-generated method stub
		userRepository.deleteReviewByUser(user);
	}

}
