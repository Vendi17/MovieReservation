package movieReservation;

//ebben az osztályban történik a jegy foglalás és a Filmeknek a részletes leírásának az OOP része

import java.util.Scanner;

public class FilmAdding {

	private Szamla szamla;

	// private JegyekEsUlesek jNum; Reszletesebb infoert kedden tudok meselni, hogy milyen atalakitasokon esett at ezen a heten, hogy vegleges formajat elerje
	private MovieType type;
	private MovieLang language;
	private MovieCritics review;
	private MovieRate rating;
	protected String MovieName;
	protected String MovieTime;
	private int price;
	private boolean foglalas;
	private int terem;

	Scanner sc = new Scanner(System.in);

	/*
	 * kicsit részletesebb konstruktor kezelés történt itt.
	 */

	public FilmAdding(String movieName, String movieTime, int price, String type, String lang, String review,
			double rating, int terem) {
		this.MovieName = movieName;
		this.MovieTime = movieTime;
		this.price = price;
		this.type = new MovieType(type);
		this.language = new MovieLang(lang);
		this.review = new MovieCritics(review);
		this.rating = new MovieRate(rating);
		this.terem = terem;

		this.foglalas = false;
		// jegyekSzama = new JegyekEsUlesek(jegyekSzama);
		// this.jNum = this.jNum;
	}
	/*
	 * itt történik a foglalás, ahol a hibakezelés is megtörtént ,tehát 5-nél több
	 * jegyet nem lehetséges vásárolni. A végén csak getter/setterek/ToString
	 * láthatóak
	 */
	/*
	 * public void Foglalas() { try { System.out.println("Elérhetõ jegyek száma: ");
	 * System.out.println(jNum.getJegy());
	 * System.out.println("Add meg mennyi jegyet szeretnél lefoglalni: "); int
	 * jegyek = sc.nextInt(); sc.nextLine(); if (jNum.Maradek(jegyek) == true) {
	 * szamla = new Szamla(); szamla.SzamlaRendezes(jegyek); } else if
	 * (jNum.Maradek(jegyek) == false && jegyek > 5) { throw new
	 * JegyArLimitExcpt("Nem tudsz 5-nél több jegyet foglalni. Próbáld újra! "); }
	 * else { throw new
	 * JegyIsNotAvailableExcpt("Nem lehet kapni több jegyet erre a filmre!"); } }
	 * catch (JegyArLimitExcpt e) { this.Foglalas(); } catch
	 * (JegyIsNotAvailableExcpt e) {
	 * 
	 * } }
	 */

	public void setMovieName(String movieName) {
		this.MovieName = movieName;
	}

	public String getMovieName() {
		return this.MovieName;
	}

	public int getPrice() {
		return this.price;
	}

	public int getTerem() {
		return this.terem;
	}

	public boolean getFoglalas() {
		return this.foglalas;
	}

	public void setFoglalas(boolean foglalt) {
		this.foglalas = foglalt;
	}

	public MovieType getType() {
		return this.type;
	}

	public MovieLang getLang() {
		return this.language;
	}

	public MovieCritics getCritics() {
		return this.review;
	}

	public MovieRate getRating() {
		return this.rating;
	}

	public String toString() {
		return (MovieName + " " + MovieTime + " " + terem);
	}
/*
 * azert tortent ennyi getter/setter irasa itt is, mivel volt hogy nem ertem el oket, az egyik fuggvenynel es igy kitudtam jatszani, ha itt is letrehoztam oket
 */
}
