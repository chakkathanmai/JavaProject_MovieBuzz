/**
 * 
 */
package com.moviebuzz.model;

/**
 * @author SrimanthChinta
 *
 */
public class Movie {

	private String movieTitle;
	private String genre;
	private String language;
	private int releasedYear;
	private int movieId;
	private double budget;
	private double collection;

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(String movieTitle, String genre, String language, int releasedYear, int movieId, double budget,
			double collection) {
		super();
		this.movieTitle = movieTitle;
		this.genre = genre;
		this.language = language;
		this.releasedYear = releasedYear;
		this.movieId = movieId;
		this.budget = budget;
		this.collection = collection;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getReleasedYear() {
		return releasedYear;
	}

	public void setReleasedYear(int releasedYear) {
		this.releasedYear = releasedYear;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public double getCollection() {
		return collection;
	}

	public void setCollection(double collection) {
		this.collection = collection;
	}

	@Override
	public String toString() {
		return "movieTitle=" + movieTitle + ", genre=" + genre + ", language=" + language + ", releasedYear="
				+ releasedYear + "\n";
	}

}
