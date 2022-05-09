package movieReservation;
/*
 * Eredetileg tervben lett volna 3D és 4D-s filmek létrejötte
 * ,de ezáltal sort-olva lettek csak a 2D-s filmek, tehát csak konstruktor,super es egy toString lathato.
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
