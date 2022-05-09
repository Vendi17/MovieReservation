package movieReservation;

/* ugyan az mint a MovieTitle és a Typenal leirtakkal csak 
 * annyi hogy itt a pontozassal van sort-olva
 */
import java.util.Comparator;

public class SortByMovieRate implements Comparator<MovieRate> {
	public int compare(MovieRate alma1, MovieRate alma2) {
		return Double.compare(alma1.getRate(), alma2.getRate());
	}

}
