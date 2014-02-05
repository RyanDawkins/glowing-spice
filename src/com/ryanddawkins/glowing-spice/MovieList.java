package com.ryanddawkins.glowing_spice;

import java.util.ArrayList;

import java.io.File;

import com.ryanddawkins.glowing_spice.Response;
import com.ryanddawkins.glowing_spice.Movie;

/**
 * Class to grab all movies in a directory and store them as objects
 *
 * @extends Response
 * @author Ryan Dawkins
 */
public class MovieList extends Response
{

	public static Response create(String directory_path)
	{
		MovieList movieList = new MovieList();

		File root_directory = new File(directory_path);
		File[] files = root_directory.listFiles();
		for(int i = 0; i < files.length; i++)
		{
			Movie m = new Movie(files[i].getName());
			movieList.addMovie(m);
		}
		return movieList;
	}

	ArrayList<Movie> movies;

	public MovieList()
	{
		this.movies = new ArrayList<Movie>();
	}

	public Response addMovie(Movie m)
	{
		this.movies.add(m);
		return this;
	}

}