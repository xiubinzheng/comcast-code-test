package com.comcast.util;

import java.util.Comparator;

import com.comcast.video.movie.Field;
import com.comcast.video.movie.Movie;

public class MovieComparator implements Comparator<Movie> {
	private Field field;

	public MovieComparator(Field field) {
		this.field = field;
	}

	@Override
	public int compare(Movie o1, Movie o2) {
		// TODO Auto-generated method stub
		System.out.println("this one is called MovieImpl otherMovie,Field field");
		switch (field) {
		case TITLE:
			return o1.getTitle().compareTo(o2.getTitle());

		case DESCRIPTION:
			return o1.getDescription().compareTo(o2.getDescription());

		case YEAR:
			return String.valueOf(o1.getYear()).compareTo(String.valueOf(o2.getYear()));

		case RATING:
			return o1.getRating().toString().compareTo(o2.getRating().toString());

		case MEDIA:
			return o1.getMedia().toString().compareTo(o2.getMedia().toString());
		default:
			return 0;
		}
	}
}
