package com.moviebuzz.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.moviebuzz.exception.MovieNotFoundException;
import com.moviebuzz.exception.UserNotFoundException;

import com.moviebuzz.model.Review;

public class ReviewRepositoryImpl implements IReviewRepository {

	Connection connection;

	@Override
	public void addReview(Review review)  {
		// TODO Auto-generated method stub
		Connection connection;
		connection = ModelDao.openConnection();
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(Queries.ADDREVIEWQUERY);
			statement.setInt(1, review.getMovieId());
			statement.setString(2, review.getReview());
			statement.setString(3, review.getPositives());
			statement.setString(4, review.getNegatives());
			statement.setInt(5, review.getOverallRating());
			statement.setString(6, review.getUniqueId());
			statement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public boolean updateReview(Review update) throws UserNotFoundException {
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		try {
			Connection connection = ModelDao.openConnection();
			statement = connection.prepareStatement(Queries.UPDATEREVIEWQUERY);
			statement.setString(1, update.getReview());
			statement.setString(2, update.getPositives());
			statement.setString(3, update.getNegatives());
			statement.setInt(4, update.getOverallRating());
			statement.setInt(5, update.getMovieId());
			statement.setString(6, update.getUniqueId());
			int count = statement.executeUpdate();
			if (count == 0) {
				throw new UserNotFoundException("Invalid");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ModelDao.closeConnection();
			}
		}
		return false;
	}

	@Override
	public List<Review> getUserReviewForMovie(String movieName, String uniqueId) throws MovieNotFoundException {
		// TODO Auto-generated method stub
		connection = ModelDao.openConnection();
		PreparedStatement preparedStatement = null;
		List<Review> reviewList = new ArrayList<>();

		try {

			preparedStatement = connection.prepareStatement(Queries.GETUSERREVIEWQUERY);
			preparedStatement.setString(1, uniqueId);
			preparedStatement.setString(2, movieName);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Review review = new Review();
				review.setMovieId(resultSet.getInt("movieId"));
				review.setReview(resultSet.getString("review"));
				review.setPositives(resultSet.getString("positive"));
				review.setNegatives(resultSet.getString("negative"));
				review.setOverallRating(resultSet.getInt("overallRating"));
				reviewList.add(review);
			}
			if (reviewList.isEmpty()) {
				throw new MovieNotFoundException("Error with Id or movie not available");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		// TODO Auto-generated method stub
		return reviewList;
	}

	@Override
	public List<Review> getReviewForMovie(String movieName, String language) throws MovieNotFoundException {
		// TODO Auto-generated method stub
		connection = ModelDao.openConnection();
		PreparedStatement preparedStatement = null;
		List<Review> reviewList = new ArrayList<>();

		try {

			preparedStatement = connection.prepareStatement(Queries.GETREVIEWFORMOVIEQUERY);
			preparedStatement.setString(1, movieName);
			preparedStatement.setString(2, language);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Review review = new Review();
				review.setMovieId(resultSet.getInt("movieId"));
				review.setReview(resultSet.getString("review"));
				review.setPositives(resultSet.getString("positive"));
				review.setNegatives(resultSet.getString("negative"));
				review.setOverallRating(resultSet.getInt("overallRating"));
				reviewList.add(review);
			}
			if (reviewList.isEmpty()) {
				throw new MovieNotFoundException("input error with the language or movie name");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		// TODO Auto-generated method stub
		return reviewList;
	}

	@Override
	public void deleteReview(String uniqueId, String movieName) throws Exception {
		// TODO Auto-generated method stub
		// inner join and delete
		PreparedStatement statement = null;
		Connection connection = ModelDao.openConnection();
		try {
			statement = connection.prepareStatement(Queries.DELETEREVIEWQUERY);
			statement.setString(1, uniqueId);
			statement.setString(2, movieName);
			statement.execute();
			System.out.println();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			throw e;
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
	public List<Review> getOtherUserResponses(String uniqueId) throws MovieNotFoundException {
		// TODO Auto-generated method stub
		connection = ModelDao.openConnection();
		PreparedStatement preparedStatement = null;
		List<Review> reviewList = new ArrayList<>();

		try {

			preparedStatement = connection.prepareStatement(Queries.GETOTHERREVIEWRESPONSESQUERY);
			preparedStatement.setString(1, uniqueId);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Review review = new Review();
				review.setMovieId(resultSet.getInt("movieId"));
				review.setReview(resultSet.getString("review"));
				review.setPositives(resultSet.getString("positive"));
				review.setNegatives(resultSet.getString("negative"));
				review.setOverallRating(resultSet.getInt("overallRating"));
				reviewList.add(review);
			}
			if (reviewList.isEmpty()) {
				throw new MovieNotFoundException("No other responses for this movie");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		// TODO Auto-generated method stub
		return reviewList;
	}

}
