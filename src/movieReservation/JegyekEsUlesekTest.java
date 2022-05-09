package movieReservation;

import static org.junit.Assert.*;

import org.junit.Test;

public class JegyekEsUlesekTest {

	@Test
	public void getJegyTest() {
		JegyekEsUlesek ujJegy = new JegyekEsUlesek(75);
		int exp = 75;
		assertEquals(exp, ujJegy.getJegy());
	}
}
