package movieReservation;

//Ez itt a Main class, ahol csak a program elinditasara szolgal, hibakezelve

public class Main {

	public static void main(String[] args) throws AdminVerifyFailedExcpt {
		AdminAndMenu alma = new AdminAndMenu();
		alma.start();
	}

}
