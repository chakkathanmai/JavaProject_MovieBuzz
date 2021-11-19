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

	/**
	 * 
	 * @param movieTitle
	 * @param genre
	 * @param language
	 * @param releasedYear
	 * @param movieId
	 * @param budget
	 * @param collection
	 */
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

	/**
	 * 
	 * @return the movieTitle
	 */
	public String getMovieTitle() {
		return movieTitle;
	}

	/**
	 * 
	 * @param movieTitle the movieTitle to set
	 */
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	/**
	 * 
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * 
	 * @param genre the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * 
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * 
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * 
	 * @return the releasedYear
	 */
	public int getReleasedYear() {
		return releasedYear;
	}

	/**
	 * 
	 * @param releasedYear the releasedYear to set
	 */
	public void setReleasedYear(int releasedYear) {
		this.releasedYear = releasedYear;
	}

	/**
	 * 
	 * @return the movieId
	 */
	public int getMovieId() {
		return movieId;
	}

	/**
	 * 
	 * @param movieId the movieId to set
	 */
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	/**
	 * 
	 * @return the budget
	 */
	public double getBudget() {
		return budget;
	}

	/**
	 * 
	 * @param budget the budget to set
	 */
	public void setBudget(double budget) {
		this.budget = budget;
	}

	/**
	 * 
	 * @return the collection
	 */
	public double getCollection() {
		return collection;
	}

	/**
	 * 
	 * @param collection the collection to set
	 */
	public void setCollection(double collection) {
		this.collection = collection;
	}

	@Override
	public String toString() {
		return "Movie --" + movieTitle + "\n" + "   Genre=" + genre + "   Language=" + language + "   Year of release="
				+ releasedYear + "   Movie Id=" + movieId + "\n";
	}

}
