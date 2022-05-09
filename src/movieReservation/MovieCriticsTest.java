package movieReservation;

import static org.junit.Assert.*;
import movieReservation.MovieCritics;
import org.junit.Before;

import org.junit.Test;

public class MovieCriticsTest {
	
	@Test
	public void toStringTest() {
		String exp ="Jo";
		MovieCritics ujValami = new MovieCritics("Jo");
		assertEquals(exp, ujValami.toString());
	}
	
	@Test
	public void getReviewTest() {
		MovieCritics ujValami = new MovieCritics("kozepes");
		String exp = "kozepes";
		assertEquals(exp, ujValami.getReview());
	}
	
	@Test
	public void setReviewTest() {
		MovieCritics ujValami = new MovieCritics("nagyon jo");
		ujValami.setReview("gyenge");
		MovieCritics exp =  new MovieCritics("gyenge");
		assertEquals(exp.getReview(),ujValami.getReview());
		
	}
	
}
