package movieReservation;

/*
 * Exception kezelesek. Ez akkor jon ha mar nem kaphato jegy sem ules. Veglegesen ki lett szedve a programbol, mint a JegyekEsUlesek class.
 */
public class MovieSeatDoesNotExistOrNotAvailableExcpt extends Exception {

	public MovieSeatDoesNotExistOrNotAvailableExcpt(String mess) {
		System.out.println(mess);
	}
}
