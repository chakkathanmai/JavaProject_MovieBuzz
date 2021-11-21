/**
 * 
 */
package com.moviebuzz.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.moviebuzz.exception.UserNotFoundException;
import com.moviebuzz.model.User;

/**
 * @author SrimanthChinta
 *
 */
public class UserRepositroyImpl implements IUserRepository {

	@Override
	public void registerUser(User user) {
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		Connection connection = ModelDao.openConnection();
		try {
			statement = connection.prepareStatement(Queries.INSERTUSERDETAILSQUERY);
			statement.setString(1, user.getUniqueId());
			statement.execute();
			System.out.println();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (statement != null)
					statement.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());

			}
		}
	}

	@Override
	public List<User> loginUser(User user) throws UserNotFoundException {

		// TODO Auto-generated method stub

		PreparedStatement statement = null;
		Connection connection = ModelDao.openConnection();
		String query = Queries.LOGINQUERY;
		List<User> userList = new ArrayList<>();
		try {
			statement = connection.prepareStatement(query);
			statement.setString(1, user.getUniqueId());
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				String uniqueId = result.getString("uniqueId");
				User userFound = new User(uniqueId);
				userList.add(userFound);
			}
			if (userList.isEmpty()) {
				throw new UserNotFoundException("User Not Found");
			}

		} catch (SQLException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (statement != null)
					statement.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());

			}
		}
		return userList;

	}

	@Override
	public void deleteUser(User user) throws UserNotFoundException {
		// TODO Auto-generated method stub

		// inner join and delete
		PreparedStatement statement = null;
		Connection connection = ModelDao.openConnection();
		try {
			statement = connection.prepareStatement(Queries.DELETEUSERQUERY);
			// statement.setString(1, "%"+ );
			statement.execute();
			System.out.println();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (statement != null)
					statement.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());

			}
		}

	}

	public void deleteReviewByUser(User user) throws UserNotFoundException {
		PreparedStatement statement = null;
		Connection connection = ModelDao.openConnection();
		try {
			statement = connection.prepareStatement(Queries.DELETEREVIEWBYADMINQUERY);
			statement.execute();
			System.out.println();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (statement != null)
					statement.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());

			}
		}
	}

}
