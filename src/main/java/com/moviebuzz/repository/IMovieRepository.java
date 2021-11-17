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
public interface IMovieRepository {
	
	void addMovie(Movie movie);
	void deleteMovie(Movie movie) throws MovieNotFoundException;
	List<Movie> getMovieByLanguage(String language) throws MovieNotFoundException;
	List<Movie> getMovieByGenre(String genre) throws MovieNotFoundException;
	List<Movie> getMovieByYear(int releasedYear) throws MovieNotFoundException;
	List<Movie> getAllMovies();
}
