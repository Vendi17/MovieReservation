package movieReservation;
/*
 * Itt a nevbol adodoan comp segítségével osszehasonlitom a film tipusokat
 * ezáltal ki lesznek szurve es sortolva lesznek
 */
import java.util.Comparator;

public class SortByMovieType implements Comparator<MovieType> {

	public int compare(MovieType alma1, MovieType alma2) {
		int x = alma1.getType().compareTo(alma2.getType());
		return x;

	}

}
