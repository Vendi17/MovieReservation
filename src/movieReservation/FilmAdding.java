package movieReservation;

//ebben az osztályban történik a jegy foglalás és a Filmeknek a részletes leírásának az OOP része

import java.util.Scanner;

public class FilmAdding {

	private Szamla szamla;

	private JegyekEsUlesek jNum;
	private MovieType type;
	private MovieLang language;
	private MovieCritics review;
	private MovieRate rating;
	protected String MovieName;
	protected String MovieTime;
	private int price;

	Scanner sc = new Scanner(System.in);
	
	/*
	 * kicsit részletesebb konstruktor kezelés történt itt.
	 */

	public FilmAdding(String movieName, String movieTime, int price, String type, String lang, String review,
			double rating, int jNum) {
		this.MovieName = movieName;
		this.MovieTime = movieTime;
		this.type = new MovieType(type);
		this.review = new MovieCritics(review);
		this.language = new MovieLang(lang);
		this.rating = new MovieRate(rating);
		this.jNum = this.jNum;//Benivel folytkov
		this.price = price;
	}
	/*
	 * itt történik a foglalás, ahol a hibakezelés is megtörtént
	 * ,tehát 5-nél több jegyet nem lehetséges vásárolni.
	 * A végén csak getter/setterek/ToString láthatóak
	 */

	public void Foglalas() {
		try {
			System.out.println("Elérhetõ jegyek száma: ");
			System.out.println(jNum.getJegy());
			System.out.println("Add meg mennyi jegyet szeretnél lefoglalni: ");
			int jegyek = sc.nextInt();
			sc.nextLine();
			if (jNum.Maradek(jegyek) == true) {
				szamla = new Szamla();
				szamla.SzamlaRendezes(jegyek);
			} else if (jNum.Maradek(jegyek) == false && jegyek > 5) {
				throw new JegyArLimitExcpt("Nem tudsz 5-nél több jegyet foglalni. Próbáld újra! ");
			} else {
				throw new JegyIsNotAvailableExcpt("Nem lehet kapni több jegyet erre a filmre!");
			}
		} catch (JegyArLimitExcpt e) {
			this.Foglalas();
		} catch (JegyIsNotAvailableExcpt e) {

		}
	}

	public void setMovieName(String movieName) {
		this.MovieName = movieName;
	}

	public String getMovieName() {
		return this.MovieName;
	}

	public int getPrice() {
		return this.price;
	}

	public String toString() {
		return (MovieName + "" + MovieTime + jNum);
	}

}
