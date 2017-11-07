package com.comcast.video.movie;

import java.util.Arrays;

public class MovieImpl implements Movie {
	private String title;
	private String description;
	private String[] actors;
	private short year;
	private Rating rating;
	private MediaType mediaType;

	public MovieImpl() {
	}

	public MovieImpl(String title, String description, String[] actors, short year, Rating rating,
			MediaType mediaType) {
		super();
		this.title = title;
		this.description = description;
		this.actors = actors;
		this.year = year;
		this.rating = rating;
		this.mediaType = mediaType;
	}

	public String getTitle() {
		// TODO Auto-generated method stub
		return title;
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}

	public String[] getActors() {
		// TODO Auto-generated method stub
		return actors;
	}

	public short getYear() {
		// TODO Auto-generated method stub
		return year;
	}

	public Rating getRating() {
		// TODO Auto-generated method stub
		return rating;
	}

	public MediaType getMedia() {
		// TODO Auto-generated method stub
		return mediaType;
	}

	public Object getField(Field field) {
		// TODO Auto-generated method stub
		return field;
	}

	@Override
	public String toString() {
			return this.title+" | "+this.description+
					" | "+Arrays.toString(this.actors)+
					" | "+this.year+" | "
					+this.rating+" | "+this.mediaType;
	}

}
