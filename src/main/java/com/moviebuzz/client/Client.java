/**
 * Movie Review Application
 */
package com.moviebuzz.client;

import java.util.Scanner;

import com.moviebuzz.exception.MovieNotFoundException;
import com.moviebuzz.exception.UserNotFoundException;
import com.moviebuzz.model.Movie;
import com.moviebuzz.model.User;
import com.moviebuzz.service.AdminService;
import com.moviebuzz.service.IAdminService;
import com.moviebuzz.service.IUserService;
import com.moviebuzz.service.UserService;

/**
 * @author SrimanthChinta
 *
 */
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("------MOVIE REVIEW SYSTEM------");
		System.out.println();
		System.out.println(
				"We welcome you our MRS where you can write the review of any movie. You can share your views on the movie"
						+ " You can also communicate with the people like you. \n"
						+ "You can directly suggest the directors to make better movies.");
		System.out.println();

		System.out.println("Films started becoming grander and technologically advanced."
				+ " Careers in the film industry were no longer a taboo and many relocated to greener pastures and "
				+ "movie industry revenue ensured its propagation \n" + "Today, United States, Nigeria, Hong Kong and "
				+ "India are the leaders in filmmaking In Europe, France and the United Kingdom are the countries "
				+ "that lead in movie production. India is the largest producer of \n"
				+ "films in the world. The USA has "
				+ "a whole district - Hollywood in Los Angeles which caters exclusively to the movie industry. The actors, "
				+ "directors producers, singers are big names and bankable too. \n"
				+ "In this grandeur and showbiz, we didn’t actually "
				+ "pay much attention or didn’t bother to evaluate the effect of movies on youth and more "
				+ "importantly the impact of films on society. What is the role of \n" + "movies in our lives, "
				+ "are movies harmful or beneficial or both? To evaluate the worth of films, we need "
				+ "to weigh the pros and cons of movies. We also need to come to an understanding; how much "
				+ "importance \n" + "should we give or not give to films?");

		IUserService userService = new UserService();
		IAdminService adminService = new AdminService();
		System.out.println();
		Scanner scan = new Scanner(System.in);
		while (true) {

			System.out.println("1.User 2.Admin 3.Exit");
			int inputEntry = scan.nextInt();
			switch (inputEntry) {
			case 1:
				System.out.println();
				System.out.println("1.Login 2.SignUp 3.Back");

				int choice = scan.nextInt();
				switch (choice) {
				case 1:
					User user = new User();
					System.out.println("Enter your ID:");
					String id = scan.next();
					user.setUniqueId(id);
					try {
						userService.loginUser(user);
						System.out.println();
						System.out.println("Welcome...");

						System.out.println();
						System.out.println("1. Movies \n2.select movie by year\n3.select movie by genre\n"
								+ "4.select movie by language\n5.Add review");
						int login = scan.nextInt();

						switch (login) {

						case 1:
							System.out.println("Movies : ");
							System.out.println(adminService.getAllMovies());
							break;
						case 2:
							System.out.println("Enter year : ");
							int year = scan.nextInt();
							try {
								System.out.println(adminService.getMovieByYear(year));
							} catch (MovieNotFoundException e) {
								// TODO Auto-generated catch block
								System.out.println(e.getMessage());
							}
							break;
						case 3:
							System.out.println("Enter genre : ");
							String genre = scan.next();
							try {
								System.out.println(adminService.getMovieByGenre(genre));
							} catch (MovieNotFoundException e) {
								// TODO Auto-generated catch block
								System.out.println(e.getMessage());
							}
							break;
						case 4:
							System.out.println("Enter language: ");
							String language = scan.next();
							try {
								System.out.println(adminService.getMovieByLanguage(language));
							} catch (MovieNotFoundException e) {
								// TODO Auto-generated catch block
								System.out.println(e.getMessage());
							}
							break;
						case 5:
							System.out.println("Add review: ");
							System.out.println(adminService.getAllMovies());
							System.out.println("Select title from above list");
							String title=scan.next(); 
							
						}

					} catch (UserNotFoundException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
					break;
				case 2:
					User newUser = new User();
					System.out.print("Create your Unique Id : ");
					String uniqueId = scan.next();
					newUser.setUniqueId(uniqueId);
					userService.registerUser(newUser);
					System.out.println("Registration Successful.");
					break;
				case 3:
					break;
				}
				break;
			case 2:
				System.out.println();
				System.out.print("Enter uniqueId : ");
				String adminEntry = scan.next();
				if (adminEntry.equals("sriThanmai")) {
					// add movie,delete movie,delete user;
					System.out.println(
							"Do the necessary: 1 - add upcoming movies 2 - " + "delete movie 3 - delete User ");
					int adminChoice = scan.nextInt();
					switch (adminChoice) {
					case 1:
						Movie movie = new Movie();
						System.out.println("Adding movie..");
						System.out.println("Enter movie title: ");
						String movieTitle = scan.next();
						movie.setMovieTitle(movieTitle);
						System.out.println("Enter released year: ");
						int movieYear = scan.nextInt();
						movie.setReleasedYear(movieYear);
						System.out.println("Enter movie genre: ");
						String genre = scan.next();
						movie.setGenre(genre);
						System.out.println("Enter movie budget: ");
						double budget = scan.nextDouble();
						movie.setBudget(budget);
						System.out.println("Enter movie collection: ");
						double collection = scan.nextDouble();
						movie.setCollection(collection);
						System.out.println("Enter movie language: ");
						String language = scan.next();
						movie.setLanguage(language);
						System.out.println("Enter movie Id: ");
						int movieId = scan.nextInt();
						movie.setMovieId(movieId);
						adminService.addMovie(movie);
						System.out.println("Movie successfully added");
						break;
					case 2:
						break;
					case 3:
						// delete if any bad words;
						User admin = new User();
						break;
					}

				} else {
					System.out.println("went wrong.. Enter correct admin pin");
				}
				break;
			case 3:
				System.out.println("ThankYou..");
				System.exit(0);
			}
		}

	}

}
