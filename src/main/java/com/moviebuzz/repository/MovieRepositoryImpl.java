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

import com.moviebuzz.exception.MovieNotFoundException;
import com.moviebuzz.model.Movie;

/**
 * @author SrimanthChinta
 *
 */
public class MovieRepositoryImpl implements IMovieRepository {
	Connection connection;
	
	@Override
	public void addMovie(Movie movie) {
		// TODO Auto-generated method stub
		connection = ModelDao.openConnection();
		PreparedStatement statement = null;

		try {
			String query = Queries.ADDMOVIEQUERY;
			statement = connection.prepareStatement(query);
			statement.setString(1, movie.getMovieTitle());
			statement.setInt(2, movie.getReleasedYear());
			statement.setString(3, movie.getGenre());
			statement.setDouble(4, movie.getBudget());
			statement.setDouble(5, movie.getCollection());
			statement.setString(6,movie.getLanguage());
			statement.setInt(7, movie.getMovieId());
			statement.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void deleteMovie(Movie movie) throws MovieNotFoundException {
		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		Connection connection = ModelDao.openConnection();
		try {
			statement = connection.prepareStatement(Queries.DELETEMOVIEQUERY);
			statement.setInt(1, movie.getMovieId());
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
	public List<Movie> getMovieByLanguage(String language) throws MovieNotFoundException {
		// TODO Auto-generated method stub
		connection = ModelDao.openConnection();
		PreparedStatement preparedStatement = null;
		List<Movie> moviesList = new ArrayList<>();

		try {
			String query = Queries.GETMOVIEBYLANGUAGEQUERY;
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, language);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Movie movie = new Movie();
				movie.setMovieTitle(rs.getString("movieTitle"));
				movie.setReleasedYear(rs.getInt("releasedYear"));
				movie.setGenre(rs.getString("genre"));
				movie.setLanguage(rs.getString("language"));
				moviesList.add(movie);
			}
			if(moviesList.isEmpty()) {
				throw new MovieNotFoundException("Language not available");
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
		return moviesList;
	}

	@Override
	public List<Movie> getMovieByGenre(String genre) throws MovieNotFoundException {
		// TODO Auto-generated method stub
		connection = ModelDao.openConnection();
		PreparedStatement preparedStatement = null;
		List<Movie> moviesList = new ArrayList<>();

		try {
			String query = Queries.GETMOVIEBYGENREQUERY;
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, genre);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Movie movie = new Movie();
				movie.setMovieTitle(rs.getString("movieTitle"));
				movie.setReleasedYear(rs.getInt("releasedYear"));
				movie.setGenre(rs.getString("genre"));
				movie.setLanguage(rs.getString("language"));
				moviesList.add(movie);
			}
			if(moviesList.isEmpty()) {
				throw new MovieNotFoundException("Genre not available");
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
		return moviesList;
	}

	@Override
	public List<Movie> getMovieByYear(int releasedYear) throws MovieNotFoundException {
		// TODO Auto-generated method stub
		connection = ModelDao.openConnection();
		PreparedStatement preparedStatement = null;
		List<Movie> moviesList = new ArrayList<>();

		try {
			String query = Queries.GETMOVIEBYYEARQUERY;
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, releasedYear);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Movie movie = new Movie();
				movie.setMovieTitle(rs.getString("movieTitle"));
				movie.setReleasedYear(rs.getInt("releasedYear"));
				movie.setGenre(rs.getString("genre"));
				movie.setLanguage(rs.getString("language"));
				moviesList.add(movie);
			}
			if(moviesList.isEmpty()) {
				throw new MovieNotFoundException("No movie released in that year");
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
		return moviesList;
	}

	@Override
	public List<Movie> getAllMovies() {
		// TODO Auto-generated method stub
		connection = ModelDao.openConnection();
		PreparedStatement prepareStatement = null;
		List<Movie> moviesList = new ArrayList<Movie>();
		try {
			String query = Queries.GETALLMOVIESQUERY;
			prepareStatement = connection.prepareStatement(query);
			ResultSet resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				Movie movie = new Movie();
				
				movie.setMovieTitle(resultSet.getString("movieTitle"));
				movie.setReleasedYear(resultSet.getInt("releasedYear"));
				movie.setGenre(resultSet.getString("genre"));
				
				movie.setLanguage(resultSet.getString("language"));
				moviesList.add(movie);
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			try {
				if (connection != null)
					connection.close();
				if (prepareStatement != null)
					prepareStatement.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());

			}
		}
		return moviesList;
	}

}
