package movieReservation;
/*
 * Itt tal�lhat� a jegyek sz�ma �s az �l�sek sz�ma majd a konstruktor,setter/getter is
 * a vegen tal�lhat� egy boolean maradek,ami ertelemszeruen azt a celt szolgalja
 * ,hogy a mgetortent vasarlas utan mennyi jegy maradt hatra
 * es hogy 5-nel tobb jegyet ne lehessen venni
 */
public class JegyekEsUlesek {
	private int jNumber; // jegyek sz�ma

	public JegyekEsUlesek(int jNum) {
		this.jNumber = jNum;
	}

	public void setJegy(int jNum) {
		this.jNumber = jNum;
	}

	public int getJegy() {
		return this.jNumber;
	}

	public boolean Maradek(int x) {
		if (x > 5 || x > jNumber) {
			return false;
		} else {
			jNumber -= x;
			System.out.println("Foglal�s ut�n ennyi jegy el�rhet� m�g! " + jNumber);
			return true;
		}
	}
}