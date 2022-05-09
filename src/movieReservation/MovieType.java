package movieReservation;

/*
 * itt a film tipusnak a konstruktor, set,get,tostring metodusai lathatoak
 */
public class MovieType {

	private String Type;

	MovieType(String type) {
		this.Type = type;
	}

	public void setType(String type) {
		this.Type = type;
	}

	public String getType() {
		return Type;
	}

	public String toString() {
		return Type;
	}
}
