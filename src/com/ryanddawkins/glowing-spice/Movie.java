package com.ryanddawkins.glowing_spice;

import java.lang.StringBuilder;

/**
 * Movie class created to manage data about movies
 *
 * @author Ryan Dawkins
 * @since 0.1
 * @package com.ryanddawkins.glowing_spice
 * @extends com.ryanddawkins.glowing_spice.MediaFile
 */
public class Movie extends MediaFile<Movie>
{

	/**
	 * Constructor to create a movie instance and store it's "movie name"
	 *
	 * @param String fileName
	 */
	public Movie(String fileName)
	{
		super(fileName);
	}

	protected Movie getThis(){ return this; }

	/**
	 * Calls the static Movie.toJSON() method
	 *
	 * @return String json
	 */
	public String toJSON()
	{
		return Movie.toJSON(this);
	}

	/**
	 * Returns a JSON encoded string of the object Movie
	 *
	 * @param Movie m
	 * @return String json
	 */
	public static String toJSON(Movie m)
	{
		// Not synchronized, but has better runtime
		StringBuilder json = new StringBuilder();
		json.append("{");
			json.append("\"movie\":{");
				json.append("\"name\":\"").append(m.getName()).append("\",");
				json.append("\"fileName\":\"").append(m.getFileName()).append("\",");
				json.append("\"isDirectory\":\"").append(m.isDirectory()).append("\"");
			json.append("}");
		json.append("}");
		return json.toString();
	}

}