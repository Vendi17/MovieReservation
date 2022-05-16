package movieReservation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//Ebben a classban t�rt�nik a foglal�s �s a mozi film hozz�ad�sa
import java.util.ArrayList;
import java.util.Scanner;

public class Movie {
	private int Num;
	private ArrayList<FilmAdding> filmek = new ArrayList();

	public Movie(int i) {
		Num = i;
	}
	/*
	 * itt t�rt�nik meg a filmnek a hozz�ad�sa.
	 */

	public static void AddingMovies(ArrayList<FilmAdding> movies) {
		Scanner sc = new Scanner(System.in);
		try {
			Movie2DVersion x = null;
			System.out.println("Adj meg egy film nev�t: ");
			String movieName = sc.nextLine();

			System.out.println("Add meg az id�pontot: ");
			String movieTime = sc.nextLine();

			System.out.println("Add meg a film �r�t: ");
			int price = sc.nextInt();
			sc.nextLine();

			System.out.println("Add meg a film T�pus�t(Dr�ma,Akci� stb): ");
			String type = sc.nextLine();

			System.out.println("Add meg a milyen nyelven van a filmszinkron: ");
			String lang = sc.nextLine();

			System.out.println("Add meg a film Kritik�j�t: ");
			String review = sc.nextLine();

			System.out.println("Add meg a film �rt�kel�s�t (10/?): ");
			Double rating = sc.nextDouble();
			sc.nextLine();

			System.out.println("Melyik teremben legyen el�rhet�?");
			int terem = sc.nextInt();
			sc.nextLine();

			x = new Movie2DVersion(movieName, movieTime, price, type, lang, review, rating, terem);
			movies.add(x);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * Itt l�that� a f�jlba olvasas
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
