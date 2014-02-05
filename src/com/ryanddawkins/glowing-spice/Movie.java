package com.ryanddawkins.glowing_spice;

import java.lang.StringBuilder;

/**
 * Movie class created to manage data about movies
 *
 * @author Ryan Dawkins
 * @version 0.1
 */
public class Movie
{

	private String name;
	private String fileName;

	/**
	 * Constructor to create a movie instance and store it's "movie name"
	 *
	 * @param String fileName
	 */
	public Movie(String fileName)
	{
		this.fileName = fileName;

		// Removes file extension
		this.name = this.fileName.substring(0, this.fileName.lastIndexOf('.'));
	}

	/**
	 * Sets name of the movie and returns this
	 *
	 * @param String name
	 * @return Movie this
	 */
	public Movie setName(String name)
	{
		this.name = name;
		return this;
	}

	/**
	 * Returns name of the movie object
	 *
	 * @return String movie
	 */
	public String getName()
	{
		return this.name;
	}

	/**
	 * Sets file name and returns this for chainability
	 *
	 * @param String fileName
	 * @return Movie this
	 */
	public Movie setFileName(String fileName)
	{
		this.fileName = fileName;
		return this;
	}

	/**
	 * Returns fileName
	 *
	 * @return String fileName
	 */
	public String getFileName()
	{
		return this.fileName;
	}

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
				json.append("\"name\":\"").append(m.name).append("\",");
				json.append("\"fileName\":\"").append(m.fileName).append("\"");
			json.append("}");
		json.append("}");
		return json.toString();
	}

}