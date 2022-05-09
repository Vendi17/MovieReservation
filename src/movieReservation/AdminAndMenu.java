package movieReservation;

//Ebben a classban van a Menu kialakitasa az Admin bejelentkezessel egyutt
import java.util.ArrayList;
import java.util.Scanner;

public class AdminAndMenu {
	private final String felhasznaloNev = "admin";
	private final String jelszo = "Admin";

	Scanner sc = new Scanner(System.in);

	private ArrayList<Registry> felhasznalok;
	private ArrayList<Movie> termek;
	private ArrayList<FilmAdding> fajlbaOlvasottFilmek; 

	
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
		felhasznalok = new ArrayList();
		termek = new ArrayList();
		termek.add(new Movie(1));
		termek.add(new Movie(2));
		Verifying();
		System.out.println("");
		while (true) {
			Menu();
		}

	}
	/*
	 * onmagaert beszelo menu resz kialakitasara szolgalo fuggveny
	 */

	public void Menu() {
		System.out.println("Nyomd meg az 1-es gombot, hogy hozz�adj egy �j felhaszn�l�t.");
		System.out.println("Nyomd meg az 2-es gombot, hogy hozz�adj egy �j filmet.");
		System.out.println("Nyomd meg az 3-as gombot, hogy megn�zd az eddigi foglal�sokat.");
		System.out.println("Nyomd meg az 4-es gombot, hogy hozz�adj egy �j film foglal�st.");
		System.out.println("Nyomd meg az 5-�s gombot, t�r�lj egy filmet.");
		int i = sc.nextInt();
		sc.nextLine();

		if (i == 1) {
			System.out.println("Felhaszn�l� regisztr�l�sa: ");
			String nev = "";
			String telSzam = "";
			Registry felhasznalo = new Registry(nev,telSzam);
			felhasznalo.Regisztralas();
			felhasznalok.add(felhasznalo);
			System.out.println("Sikeres Hozz�ad�s!");

		} else if (i == 2) {
			System.out.println("Film hozz�ad�st v�lasztottad! ");
			Movie film = teremValasztas();
			film.AddingMovies();
		} else if (i == 3) {
			System.out.println("Foglal�sok megtekint�s�t v�lasztottad! ");
			FoglalasLista();
		} else if (i == 4) {
			System.out.println("Melyik teremben szeretn�l foglalni? ");
			Movie film = teremValasztas();
			String mappa  = System.getProperty("user.dir"); 
	        ArrayList<FilmAdding> movies = Movie.MovieList(mappa + "\\Movies.txt");
			//film.MovieList();
			//film.filmFoglalas();
		}else if(i==5) {
			torles();
		}
	}

	
	/*
	 * k�t terem k�z�tti valasztasra szolgalo fuggveny
	 */
	public Movie teremValasztas() {
		Movie m = null;
		try {
			System.out.println("V�lassz a k�t terem k�z�l. �rj 1-et, ha az els� terem vagy 2-est a m�sodik terem�rt.");
			System.out.println(termek);
			int x = sc.nextInt();
			sc.nextLine();
			switch (x) {
			case 1:
				m = termek.get(0);
				break;
			case 2:
				m = termek.get(1);
				break;
			default:
				throw new MovieDoesNotExistException("Nem l�tezik ilyen terem!");
			}
		} catch (MovieDoesNotExistException e) {
			teremValasztas();
		}
		return m;
	}

	/*
	 * A foglalasokat tudjuk megtekinteni
	 */
	public void FoglalasLista() {
		String mappa  = System.getProperty("user.dir"); 
        ArrayList<FilmAdding> movies = Movie.MovieList(mappa + "\\Movies.txt");
		System.out.println(felhasznalok);
		System.out.println(termek);
		for(FilmAdding f :movies) {
			System.out.println(f.toString());
		}
	}
	
	public void torles() {
		
	}
}
