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
			System.out.println("Add meg az admin felhasználó nevet: ");
			if (sc.nextLine().equals(felhasznaloNev)) {
				System.out.println("Add meg a jelszót hozzá: ");
				if (sc.nextLine().equals(jelszo)) {
					System.out.println("Sikeres belépés!");
				} else {
					sc.nextLine();
					throw new AdminVerifyFailedExcpt("Helytelen jelszó");
				}
			} else {
				throw new AdminVerifyFailedExcpt("Helytelen felhasználó név");
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
		System.out.println("Nyomd meg az 1-es gombot, hogy hozzáadj egy új felhasználót.");
		System.out.println("Nyomd meg az 2-es gombot, hogy hozzáadj egy új filmet.");
		System.out.println("Nyomd meg az 3-as gombot, hogy megnézd az eddigi foglalásokat.");
		System.out.println("Nyomd meg az 4-es gombot, hogy hozzáadj egy új film foglalást.");
		System.out.println("Nyomd meg az 5-ös gombot, törölj egy filmet.");
		int i = sc.nextInt();
		sc.nextLine();

		if (i == 1) {
			System.out.println("Felhasználó regisztrálása: ");
			String nev = "";
			String telSzam = "";
			Registry felhasznalo = new Registry(nev,telSzam);
			felhasznalo.Regisztralas();
			felhasznalok.add(felhasznalo);
			System.out.println("Sikeres Hozzáadás!");

		} else if (i == 2) {
			System.out.println("Film hozzáadást választottad! ");
			Movie film = teremValasztas();
			film.AddingMovies();
		} else if (i == 3) {
			System.out.println("Foglalások megtekintését választottad! ");
			FoglalasLista();
		} else if (i == 4) {
			System.out.println("Melyik teremben szeretnél foglalni? ");
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
	 * két terem közötti valasztasra szolgalo fuggveny
	 */
	public Movie teremValasztas() {
		Movie m = null;
		try {
			System.out.println("Válassz a két terem közül. írj 1-et, ha az elsõ terem vagy 2-est a második teremért.");
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
				throw new MovieDoesNotExistException("Nem létezik ilyen terem!");
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
