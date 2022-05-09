package movieReservation;
/*
 * Itt található a jegyek száma és az ülések száma majd a konstruktor,setter/getter is
 * a vegen található egy boolean maradek,ami ertelemszeruen azt a celt szolgalja
 * ,hogy a mgetortent vasarlas utan mennyi jegy maradt hatra
 * es hogy 5-nel tobb jegyet ne lehessen venni
 */
public class JegyekEsUlesek {
	private int jNumber; // jegyek száma

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
			System.out.println("Foglalás után ennyi jegy elérhetõ még! " + jNumber);
			return true;
		}
	}
}