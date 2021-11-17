/**
 * 
 */
package com.moviebuzz.service;

import java.util.List;

import com.moviebuzz.exception.MovieNotFoundException;
import com.moviebuzz.model.Movie;
import com.moviebuzz.repository.IMovieRepository;
import com.moviebuzz.repository.MovieRepositoryImpl;

/**
 * @author SrimanthChinta
 *
 */
public class AdminService implements IAdminService {

	IMovieRepository movieRepository = new MovieRepositoryImpl();

	@Override
	public void addMovie(Movie movie) {
		// TODO Auto-generated method stub
		movieRepository.addMovie(movie);
	}

	@Override
	public void deleteMovie(Movie movie) throws MovieNotFoundException {
		// TODO Auto-generated method stub
	}

	@Override
	public List<Movie> getMovieByLanguage(String language) throws MovieNotFoundException {
		// TODO Auto-generated method stub
		return movieRepository.getMovieByLanguage(language);
	}

	@Override
	public List<Movie> getMovieByGenre(String genre) throws MovieNotFoundException {
		// TODO Auto-generated method stub
		return movieRepository.getMovieByGenre(genre);
	}

	@Override
	public List<Movie> getMovieByYear(int releasedYear) throws MovieNotFoundException {
		// TODO Auto-generated method stub
		return movieRepository.getMovieByYear(releasedYear);
	}

	@Override
	public List<Movie> getAllMovies() {
		// TODO Auto-generated method stub
		
		return movieRepository.getAllMovies();
	}

}
