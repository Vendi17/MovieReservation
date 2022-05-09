package movieReservation;

import static org.junit.Assert.*;

import org.junit.Test;

public class MovieLangTest {

	@Test
	public void getLangTest() {
		MovieLang ujNyelv = new MovieLang("Magyar");
		String exp = "Magyar";
		assertEquals(exp, ujNyelv.getLang());
		
	}
	
	@Test
	public void toStringTest() {
		String exp ="English";
		MovieLang ujNyelv = new MovieLang("English");
		assertEquals(exp, ujNyelv.toString());
	}
	
	

}
