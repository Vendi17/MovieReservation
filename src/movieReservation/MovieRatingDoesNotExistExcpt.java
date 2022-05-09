package movieReservation;

/*
 * Exception kezelesek
 */
public class MovieRatingDoesNotExistExcpt extends Exception {

	public MovieRatingDoesNotExistExcpt(String mess) {
		System.out.println(mess);
	}
}
