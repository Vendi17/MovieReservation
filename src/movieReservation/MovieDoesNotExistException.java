package movieReservation;

//Ugyanugy Hibakezel�s 
public class MovieDoesNotExistException extends Exception {

	public MovieDoesNotExistException(String mess) {
		System.out.println(mess);
	}
}
