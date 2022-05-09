package movieReservation;
/*
 * Konstruktor/set/get/toString lathato a film véleményezés végett.
 */
public class MovieCritics {

	static String review;

	MovieCritics(String rv) {
		this.review = rv;
	}

	public String setReview(String rv) {
		this.review = rv;
		return review; //Utolag teszteles vegett lett atirva Stringre es kulon sorba irva returnolve.
	}

	public String getReview() {
		return this.review;
	}

	public String toString() {
		return review;
	}
}
