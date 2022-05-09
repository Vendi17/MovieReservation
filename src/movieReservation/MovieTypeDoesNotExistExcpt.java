package movieReservation;

/*
 * Exception kezelesek. Itt ha rossz Tipust adunk meg.
 */
public class MovieTypeDoesNotExistExcpt extends Exception {

	public MovieTypeDoesNotExistExcpt(String mess) {
		System.out.println(mess);
	}
}
