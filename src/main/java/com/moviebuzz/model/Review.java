/**
 * 
 */
package com.moviebuzz.model;

/**
 * @author SrimanthChinta
 *
 */
public class Review {

	Movie movie;
	User user;
	String review;
	String positives;
	String negatives;
	int overallRating;

	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Review(Movie movie, User user, String review, String positives, String negatives, int overallRating) {
		super();
		this.movie = movie;
		this.user = user;
		this.review = review;
		this.positives = positives;
		this.negatives = negatives;
		this.overallRating = overallRating;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getPositives() {
		return positives;
	}

	public void setPositives(String positives) {
		this.positives = positives;
	}

	public String getNegatives() {
		return negatives;
	}

	public void setNegatives(String negatives) {
		this.negatives = negatives;
	}

	public int getOverallRating() {
		return overallRating;
	}

	public void setOverallRating(int overallRating) {
		this.overallRating = overallRating;
	}

	@Override
	public String toString() {
		return "Review [movie=" + movie + ", user=" + user + ", review=" + review + ", positives=" + positives
				+ ", negatives=" + negatives + ", overallRating=" + overallRating + "]";
	}

}
