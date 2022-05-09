package movieReservation;

/*
 * Exception kezelesek. Ez esetben, ha helytelen nevet adunk meg
 */
public class NameDoesNotValidExcpt extends Exception {

	public NameDoesNotValidExcpt(String mess) {
		System.out.println(mess);
	}
}
