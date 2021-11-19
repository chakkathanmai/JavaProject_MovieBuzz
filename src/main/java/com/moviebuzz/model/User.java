/**
 * 
 */
package com.moviebuzz.model;

/**
 * @author SrimanthChinta
 *
 */
public class User {

	private String uniqueId;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String uniqueId) {
		super();
		this.uniqueId = uniqueId;
	}

	/**
	 * 
	 * @return uniqueId
	 */
	public String getUniqueId() {
		return uniqueId;
	}

	/**
	 * 
	 * @param uniqueId the uniqueId to set
	 */
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	@Override
	public String toString() {
		return "User [uniqueId=" + uniqueId + "]";
	}

}
