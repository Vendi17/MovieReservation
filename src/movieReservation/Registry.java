package movieReservation;

import java.util.Scanner;

//itt vannak deklar�lva a regisztr�ci�s dolgok

/*
 * itt tal�lhat� a nev es a telefonszam konstruktora is
 */
public class Registry {
	Scanner sc = new Scanner(System.in);
	private String Nev;
	private String telefonSzam;
	// private String email;
	// private Address addr;

	public Registry(String Nev, String telSzam) {
		this.Nev = Nev;
		this.telefonSzam = telSzam;
	}
	/*
	 * Itt t�rt�nik meg a bek�rdez�s, ami hiba kezelve van ABC sorrendben vagy szam
	 * sorrendben ugye a telefonnal.
	 * VIGYAZAT,HA VALAMELYIKET ELIROD A HIBAKEZELESNEL UJRA A BECENEVET KERDEZI!
	 */

	public void Regisztralas() {
		try {
			System.out.println("Add meg a beceneved (Teljes n�v nem elfogadhat�!): ");

			String Nev = sc.nextLine();

			if (this.Alpha(Nev) == true) {
				setNev(Nev);
			} else {
				throw new NameDoesNotValidExcpt("Sz�mokat tartalmaz a neved, teh�t rossz! pr�b�ld �jra: ");
			}

			System.out.println("Add meg a telefon sz�modat: ");

			String telSzam = sc.nextLine();

			if (this.Num(telSzam) == true) {
				setTelSzam(telSzam);
			} else {
				throw new PhoneNumDoesNotValidExcpt("A telefonsz�m csak sz�mokb�l �lljon! pr�b�ld �jra. ");
			}
		} catch (PhoneNumDoesNotValidExcpt e) {
			Regisztralas();
		} catch (NameDoesNotValidExcpt e) {
			Regisztralas();
		}
	}

	/*
	 * lejebb csak Setterek/Getterek �s a hibakezeleshez tartozo kriteriumok
	 * lathatoak
	 */

	public void setNev(String Nev) {
		this.Nev = Nev;
	}

	public String getNev() {
		return this.Nev;
	}

	public void setTelSzam(String telSzam) {
		this.telefonSzam = telSzam;
	}

	public String getTelSzam() {
		return this.telefonSzam;
	}

	public boolean Alpha(String Nev) {
		return Nev.matches("[a-zA-Z]+");
	}

	public boolean Num(String Numeric) {
		return Numeric.matches("[-+]?d*\\.?\\d+");
	}

}
