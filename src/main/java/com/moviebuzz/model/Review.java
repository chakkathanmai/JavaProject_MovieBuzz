/**
 * 
 */
package com.moviebuzz.model;

/**
 * @author SrimanthChinta
 *
 */
public class Review {
	
	private int movieId;
	private String review;
	private String positives;
	private String negatives;
	private int overallRating;
	private String uniqueId;
	/**
	 * 
	 */
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param movieId
	 * @param review
	 * @param positives
	 * @param negatives
	 * @param overallRating
	 * @param uniqueId
	 */
	public Review(int movieId, String review, String positives, String negatives, int overallRating, String uniqueId) {
		super();
		this.movieId = movieId;
		this.review = review;
		this.positives = positives;
		this.negatives = negatives;
		this.overallRating = overallRating;
		this.uniqueId = uniqueId;
	}
	/**
	 * @return the movieId
	 */
	public int getMovieId() {
		return movieId;
	}
	/**
	 * @param movieId the movieId to set
	 */
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	/**
	 * @return the review
	 */
	public String getReview() {
		return review;
	}
	/**
	 * @param review the review to set
	 */
	public void setReview(String review) {
		this.review = review;
	}
	/**
	 * @return the positives
	 */
	public String getPositives() {
		return positives;
	}
	/**
	 * @param positives the positives to set
	 */
	public void setPositives(String positives) {
		this.positives = positives;
	}
	/**
	 * @return the negatives
	 */
	public String getNegatives() {
		return negatives;
	}
	/**
	 * @param negatives the negatives to set
	 */
	public void setNegatives(String negatives) {
		this.negatives = negatives;
	}
	/**
	 * @return the overallRating
	 */
	public int getOverallRating() {
		return overallRating;
	}
	/**
	 * @param overallRating the overallRating to set
	 */
	public void setOverallRating(int overallRating) {
		this.overallRating = overallRating;
	}
	/**
	 * @return the uniqueId
	 */
	public String getUniqueId() {
		return uniqueId;
	}
	/**
	 * @param uniqueId the uniqueId to set
	 */
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	@Override
	public String toString() {
		return "Review -- [ review=" + review + ", positives=" + positives + ", negatives="
				+ negatives + ", overallRating=" + overallRating + "]";
	}

	

}
