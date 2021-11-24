/**
 * Movie Review Application
 */
package com.moviebuzz.client;

import java.util.Scanner;

import com.moviebuzz.exception.MovieNotFoundException;
import com.moviebuzz.exception.UserNotFoundException;
import com.moviebuzz.model.Movie;
import com.moviebuzz.model.Review;
import com.moviebuzz.model.User;
import com.moviebuzz.service.AdminService;
import com.moviebuzz.service.IAdminService;
import com.moviebuzz.service.IReviewService;
import com.moviebuzz.service.IUserService;
import com.moviebuzz.service.ReviewService;
import com.moviebuzz.service.UserService;

/**
 * @author SrimanthChinta
 *
 */
public class Client {

	/**
	 * @param args
	 */
	static Scanner input = new Scanner(System.in);
	static IAdminService adminService = new AdminService();
	static IUserService userService = new UserService();
	static IReviewService reviewService = new ReviewService();
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println("------MOVIE BUZZ------");
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

		System.out.println();
		
		try {
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
							adminService.getAllMovies().forEach(System.out::println);
							System.out.println();
							System.out.println("1.filter by year\n2.filter by genre\n"
									+ "3.filter by language\n4.Add review\n5.Get my review\n6.Delete my review\n7.Get my review by language\n8.Update my review\n9.Get other public responses");
							System.out.println("0.Exit");
							System.out.println("Enter your choice");
							int login;
							do {
								login = scan.nextInt();

								switch (login) {

								case 1:

									try {
										yearFunc();
										System.out.println("Enter your choice");
									} catch (MovieNotFoundException e) {
										// TODO Auto-generated catch block
										System.out.println(e.getMessage());
										yearFunc();
									}
									
									break;
								case 2:

									try {
										genreFunc();
										System.out.println("Enter your choice");
									} catch (MovieNotFoundException e) {
										// TODO Auto-generated catch block
										System.out.println(e.getMessage());
										genreFunc();
									}
									
									break;
								case 3:
									try {
										languageFunc();
										System.out.println("Enter your choice");
									} catch (MovieNotFoundException e) {
										System.out.println(e.getMessage());
										languageFunc();
									}
									break;
								case 4:
									Review review = new Review();
									System.out.println("Add review: ");
									System.out.println("Enter movie Id : ");
									int movieId = scan.nextInt();
									review.setMovieId(movieId);
									System.out.println("Enter review: ");
									scan.nextLine();
									String userReview = scan.nextLine();
									review.setReview(userReview);
									System.out.println("Enter positives: ");
									
									
									String positives = scan.nextLine();
									review.setPositives(positives);
									System.out.println("Enter negatives: ");
									
									String negatives = scan.nextLine();
									review.setNegatives(negatives);
									System.out.println("Enter overall rating(1-5): ");
									int overallRating = scan.nextInt();
									review.setOverallRating(overallRating);
									System.out.println("Enter unique Id: ");
									String uniqueId = scan.next();
									review.setUniqueId(uniqueId);
									try {
										reviewService.addReview(review);
										System.out.println("Your review successfully added");
										System.out.println("Enter your choice");
									} catch (Exception e1) {
										// TODO Auto-generated catch block
										System.out.println(e1.getMessage());
									}

									break;
								case 5:

									
									try {
										userReviewFunc();
									} catch (MovieNotFoundException e) {
										// TODO Auto-generated catch block
										System.out.println(e.getMessage());
										userReviewFunc();
									}
									break;
								case 6:
									System.out.println("Enter movie name:");
									String movieTitle = scan.next();
									System.out.println("Enter your unique ID: ");
									String uniqueUserId = scan.next();
									reviewService.deleteReview(uniqueUserId, movieTitle);
									System.out.println("Selected review deleted");
									break;
								case 7:
									System.out.println("Enter movie name:");
									String movieTag = scan.next();
									System.out.println("Enter language: ");
									String languageTag = scan.next();
									try {
										System.out.println(reviewService.getReviewForMovie(movieTag, languageTag));
									} catch (MovieNotFoundException e) {
										// TODO Auto-generated catch block
										System.out.println(e.getMessage());
									}
									break;
								case 8:
									Review updateReview = new Review();
									System.out.println("Enter your uniqueId again:");
									String uniqueCode = scan.next();
									updateReview.setUniqueId(uniqueCode);
									System.out.println("Enter movie Id to update:");
									int movieCode = scan.nextInt();
									updateReview.setMovieId(movieCode);
									System.out.println("Update review: ");
									scan.nextLine();
									String reviewUpdation = scan.nextLine();
									updateReview.setReview(reviewUpdation);
									System.out.println("Update positives: ");

									String positiveUpdation = scan.nextLine();
									updateReview.setPositives(positiveUpdation);
									System.out.println("Update negatives: ");

									String negativeUpdation = scan.nextLine();
									updateReview.setNegatives(negativeUpdation);

									System.out.println("Update overall rating: ");
									int overallRatingUpdate = scan.nextInt();
									updateReview.setOverallRating(overallRatingUpdate);

									reviewService.updateReview(updateReview);
									System.out.println("Review updated successfully");
									break;
								case 9:
									System.out.println("All other public responses: ");
									try {
										System.out.println(reviewService.getOtherUserResponses(id));
									} catch (MovieNotFoundException e) {
										// TODO Auto-generated catch block
										System.out.println(e.getMessage());
									}
									
								}
							} while (login != 0);
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
					System.out.print("Enter Admin Id : ");
					String adminEntry;

					adminEntry = scan.next();
					int adminChoice;
					if (adminEntry.equals("sriThanmai")) {
						// add movie,delete movie,delete user;

						do {
							System.out.println(
									"Do the necessary: 1 - add movie 2 - " + "delete movie 3 - delete User ");
							System.out.println("0.Exit");

							adminChoice = scan.nextInt();
							switch (adminChoice) {
							case 1:
								Movie movie = new Movie();
								System.out.println("Adding movie..");
								System.out.println("Enter movie title: ");
								scan.nextLine();
								String movieTitle = scan.nextLine();
								movie.setMovieTitle(movieTitle);
								System.out.println("Enter released year: ");
								int movieYear = scan.nextInt();
								movie.setReleasedYear(movieYear);
								System.out.println("Enter movie genre: ");
								scan.nextLine();
								String genre = scan.nextLine();
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
								adminService.addMovie(movie);
								System.out.println("Movie successfully added");
								break;
							case 2:
								Movie movieToDelete = new Movie();
								System.out.println("Enter movie Id you want to delete: ");
								int movieIdToDelete = scan.nextInt();
								movieToDelete.setMovieId(movieIdToDelete);
								try {
									adminService.deleteMovie(movieToDelete);
									System.out.println("Deleted successfully");
									System.out.println();
								} catch (MovieNotFoundException e) {
									// TODO Auto-generated catch block
									System.out.println(e.getMessage());
								}
								break;
							case 3:
								// delete if any bad words;
								User user = new User();
								try {
									userService.deleteUser(user);
									userService.deleteReviewByUser(user);
									System.out.println("Culprit got suspended..");
									System.out.println();
								} catch (UserNotFoundException e) {
									// TODO Auto-generated catch block
									System.out.println(e.getMessage());
								}
								break;

							}

						} while (adminChoice != 0);
					}

					else {
						System.out.println("went wrong.. Enter correct admin pin");
					}

					break;
				case 3:
					System.out.println("ThankYou..");
					System.exit(0);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block

			System.out.println("Sorry..Input Error");
		}
		scan.close();

	}

	static void languageFunc() throws MovieNotFoundException {
		System.out.println();
		System.out.println("Enter language: ");
		String language = input.next();
		System.out.println();
		System.out.println(adminService.getMovieByLanguage(language));
	}

	static void genreFunc() throws MovieNotFoundException {
		System.out.println();
		System.out.println("Enter genre: ");
		String genre = input.next();
		System.out.println();
		System.out.println(adminService.getMovieByGenre(genre));
	}

	static void yearFunc() throws MovieNotFoundException {
		System.out.println();
		System.out.println("Enter year: ");
		int year = input.nextInt();
		System.out.println();
		System.out.println(adminService.getMovieByYear(year));
	}
	static void userReviewFunc() throws MovieNotFoundException{
		System.out.println("Enter movie name:");
		scan.nextLine();
		String movieName = scan.nextLine();
		System.out.println("Enter your unique ID: ");
		String userUniqueId = scan.next();
		System.out
		.println(reviewService.getUserReviewForMovie(movieName, userUniqueId));
	}

}
