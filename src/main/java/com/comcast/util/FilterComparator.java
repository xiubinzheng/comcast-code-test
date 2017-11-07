package com.comcast.util;

import java.util.Comparator;

import com.comcast.video.media.Operator;
import com.comcast.video.movie.Field;
import com.comcast.video.movie.Movie;

public class FilterComparator implements Comparator<Movie> {
	private Field field;
	private Operator op;

	public FilterComparator(Field field,Operator op) {
		this.field = field;
		this.op = op;
	}

	@Override
	public int compare(Movie o1, Movie o2) {
		// TODO Auto-generated method stub
	return 0;
	}

}
