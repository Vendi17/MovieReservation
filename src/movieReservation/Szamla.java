package movieReservation;

/*
 * Ebben a classban megadom a jegynek az árát és megszorzom a kivant mennyiseggel
 *,ami visszaadja a vegosszeget, hogy mennyibe kerul majd a jegy/jegyek.
 */
public class Szamla {
	private int jegyAr;
	
	public Szamla() {
		this.jegyAr = 100;
	}
	
	public void SzamlaRendezes(int jegyekSzama) {
		int ossz = jegyAr * jegyekSzama;
		System.out.println("A végösszeg: "+ ossz);
	}
}
