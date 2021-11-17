package com.moviebuzz.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.moviebuzz.model.Review;

public class ReviewRepository implements IReviewRepository {

	@Override
	public void addReview(Review review) {
		// TODO Auto-generated method stub
		Connection connection;
		connection = ModelDao.openConnection();
		PreparedStatement statement = null;

		try {
			String query = "insert into review values(?,?,?,?);";
			statement = connection.prepareStatement(query);
			statement.setString(1, review.getReview());
			statement.setString(2, review.getPositives());
			statement.setString(3, review.getNegatives());
			statement.setDouble(4, review.getOverallRating());
			statement.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void updateReview(Review review) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Review> getUserReviewForMovie(String movieName, String uniqueId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getReviewForMovie(String movieName, String language) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteReview(String uniqueId, String movieName) {
		// TODO Auto-generated method stub

	}

}
