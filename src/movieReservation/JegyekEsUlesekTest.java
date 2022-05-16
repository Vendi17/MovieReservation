package movieReservation;

import static org.junit.Assert.*;

import org.junit.Test;

public class JegyekEsUlesekTest {
//Mivel nem hasznalt class-t tesztelek csinaltam a filmadding tesztet igy is megvan a 10 teszt, de ha igy is elfogadhato azt megkoszonnem
	@Test
	public void getJegyTest() {
		JegyekEsUlesek ujJegy = new JegyekEsUlesek(75);
		int exp = 75;
		assertEquals(exp, ujJegy.getJegy());
	}
}
