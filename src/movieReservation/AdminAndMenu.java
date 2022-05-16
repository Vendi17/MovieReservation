package movieReservation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
//Ebben a classban van a Menu kialakitasa az Admin bejelentkezessel egyutt
import java.util.ArrayList;
import java.util.Scanner;

public class AdminAndMenu {
	private final String felhasznaloNev = "admin";
	private final String jelszo = "Admin";

	Scanner sc = new Scanner(System.in);

	private ArrayList<Registry> felhasznalok;
	// private ArrayList<Movie> termek; atalakitasok vegett nem lett szerepe
	private ArrayList<FilmAdding> fajlbaOlvasottFilmek;
	private ArrayList<FilmAdding> movies;

	/*
	 * A legelejen torteno bejelentkezesnek a visszaigazolasa hibakezelve
	 */
	public void Verifying() {
		try {
			System.out.println("Add meg az admin felhaszn�l� nevet: ");
			if (sc.nextLine().equals(felhasznaloNev)) {
				System.out.println("Add meg a jelsz�t hozz�: ");
				if (sc.nextLine().equals(jelszo)) {
					System.out.println("Sikeres bel�p�s!");
				} else {
					sc.nextLine();
					throw new AdminVerifyFailedExcpt("Helytelen jelsz�");
				}
			} else {
				throw new AdminVerifyFailedExcpt("Helytelen felhaszn�l� n�v");
			}
		} catch (AdminVerifyFailedExcpt e) {
			Verifying();
		}
	}

	/*
	 * A mainben talalhato program elinditasara szolgalo fuggveny
	 */
	public void start() {
		String mappa = System.getProperty("user.dir");
		movies = Movie.MovieList(mappa + "\\Movies.txt");
		felhasznalok = new ArrayList();
		/*
		 * termek = new ArrayList(); termek.add(new Movie(1)); termek.add(new Movie(2));
		 */
		Verifying();
		System.out.println("");

		while (true) {
			Menu();
		}

	}
	/*
	 * Menu letrehozasa tortent, ahol a kulonfele meghivasok tortentek, ez is vegul
	 * a potleadasig megvaltozott bovitve lett es legegyszerusitve.
	 */

	public void Menu() {
		System.out.println("Nyomd meg az 1-es gombot, hogy hozz�adj egy �j felhaszn�l�t.");
		System.out.println("Nyomd meg az 2-es gombot, hogy hozz�adj egy �j filmet.");
		System.out.println("Nyomd meg az 3-as gombot, hogy megn�zd az eddigi foglal�sokat.");
		System.out.println("Nyomd meg az 4-es gombot, hogy hozz�adj egy �j film foglal�st.");
		System.out.println("Nyomd meg az 5-�s gombot, t�r�lj egy filmet.");
		System.out.println("Nyomd meg az 6-os gombot, export�lj a foglal�saidat.");
		int i = sc.nextInt();
		sc.nextLine();

		if (i == 1) {
			System.out.println("Felhaszn�l� regisztr�l�sa: ");
			String nev = "";
			String telSzam = "";
			Registry felhasznalo = new Registry(nev, telSzam);
			felhasznalo.Regisztralas();
			felhasznalok.add(felhasznalo);
			System.out.println("Sikeres Hozz�ad�s!");

		} else if (i == 2) {
			System.out.println("Film hozz�ad�st v�lasztottad! ");
			Movie.AddingMovies(movies);
		} else if (i == 3) {
			System.out.println("Foglal�sok megtekint�s�t v�lasztottad! ");
			FoglalasLista(movies);
		} else if (i == 4) {
			System.out.println("Melyik teremben szeretn�l foglalni? ");
			teremValasztas(movies);
		} else if (i == 5) {
			torles(movies);
		} else if (i == 6) {
			export(movies);
		}
	}

	/*
	 * k�t terem k�z�tti valasztasra szolgalo fuggveny. Ezzel volt a legtobb ido
	 * atirni, hogy megfelelo legyen. Static-ok azert voltak fontosak ,mivel igy
	 * atlehetett irni, igenyesen es nem csak copy,paste verzioban kellett 50+
	 * sorral megoldani a terem valasztast es hozza befuzni a listat, amit ide oda
	 * dobal egymas kozott
	 */
	public static void teremFoglalas(int teremSzam, ArrayList<FilmAdding> movies) {
		Scanner input = new Scanner(System.in);
		boolean sikeresFoglalas = false;

		System.out.println("El�rhet� filmek a(z)" + teremSzam + "-es teremben:");
		for (FilmAdding f : movies) {
			if (f.getTerem() == teremSzam) {
				System.out.println("\t" + f.toString());
			}
		}

		System.out.println("\nFoglalni k�v�nt film c�me:");
		String cim = input.nextLine();

		for (FilmAdding f : movies) {
			if (f.getTerem() == teremSzam) {
				// System.out.println(f.MovieName + "\n" + cim);

				if (f.MovieName.equals(cim)) {
					f.setFoglalas(true);
					System.out.println("Sikeres foglal�s");
					sikeresFoglalas = true;
					break;
				}
			}
		}

		if (!sikeresFoglalas) {
			System.out.println("Helytelen c�m, k�rlek pr�b�ld �jra");
			teremValasztas(movies);
		}
	}
	// SwitchCase modra megoldott terem valsztas, amihez nagyon szoros kapcsolat
	// szolgalja a teremfoglalas fuggveny. Hibakezelve is vannak a fuggvenyek nagy
	// resze

	public static void teremValasztas(ArrayList<FilmAdding> movies) {
		Scanner sc = new Scanner(System.in);
		// ArrayList<Movie> termek = new ArrayList();
		try {
			System.out.println("V�lassz a k�t terem k�z�l. �rj 1-et, ha az els� terem vagy 2-est a m�sodik terem�rt.");
			System.out.println("\tTerem 1\n\tTerem 2");
			int x = sc.nextInt();
			sc.nextLine();
			switch (x) {
			case 1:
				teremFoglalas(1, movies);
				break;
			case 2:
				teremFoglalas(2, movies);
				break;
			default:
				throw new MovieDoesNotExistException("Nem l�tezik ilyen terem!");
			}
		} catch (MovieDoesNotExistException e) {
			teremValasztas(movies);
		}
	}

	/*
	 * A foglalasokat tudjuk megtekinteni. Reszletesebb infot kedd-en bemutataskor
	 * tudok mondani hogy miert getFoglalassal lett megoldva es miert nem sima
	 * f.foglalassal
	 */
	public void FoglalasLista(ArrayList<FilmAdding> movies) {

		// System.out.println(felhasznalok);
		System.out.println("Foglal�said:");
		for (FilmAdding f : movies) {
			if (f.getFoglalas() == true) {
				System.out.println("\t" + f.toString());
			}
		}
	}

	public void torles(ArrayList<FilmAdding> movies) {
		Scanner input = new Scanner(System.in);
		boolean sikeresTorles = false;

		System.out.println("\nEl�rhet� filmek:");
		for (FilmAdding f : movies) {
			System.out.println("\t" + f.toString());
		}

		System.out.println("\nT�r�lni k�v�nt film c�me:");
		String cim = input.nextLine();

		for (FilmAdding f : movies) {
			if (f.MovieName.equals(cim)) {
				movies.remove(f);
				System.out.println("Sikeresen t�r�lve");
				sikeresTorles = true;
				break;
			}
		}

		if (!sikeresTorles) {
			System.out.println("Helytelen c�m, k�rlek pr�b�ld �jra");
			torles(movies);
		}
	}
	
	//itt tortenik meg a fajlbairas mivel az eddigi foglalasainkat itt tudjuk ki exportalni, aminek csak annyi a dolga, hogy egy fajlnevet kell megadni

	public void export(ArrayList<FilmAdding> movies) {
		Scanner bekero = new Scanner(System.in);
		System.out.println("Add meg a f�jl nev�t: ");
		String fajlNev = bekero.nextLine();

		String mappa = System.getProperty("user.dir");
		String veglegesnev = fajlNev + ".txt";
		BufferedWriter iro = null;

		try {
			File fajl = new File(veglegesnev);

			if (!fajl.exists()) {
				fajl.createNewFile();

				FileWriter fajlbaIro = new FileWriter(fajl);
				iro = new BufferedWriter(fajlbaIro);

				for (FilmAdding f : movies) {
					if (f.getFoglalas() == true) {
						iro.write(f.MovieName + ";" + f.MovieTime + ";" + f.getPrice() + ";" + f.getType() + ";"
								+ f.getLang() + ";" + f.getCritics() + ";" + f.getRating() + ";" + f.getTerem() + "\n");
					}
				}

				System.out.println("Sikeresen export�lva");
				iro.close();

			} else {
				System.out.println("Ilyen n�vvel m�r l�teznek foglal�sok, pr�b�ld �jra!");
				export(movies);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
