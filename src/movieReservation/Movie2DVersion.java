package movieReservation;
/*
 * Eredetileg tervben lett volna 3D �s 4D-s filmek l�trej�tte
 * ,de ez�ltal sort-olva lettek csak a 2D-s filmek, teh�t csak konstruktor,super es egy toString lathato.
 */
public class Movie2DVersion extends FilmAdding {

	public Movie2DVersion(String movieName, String movieTime, int price, String type, String lang, String review,
			double rating, int jNum) {
		super(movieName, movieTime, price, type, lang, review, rating, jNum);
	}

	public String toString() {
		return (MovieName + "" + MovieTime);
	}
}
