package movies;

public class Movie implements Comparable<Movie>{

	private String title;
	private int year;
	
	public Movie(String title, int year){
		this.title = title;
		this.year = year;
	}
	
	//Compares movies first by title then by year
	public int compareTo(Movie that){
		int titleCmp = this.title.compareTo(that.title); //title comparison
		if (titleCmp != 0){
			return titleCmp;
		}
		return this.year - that.year;
	}
	
	public String getTitle(){
		return title;
	}
	
	public int getYear(){
		return year;
	}
	
	public boolean equals(Object x){
		Movie that = (Movie)x;
		return this.compareTo(that) == 0;
	}
	
	public String toString(){
		return "Movie " + title + " (" + year + ")";
	}
	
	public static Movie[] getTestMovies(){
		Movie[] testMovies = new Movie[10];
		int n = 0;
		//Same title different years
		testMovies[n++] = new Movie("The Thomas Crown Affair", 1968);
		testMovies[n++] = new Movie("The Thomas Crown Affair", 1999);
		//Different title same year
		testMovies[n++] = new Movie("The Martian", 2015);
		testMovies[n++] = new Movie("Bridge of Spies", 2015);
		//Same title same year
		testMovies[n++] = new Movie("Star Wars: Episode III - Revenge of the Sith", 2005);
		testMovies[n++] = new Movie("Star Wars: Episode III - Revenge of the Sith", 2005);
		//Random
		testMovies[n++] = new Movie("Rio Bravo", 1959);
		testMovies[n++] = new Movie("The Shootist", 1976);
		testMovies[n++] = new Movie("Shark Tale", 2004);
		testMovies[n++] = new Movie("The Dark Knight", 2008);
		return testMovies;
	}
	
	public int hashCode(){
		return title.hashCode() + year;
	}
}
