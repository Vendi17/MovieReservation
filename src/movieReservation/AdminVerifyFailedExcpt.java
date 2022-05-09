package movieReservation;

//A program elinditasakor van egy admin bejelentkezes
//es ahhoz szolgal ez a hiba kezeles, ha failed Exception lenne
public class AdminVerifyFailedExcpt extends Exception {

	public AdminVerifyFailedExcpt(String mess) {
		System.out.println(mess);
	}

}
