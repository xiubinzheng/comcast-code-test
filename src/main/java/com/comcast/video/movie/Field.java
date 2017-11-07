/* 
 * ===========================================================================
 * This file is the intellectual property of Comcast Corp.  It
 * may not be copied in whole or in part without the express written
 * permission of Comcast or its designees.
 * ===========================================================================
 * Copyright (c) 2017 Comcast Corp. All rights reserved.
 * ===========================================================================
 */

package com.comcast.video.movie;

import com.comcast.video.media.MediaManager;

/**
 * An enumeration for each field within a {@link Movie} that can be used by a
 * {@link MediaManager} to filter or sort.
 *
 */
public enum Field {

	/** @see Movie#getTitle() */
	TITLE,

	/** @see Movie#getDescription() */
	DESCRIPTION,

	/** @see Movie#getActors() */
	ACTORS,

	/** @see Movie#getYear() */
	YEAR,

	/** @see Movie#getRating() */
	RATING,

	/** @see Movie#getMedia() */
	MEDIA;

	Field() {
	}

}
