package movieReservation;

/*
 * Exception kezelesek. Ez esetben a telefonszamhoz
 */
public class PhoneNumDoesNotValidExcpt extends Exception {

	public PhoneNumDoesNotValidExcpt(String mess) {
		System.out.println(mess);
	}
}
