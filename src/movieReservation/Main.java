package movieReservation;

//Ez itt a Main class, ahol csak a program elinditasara szolgal.

public class Main {

	public static void main(String[] args) throws AdminVerifyFailedExcpt {
		AdminAndMenu inditas = new AdminAndMenu();
		inditas.start();
	}

}
