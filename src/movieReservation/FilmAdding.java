package movieReservation;

//ebben az oszt�lyban t�rt�nik a jegy foglal�s �s a Filmeknek a r�szletes le�r�s�nak az OOP r�sze

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
	 * kicsit r�szletesebb konstruktor kezel�s t�rt�nt itt.
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
	 * itt t�rt�nik a foglal�s, ahol a hibakezel�s is megt�rt�nt
	 * ,teh�t 5-n�l t�bb jegyet nem lehets�ges v�s�rolni.
	 * A v�g�n csak getter/setterek/ToString l�that�ak
	 */

	public void Foglalas() {
		try {
			System.out.println("El�rhet� jegyek sz�ma: ");
			System.out.println(jNum.getJegy());
			System.out.println("Add meg mennyi jegyet szeretn�l lefoglalni: ");
			int jegyek = sc.nextInt();
			sc.nextLine();
			if (jNum.Maradek(jegyek) == true) {
				szamla = new Szamla();
				szamla.SzamlaRendezes(jegyek);
			} else if (jNum.Maradek(jegyek) == false && jegyek > 5) {
				throw new JegyArLimitExcpt("Nem tudsz 5-n�l t�bb jegyet foglalni. Pr�b�ld �jra! ");
			} else {
				throw new JegyIsNotAvailableExcpt("Nem lehet kapni t�bb jegyet erre a filmre!");
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
