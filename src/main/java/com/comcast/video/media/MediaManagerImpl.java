package com.comcast.video.media;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.comcast.util.Utility;
import com.comcast.video.movie.Field;
import com.comcast.video.movie.Movie;
import com.comcast.video.movie.MovieImpl;

/**
 * A <i>MediaManager</i> is responsible for maintaining and querying a
 * collection of movies.
 *
 * <p>
 * When implementing a MediaManager, pay special attention to not only write
 * bug-free code, but also strive to maintain a good balance between
 * maintainability, robustness, and performance.
 * </p>
 *
 */
public class MediaManagerImpl implements MediaManager {

	private List<Movie> movieList = new ArrayList<Movie>();

	/**
	 * Add a movie (or multiple movies) to the internal database.
	 *
	 * @param movies
	 *            the movie(s) to add
	 */

	public void addMovies(Movie... movies) {
		// TODO Auto-generated method stub
		for (int i = 0; i < movies.length; i++) {
			// movieList.add(movies[i]);
			movieList.add(movies[i]);
		}
	}

	/**
	 * Add a list of movies to the internal database.
	 *
	 * @param movies
	 *            the movies to add
	 */
	public void addMovies(List<Movie> movies) {
		// TODO Auto-generated method stub
		// movieList.addAll(movies);
		movieList.addAll(movies);
	}

	/**
	 * Parse the <code>file</code> adding each movie to the internal database.
	 * The format is described in {@link MediaManager#addMovies(InputStream)}
	 *
	 * @param file
	 *            the file to read from
	 *
	 * @throws MediaException
	 *             if there was any problem reading or parsing the given file
	 */
	public void addMovies(File file) throws MediaException {
		// TODO Auto-generated method stub

	}

	/**
	 * Parse the <code>file</code> adding each movie to the internal database.
	 * The requirements for the format are as follows:
	 *
	 * <pre>
	 *   1. The list of assets SHALL only contain base ASCII characters
	 *   2. Each asset SHALL be separated by a single newline
	 *   3. Each field within an asset shall be separated by a single pipe "|" character
	 *   4. The fields of a movie will appear in the following order:
	 *      1) Title
	 *      2) Description
	 *      3) Actors (comma delimited list)
	 *      4) Year
	 *      5) Rating
	 *      6) Media
	 * </pre>
	 *
	 * <p>
	 * In addition each of the special characters may be escaped and used as
	 * part of the field instead of a delimiter if it is immediately preceded
	 * with a forward slash (<code>\</code>). For example, explicit newlines
	 * within a movie's description will appear as the string <code>
	 * "\n"</code> and the movie entitled
	 * <code>"Escape | A Made Up Movie"</code> would appear as
	 * <code>"Escape \| A Made Up Movie"</code>.
	 * </p>
	 *
	 * <p>
	 * An example input file is below (remember the pre tags and the asterisks
	 * are just HTML and javadoc markup).
	 * </p>
	 *
	 * <pre>
	 * Gone with the Wind | American classic | Clark Gable, Vivien Leigh, Thomas Mitchell | 1939 | G | VHS
	 * 
	 * Antitrust | It's about Microsoft | Ryan Phillippe, Tim Robbins, Rachael Leigh Cook | 2001 | PG-13 | DVD
	 * </pre>
	 *
	 * @param input
	 *            the input stream to read from
	 *
	 * @throws MediaException
	 *             if there was any problem reading or parsing the given stream
	 */
	public void addMovies(InputStream input) throws MediaException {
		// TODO Auto-generated method stub
		int i;
		StringBuilder sb = new StringBuilder();
		char c;
		try {
			// new input stream created
			System.out.println("Characters printed:");

			// reads till the end of the stream
			while ((i = input.read()) != -1) {

				// converts integer to character
				c = (char) i;
				sb.append(c);
				// prints character
				System.out.print(c);
			}

			String[] newline = sb.toString().split("\\r?\\n");
			for (String str : newline) {
				String[] temp = str.split("\\|");
				String title = temp[0];
				String description = temp[1];
				String[] actors = temp[2].split(",");
				String year = temp[3].trim();
				String rating = temp[4].trim();
				String mediaType = temp[5];

				System.out.println("year: " + year);
				MovieImpl movieImpl = new MovieImpl(title, description, actors, Short.parseShort(year),
						Utility.getRating(rating), Utility.getMediaType(mediaType));

				movieList.add(movieImpl);
			}

		} catch (Exception e) {

			// if any I/O error occurs
			e.printStackTrace();
		} finally {

			// releases system resources associated with this stream
			if (input != null)
				try {
					input.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	/**
	 * Get a list of movies in the internal database.
	 *
	 * @return a list of movies in the database
	 */
	public List<Movie> getMovies() {
		// TODO Auto-generated method stub
		return movieList;
	}

	/**
	 * Get a sorted list of movies from the internal database sorting on the
	 * given field.
	 *
	 * @param field
	 *            the {@link Field} to sort on
	 * @param ascending
	 *            if <code>true</code>, sort in ascending order, otherwise in
	 *            descending order
	 *
	 * @return the sorted list of movies
	 */
	public List<Movie> sortMovies(Field field, boolean ascending) {
		// TODO Auto-generated method stub
		List<Movie> result = new ArrayList<Movie>();
		Collections.sort(movieList,Collections.reverseOrder());

		return movieList;
	}

	/**
	 * Get an unsorted list of movies from the internal database that contains
	 * the entire query string given. They query string search should be case
	 * insensitive and can occur in any field of the {@link Movie}.
	 *
	 * @param query
	 *            the query string to use to conduct the search
	 *
	 * @return a unsorted list of movies that were found in the search
	 */
	public List<Movie> searchMovies(String query) {
		// TODO Auto-generated method stub

		List<Movie> result = new ArrayList<Movie>();
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).toString().contains(query)) {
				result.add(movieList.get(i));
			}
		}
		return result;
	}

	/**
	 * Returns an unsorted filtered list of movies according to the given
	 * parameters. The individual filter operators are defined in the
	 * {@link Operator} Enum.
	 *
	 * @param field
	 *            the field to filter on
	 * @param op
	 *            the operator to use while filtering
	 * @param query
	 *            the query string to use when executing the appropriate
	 *            operation
	 *
	 * @return the filtered list of movies
	 */
	public List<Movie> filterMovies(Field field, Operator op, String query) {
		// TODO Auto-generated method stub
		List<Movie> result = new ArrayList<Movie>();

		switch (field) {
		case TITLE:

			break;

		case DESCRIPTION:
			break;

		case YEAR:
			break;

		case RATING:
			break;

		case MEDIA:
			break;

		}

		return null;

	}

}
