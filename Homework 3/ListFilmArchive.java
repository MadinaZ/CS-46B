package movies;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class ListFilmArchive extends ArrayList<Movie> implements FilmArchive {

	public boolean add(Movie x) {
		for (int i = 0; i < this.size(); i++) {
			if (this.get(i).equals(x)) {
				return false;
			}
		}
		super.add(x);
		return true;
	}

	public ArrayList<Movie> getSorted() {
		Set<Movie> treeSort = new TreeSet<Movie>(this); // ArrayList to TreeSet
		ArrayList<Movie> sortedList = new ArrayList<Movie>(treeSort); // TreeSet
																		// to
																		// sorted
																		// ArrayList
		return sortedList;
	}

	public static void main(String[] args) {
		ListFilmArchive archive = new ListFilmArchive();
		for (Movie m : Movie.getTestMovies())
			archive.add(m);
		for (Movie m : archive)
			System.out.println(m);
		System.out.println("**************");
		for (Movie m : archive.getSorted())
			System.out.println(m);
	}
}
