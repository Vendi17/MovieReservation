package movieReservation;

import static org.junit.Assert.*;

import org.junit.Test;

public class MovieTypeTest {

	@Test
	public void getTypeTest() {
		MovieType ujType = new MovieType("Drama");
		String exp = "Drama";
		assertEquals(exp, ujType.getType());
		
	}
	
	@Test
	public void toStringTest() {
		String exp ="Horror";
		MovieType ujType = new MovieType("Horror");
		assertEquals(exp, ujType.toString());
	}
}
