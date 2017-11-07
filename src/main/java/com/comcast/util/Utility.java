package com.comcast.util;

import com.comcast.video.movie.MediaType;
import com.comcast.video.movie.Rating;

public class Utility {

	public static MediaType getMediaType(String mtype) {
		MediaType mediaType;

		switch (mtype.toUpperCase().trim()) {
		case "VHS":
			mediaType = MediaType.VHS;
			break;
		case "LAZERDISK":
			mediaType = MediaType.LAZERDISK;
			break;
		case "DVD":
			mediaType = MediaType.DVD;
			break;
		case "VCD":
			mediaType = MediaType.VCD;
			break;
		case "HD-DVD":
			mediaType = MediaType.HD_DVD;
			break;
		case "BLURAY":
			mediaType = MediaType.BLURAY;
			break;
		default:
			mediaType = MediaType.NONE;
			break;
		}

		return mediaType;
	}

	public static Rating getRating(String r) {
		Rating rating;

		switch (r.toUpperCase()) {
		case "G":
			rating = Rating.G;
			break;
		case "PG":
			rating = Rating.PG;
			break;
		case "PG-13":
			rating = Rating.PG_13;
			break;
		case "R":
			rating = Rating.R;
			break;
		case "NC-17":
			rating = Rating.NC_17;
			break;
		case "NR":
			rating = Rating.NR;
			break;
		default:
			rating = Rating.UNRATED;
			break;
		}

		return rating;
	}

}
