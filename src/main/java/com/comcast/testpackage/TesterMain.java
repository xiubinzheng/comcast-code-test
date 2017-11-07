package com.comcast.testpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.comcast.video.media.MediaException;
import com.comcast.video.media.MediaManagerImpl;
import com.comcast.video.media.Operator;
import com.comcast.video.movie.Field;
import com.comcast.video.movie.MediaType;
import com.comcast.video.movie.Movie;
import com.comcast.video.movie.MovieImpl;
import com.comcast.video.movie.Rating;

public class TesterMain {
	public static void main(String[] args) {

		InputStream input;
		try {
			input = new FileInputStream(
					"/Users/xzheng/Desktop/temp/movie-collection/src/main/java/com/comcast/testpackage/data.txt");
			MediaManagerImpl managerImpl = new MediaManagerImpl();

			MovieImpl RockyII = new MovieImpl("Rocky II", "Underdog boxer 2", new String[] { "Slyster", "Mickey" },
					(short) 1978, Rating.R, MediaType.VHS);
			MovieImpl RockyIII = new MovieImpl("Rocky III", "Micky dies", new String[] { "Slyster", "Mickey deadman" },
					(short) 1980, Rating.R, MediaType.VHS);
			MovieImpl TheGoonies = new MovieImpl("The Goonies", "Kids hunting for treasure",
					new String[] { "Sean", "Cory" }, (short) 1985, Rating.PG, MediaType.VHS);
			MovieImpl ForrestGump = new MovieImpl("Forrest Gump", "The life of Forrest Gump",
					new String[] { "Tom Hanks", "Jenny", "Sally Field" }, (short) 1994, Rating.PG_13, MediaType.DVD);
			MovieImpl AmericanPsycho = new MovieImpl("American Psycho", "Hey Paul",
					new String[] { "Christian Bale", "The Joker", "Marcus Halberstram", "I am Batman" }, (short) 2000,
					Rating.R, MediaType.DVD);

			List<Movie> myMovieList = new ArrayList<Movie>(Arrays.asList(TheGoonies, ForrestGump, AmericanPsycho));
			managerImpl.addMovies(myMovieList);

			
			managerImpl.addMovies(RockyII, RockyIII);
			managerImpl.addMovies(input);

			System.out.println("size: " + managerImpl.searchMovies("Rock").size());

			for (Movie m : managerImpl.searchMovies("Rock")) {
				System.out.println("mm: " + m.toString());
			}

			for (Movie m : managerImpl.getMovies()) {
				System.out.println("Movie: " + m.toString());
			}

			System.out.println("-----------------");
			managerImpl.sortMovies(Field.TITLE, false);

			for (Movie m : managerImpl.getMovies()) {
				System.out.println("Movie: " + m.toString());
			}

			List<Movie> filteredMovie = managerImpl.filterMovies(Field.YEAR, Operator.EQUALS, "ninja");
			List<Movie> filteredMovie2 = managerImpl.filterMovies(Field.YEAR, Operator.LESS_THAN, "1999");
			List<Movie> filteredMovie3 = managerImpl.filterMovies(Field.YEAR, Operator.GREATER_THAN, "1980");
			List<Movie> filteredMovie4 = managerImpl.filterMovies(Field.YEAR, Operator.CONTAINS, "1976");
			List<Movie> filteredMovie5 = managerImpl.filterMovies(Field.TITLE, Operator.EQUALS, "Rocky");
			List<Movie> filteredMovie6 = managerImpl.filterMovies(Field.TITLE, Operator.LESS_THAN, "Rock");
			//List<Movie> filteredMovie7 = managerImpl.filterMovies(Field.YEAR, Operator.GREATER_THAN, "Rock");
			List<Movie> filteredMovie8 = managerImpl.filterMovies(Field.DESCRIPTION, Operator.CONTAINS, "kids");
			List<Movie> filteredMovie9 = managerImpl.filterMovies(Field.DESCRIPTION, Operator.EQUALS, "Micky dies");
			List<Movie> filteredMovie10 = managerImpl.filterMovies(Field.YEAR, Operator.LESS_THAN, "1999");
			List<Movie> filteredMovie11 = managerImpl.filterMovies(Field.YEAR, Operator.GREATER_THAN, "1980");
			List<Movie> filteredMovie12 = managerImpl.filterMovies(Field.YEAR, Operator.CONTAINS, "1976");

			System.out.println("filterMovie start-----------------");
			for (Movie m : filteredMovie) {

				System.out.println("filterMovie: "+m.toString());
			}
			System.out.println("filterMovie end-----------------");
			
			File f = new File("/Users/xzheng/Desktop/temp/movie-collection/src/main/java/com/comcast/testpackage/data2.txt");
			
			managerImpl.addMovies(f);
			System.out.println("-----------------");
			for (Movie m : managerImpl.getMovies()) {

				System.out.println(m.toString());
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MediaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
