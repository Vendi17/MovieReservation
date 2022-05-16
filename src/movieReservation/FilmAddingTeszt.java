package movieReservation;

import static org.junit.Assert.*;

import org.junit.Test;

public class FilmAddingTeszt {

	@Test
	public void getTeremTeszt() {
		FilmAdding ujTerem = new FilmAdding(null, null, 0, null, null, null, 0, 1);
		int exp = 1;
		assertEquals(exp, ujTerem.getTerem());
	}

}
