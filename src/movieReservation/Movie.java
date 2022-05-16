package movieReservation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//Ebben a classban történik a foglalás és a mozi film hozzáadása
import java.util.ArrayList;
import java.util.Scanner;

public class Movie {
	private int Num;
	private ArrayList<FilmAdding> filmek = new ArrayList();

	public Movie(int i) {
		Num = i;
	}
	/*
	 * itt történik meg a filmnek a hozzáadása.
	 */

	public static void AddingMovies(ArrayList<FilmAdding> movies) {
		Scanner sc = new Scanner(System.in);
		try {
			Movie2DVersion x = null;
			System.out.println("Adj meg egy film nevét: ");
			String movieName = sc.nextLine();

			System.out.println("Add meg az idõpontot: ");
			String movieTime = sc.nextLine();

			System.out.println("Add meg a film árát: ");
			int price = sc.nextInt();
			sc.nextLine();

			System.out.println("Add meg a film Típusát(Dráma,Akció stb): ");
			String type = sc.nextLine();

			System.out.println("Add meg a milyen nyelven van a filmszinkron: ");
			String lang = sc.nextLine();

			System.out.println("Add meg a film Kritikáját: ");
			String review = sc.nextLine();

			System.out.println("Add meg a film értékelését (10/?): ");
			Double rating = sc.nextDouble();
			sc.nextLine();

			System.out.println("Melyik teremben legyen elérhetõ?");
			int terem = sc.nextInt();
			sc.nextLine();

			x = new Movie2DVersion(movieName, movieTime, price, type, lang, review, rating, terem);
			movies.add(x);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * Itt látható a fájlba olvasas
	 */

	public static ArrayList<FilmAdding> MovieList(String path) {
		ArrayList<FilmAdding> valami = new ArrayList();

		String line;
		try {
			BufferedReader bfr = new BufferedReader(new FileReader(path));

			while ((line = bfr.readLine()) != null) {
				String tores[] = line.split(";");
				String movieName = tores[0];
				String movieTime = tores[1];
				int price = Integer.valueOf(tores[2]);
				String type = tores[3];
				String lang = tores[4];
				String review = tores[5];
				double rating = Double.parseDouble(tores[6]);
				int terem = Integer.valueOf(tores[7]);
				FilmAdding x = new FilmAdding(movieName, movieTime, price, type, lang, review, rating, terem);
				valami.add(x);

			}
			bfr.close();
			return valami;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return valami;
	}

	public String toString() {
		Integer x = Num;
		return "Mozi" + x.toString();
	}

}
