package com.ryanddawkins.glowing_spice;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;

import com.ryanddawkins.glowing_spice.MovieList;

/**
 * Class to run the commands parsed from the request class
 *
 * @author Ryan Dawkins
 * @package com.ryanddawkins.glowing_spice
 * @since 0.1
 */
public class Command
{
	
	public static final String GET_MOVIES = "GET_MOVIES";
	public static final String GET_MOVIE = "GET_MOVIES";

	private String command;
	private JsonElement data;

	/**
	 * Takes command string and sets data to null
	 *
	 * @param String command
	 */
	public Command(String command)
	{
		this(command, null);
	}

	/**
	 * Takes command string and data element
	 *
	 * @param String command
	 * @param JsonArray data
	 */
	public Command(String command, JsonElement data)
	{
		this.command = command;
		this.data = data;
	}

	/**
	 * Getter method for the commandString
	 *
	 * @return String command
	 */
	public String getCommandString()
	{
		return this.command;
	}

	/**
	 * Chainable setter for the command string
	 *
	 * @param String command
	 * @return Command this
	 */
	public Command setCommandString(String command)
	{
		this.command = command;
		return this;
	}

	/**
	 * Chainable to set JsonElement data
	 *
	 * @param JsonElement data
	 * @return Command this
	 */
	public Command setData(JsonElement data)
	{
		this.data = data;
		return this;
	}

	/**
	 * Getter for JsonElement data
	 *
	 * @return JsonElement data
	 */
	public JsonElement getData()
	{
		return this.data;
	}

	public void run()
	{
		if(this.command.equals(GET_MOVIES))
		{
			String directory;
			if(this.data != null && this.data.isJsonObject() && this.data.getAsJsonObject().has("directory"))
			{
				directory = this.data.getAsJsonObject().get("directory").getAsString();
			}
			else
			{
				directory = null;
			}

			MovieList movies;
			if(directory != null)
			{
				movies = MovieList.create(directory);
				System.out.println(movies.toJSON());
			}
		}
	}

}