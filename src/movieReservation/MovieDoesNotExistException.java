package movieReservation;

//Ugyanugy HibakezelÚs 
public class MovieDoesNotExistException extends Exception {

	public MovieDoesNotExistException(String mess) {
		System.out.println(mess);
	}
}
