package com.ryanddawkins.glowing_spice;

import com.ryanddawkins.glowing_spice.Glowing_Assert;
import com.ryanddawkins.glowing_spice.Movie;

public class Movie_Test extends Glowing_Assert
{

	private static final String MOVIE_FILE_NAME = "movie.mks";
	private static final String EXPECTED_MOVIE_NAME = "movie";
	private static final String EXEPECTED_JSON = "{\"movie\":{\"name\":\"movie\",\"fileName\":\"movie.mks\"}}";

	public static void main(String[] args)
	{

		boolean sentinel = true;

		if(!testMutators()){ sentinel = false; }
		if(!testJSON()){ sentinel = false; }

		if(sentinel)
		{
			System.out.println("All Movie tests passed");
		}
		else
		{
			System.out.println("Not all movie tests passed");
		}

	}

	public static boolean testMutators()
	{

		boolean sentinel = true;

		Movie m = new Movie(MOVIE_FILE_NAME);
		if(!assertEquals("Incorrect Movie Name:"+m.getName(), m.getName(), EXPECTED_MOVIE_NAME))
		{
			sentinel = false;
		}
		return sentinel;
	}

	public static boolean testJSON()
	{

		boolean sentinel = true;

		Movie m = new Movie(MOVIE_FILE_NAME);

		if(!assertEquals("Wrong JSON!", EXEPECTED_JSON, m.toJSON()))
		{
			sentinel = false;
		}

		System.out.println(m.toJSON());

		return sentinel;

	}

}