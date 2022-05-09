package movieReservation;

/*
 * Exception kezelesek, ha tele lenne a mozi
 */
public class MovieIsFullExcpt extends Exception {

	public MovieIsFullExcpt(String mess) {
		System.out.println(mess);
	}
}
