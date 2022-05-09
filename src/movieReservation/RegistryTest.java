package movieReservation;

import static org.junit.Assert.*;

import org.junit.Test;

public class RegistryTest {
	
	@Test
	public void getNevTest() {
		Registry ujNev = new Registry("Nev","telSzam");
		String exp = "Nev";
		assertEquals(exp, ujNev.getNev());
	}
	
	@Test
	public void getTelSzamTest() {
		Registry ujTelszam = new Registry("Nev", "Telszam");
		String exp = "Telszam";
		assertEquals(exp, ujTelszam.getTelSzam());
	}
	
}
