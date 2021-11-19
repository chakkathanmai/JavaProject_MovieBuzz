/**
 * 
 */
package com.moviebuzz.repository;

/**
 * @author SrimanthChinta
 *
 */
public class Queries {
	
	public static final String ADDMOVIEQUERY = "insert into movie values(?,?,?,?,?,?,?);";
	public static final String GETMOVIEBYLANGUAGEQUERY = "select movieTitle,language,releasedYear,genre from movie where language= ?";
	public static final String GETMOVIEBYGENREQUERY = "select movieTitle,language,releasedYear,genre from movie where genre= ?";
	public static final String GETMOVIEBYYEARQUERY = "select movieTitle,language,releasedYear,genre from movie where releasedYear= ?";
	public static final String GETALLMOVIESQUERY = "select movieId,movieTitle,releasedYear,genre,language from movie";
	public static final String INSERTUSERDETAILSQUERY = "insert into user_details values(?)";
	public static final String LOGINQUERY = "select uniqueId from user_details where uniqueId= ?";
	public static final String DELETEMOVIEQUERY = "delete from movie where movieId=?";
	public static final String ADDREVIEWQUERY = "insert into review values(?,?,?,?,?,?)";
	public static final String UPDATEREVIEWQUERY = "update review set review = ?,positive=?,negative=?,overallRating=?  where movieId=? and uniqueId=?";
    public static final String GETUSERREVIEWQUERY = "select review,positive,negative,overallRating from review where uniqueId= ? and movieId= (select movieId from movie where movieTitle=?)";
    public static final String GETREVIEWFORMOVIEQUERY = "select review,positive,negative,overallRating from review where movieId= (select movieId from movie where movieTitle=? and language=?)";
    public static final String DELETEREVIEWQUERY = "delete from review where uniqueId = ? and movieId = (select movieId from movie where movieTitle=?)";
}
