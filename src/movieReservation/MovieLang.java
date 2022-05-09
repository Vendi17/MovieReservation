package movieReservation;

/*
 * Itt is csak a film nyelvenek/szinkronanak konstruktora/get/set/toString-e lathato.
 */
public class MovieLang {

	private String language;

	MovieLang(String lang) {
		this.language = lang;
	}

	public void setLang(String lang) {
		this.language = lang;
	}

	public String getLang() {
		return language;
	}

	public String toString() {
		return language;
	}
}
