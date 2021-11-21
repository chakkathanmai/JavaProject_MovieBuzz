/**
 * 
 */
package com.moviebuzz.service;

import java.util.List;

import com.moviebuzz.exception.MovieNotFoundException;
import com.moviebuzz.model.Movie;

/**
 * @author SrimanthChinta
 *
 */
public interface IAdminService {
	/**
	 * 
	 * @param movie
	 */
	void addMovie(Movie movie);
	/**
	 * 
	 * @param movie
	 * @throws MovieNotFoundException
	 */

	void deleteMovie(Movie movie) throws MovieNotFoundException;
	/**
	 * 
	 * @param language
	 * @return
	 * @throws MovieNotFoundException
	 */

	List<Movie> getMovieByLanguage(String language) throws MovieNotFoundException;

	/**
	 * 
	 * @param genre
	 * @return
	 * @throws MovieNotFoundException
	 */
	List<Movie> getMovieByGenre(String genre) throws MovieNotFoundException;

	/**
	 * 
	 * @param releasedYear
	 * @return
	 * @throws MovieNotFoundException
	 */
	List<Movie> getMovieByYear(int releasedYear) throws MovieNotFoundException;

	/**
	 * 
	 * @return
	 */
	List<Movie> getAllMovies();
}
