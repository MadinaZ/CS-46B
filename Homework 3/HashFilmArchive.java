package movies;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class HashFilmArchive extends HashSet<Movie> implements FilmArchive {

	
	public ArrayList<Movie> getSorted(){
		Set<Movie> treeSort = new TreeSet<Movie>(this); //ArrayList to HashSet
		ArrayList<Movie> sortedList = new ArrayList<Movie>(treeSort); //TreeSet to sorted ArrayList
		return sortedList;
	}
	
	public static void main(String[] args) {
		HashFilmArchive archive = new HashFilmArchive();
		for (Movie m : Movie.getTestMovies())
			archive.add(m);
		for (Movie m : archive)
			System.out.println(m);
		System.out.println("**************");
		for (Movie m : archive.getSorted())
			System.out.println(m);
	}
}
