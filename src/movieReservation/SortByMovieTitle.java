package movieReservation;

/*
 * Ugyanugy mint a MovieTypenal összehasonlitom 
 * a getterekel es ezaltal sort-olom a film cimekkel.
 */
import java.util.Comparator;

public class SortByMovieTitle implements Comparator<FilmAdding> {

	public int compare(FilmAdding alma1, FilmAdding alma2) {
		int x = alma1.getMovieName().compareTo(alma2.getMovieName());
		return x;
	}

}
