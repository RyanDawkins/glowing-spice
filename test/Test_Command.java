package com.ryanddawkins.glowing_spice.test;

import com.ryanddawkins.glowing_spice.Glowing_Assert;
import com.ryanddawkins.glowing_spice.Command;
import com.ryanddawkins.glowing_spice.Request;
import com.ryanddawkins.glowing_spice.MovieList;
import com.ryanddawkins.glowing_spice.Movie;
import com.ryanddawkins.glowing_spice.JsonCommandNotFoundException;
import com.ryanddawkins.glowing_spice.NullJsonException;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * Tests the command class.
 *
 * @author Ryan Dawkins
 * @package com.ryanddawkins.glowing_spice
 * @since 0.1
 * @extends com.ryanddawkins.glowing_spice.Glowing_Assert
 */
public class Test_Command extends Glowing_Assert
{

	public static void main(String[] args)
	{
		boolean sentinel = true;

		if(!testGetMovies())
		{
			sentinel = false;
		}

		if(sentinel)
		{
			System.out.println("All tests for Command class passed");
		}
		else
		{
			System.out.println("Tests for Command class failed");
		}
	}

	public static boolean testGetMovies()
	{
		String movieJson = "{\"command\": \""+Command.GET_MOVIES+"\", \"directory\": \"/home/ryan/Pictures\"}";
		Request request;
		
		try
		{
			request = new Request(movieJson); 
		}
		catch(NullJsonException e)
		{
			return false;
		}
		catch(JsonCommandNotFoundException e)
		{
			return false;
		}

		Command command = new Command(request.getCommand(), request.getJsonElement());
		command.run();

		return false;
	}

}