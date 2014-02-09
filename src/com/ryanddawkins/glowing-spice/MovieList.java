package com.ryanddawkins.glowing_spice;

import java.util.ArrayList;
import java.io.File;
import java.lang.StringBuilder;

import com.ryanddawkins.glowing_spice.Response;
import com.ryanddawkins.glowing_spice.Movie;

/**
 * Class to grab all movies in a directory and store them as objects
 *
 * @author Ryan Dawkins
 * @package com.ryanddawkins.glowing_spice
 * @since 0.1
 * @extends Response
 */
public class MovieList extends Response
{

	/**
	 * Static method to grab a directories files and add them into a list
	 *
	 * @param String directory_path
	 * @return MovieList movieList
	 */
	public static MovieList create(String directory_path)
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

	/**
	 * Retrns a json encoded string of the object passed
	 *
	 * @param MovieList movieList
	 * @return String json
	 */
	public static String toJSON(MovieList movieList)
	{
		StringBuilder json = new StringBuilder();
		json.append("{");
		json.append("\"movies\":");
		json.append("[");
		ArrayList<Movie> movies = movieList.getMovies();
		for(int i = 0; i < movies.size(); i++)
		{
			json.append(movies.get(i).toJSON());
			if(i + 1 < movies.size())
			{
				json.append(",");
			}
		}
		json.append("]}");
		return json.toString();
	}

	ArrayList<Movie> movies;

	/**
	 * Constructor instaniate the ArrayList
	 */
	public MovieList()
	{
		this.movies = new ArrayList<Movie>();
	}

	/**
	 * Chainable method to add a movie to the arraylist
	 *
	 * @param Movie m
	 * @return MovieList this
	 */
	public MovieList addMovie(Movie m)
	{
		this.movies.add(m);
		return this;
	}

	/**
	 * Calls the static toJSON method and passes this
	 *
	 * @return String json
	 */
	public String toJSON()
	{
		return toJSON(this);
	}

	/**
	 * Returns ArrayList<Movie> to iterate over the movies
	 *
	 * @return ArrayList<Movie> movies
	 */
	public ArrayList<Movie> getMovies()
	{
		return this.movies;
	}

}