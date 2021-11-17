/**
 * 
 */
package com.moviebuzz.repository;

import java.util.List;

import com.moviebuzz.exception.MovieNotFoundException;
import com.moviebuzz.model.Movie;

/**
 * @author SrimanthChinta
 *
 */
public class MovieRepositoryImpl implements IMovieRepository {

	@Override
	public void addMovie(Movie movie) {
		// TODO Auto-generated method stub
		

	}

	@Override
	public void deleteMovie(Movie movie) throws MovieNotFoundException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Movie> getMovieByLanguage(String language) throws MovieNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movie> getMovieByGenre(String genre) throws MovieNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movie> getMovieByYear(int releasedYear) throws MovieNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movie> getAllMovies() {
		// TODO Auto-generated method stub
		return null;
	}

}
