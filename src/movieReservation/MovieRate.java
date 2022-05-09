package movieReservation;

/*
 * A film ertekeles konstruktora,Set,Get,ToString megoldasai lathatoak
 */
public class MovieRate {

	private double rate;

	MovieRate(double rt) {
		this.rate = rt;
	}

	public void setRate(double rt) {
		this.rate = rt;
	}

	public double getRate() {
		return this.rate;
	}

	public String toString() {
		Double valami = this.rate;
		return valami.toString();
	}
}
