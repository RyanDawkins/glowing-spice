package com.ryanddawkins.glowing_spice;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;

import com.ryanddawkins.glowing_spice.MovieList;
import com.ryanddawkins.glowing_spice.VideoPlayer;

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
	public static final String PLAY_MOVIE = "PLAY_MOVIE";
	public static final String PAUSE_MEDIA = "PAUSE_MEDIA";
	public static final String NEXT_CHAPTER = "NEXT_CHAPTER";
	public static final String PREVIOUS_CHAPTER = "PREVIOUS_CHAPTER";
	public static final String SKIP_FORWARD = "SKIP_FORWARD";
	public static final String SKIP_BACKWARD = "SKIP_BACKWARD";

	private String command;
	private JsonElement data;
	private String jsonReturn;
	private VideoPlayer player;

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
	 * Chainable method to set the video player object
	 *
	 * @param String player
	 * @return Command this
	 */
	public Command setPlayer(VideoPlayer player)
	{
		this.player = player;
		return this;
	}

	/**
	 * Getter for the video player
	 *
	 * @return VideoPlayer player
	 */
	public VideoPlayer getPlayer()
	{
		return this.player;
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

	/**
	 * Method to decide what action to perform
	 *
	 * @return void
	 */
	public void run()
	{
		if(this.command.equals(GET_MOVIES))
		{
			getMovies();
		}
		else if(this.command.equals(PLAY_MOVIE))
		{
			this.player.setVisible(true);
			playMovie();
		}
		else if(this.command.equals(PAUSE_MEDIA))
		{
			pauseMovie();
		}
		else if(this.command.eqauls(NEXT_CHAPTER))
		{
			nextChapter();
		}
		else if(this.command.eqauls(PREVIOUS_CHAPTER))
		{
			previousChapter();
		}
		else if(this.command.eqauls(SKIP_BACKWARD))
		{
			fastBackward();
		}
		else if(this.command.eqauls(SKIP_FORWARD))
		{
			fastFoward();
		}
		else
		{
			System.out.println("Invalid command");
		}
	}

	/**
	 * This method makes it easier to break up the run method and control the logic
	 *
	 * @return void
	 */
	private void getMovies()
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
			this.jsonReturn = movies.toJSON();	
		}
	}

	/**
	 * Method to play a movie to break up the run method
	 *
	 * @return void
	 */
	private void playMovie()
	{
		String fileName;
		if(this.data != null && this.data.isJsonObject() && this.data.getAsJsonObject().has("filePath"))
		{
			fileName = this.data.getAsJsonObject().get("filePath").getAsString();
		}
		else
		{
			fileName = null;
		}

		if(this.player == null)
		{
			this.player = new VideoPlayer();
		}

		if(fileName != null)
		{
			this.player.playFile(fileName);
		}
	}

	/**
	 * Pauses the movie by calling the player pause function
	 *
	 * @return void
	 */
	public void pauseMovie()
	{
		this.player.pause();
	}

	/**
	 * Plays the next chapter
	 *
	 * @return void
	 */
	public void nextChapter()
	{
		this.player.nextChapter();
	}

	/**
	 * Plays the previous chapter
	 *
	 * @return void
	 */
	public void previousChapter()
	{
		this.player.previousChapter();
	}


	/**
	 * Fast forward function
	 *
	 * @return void
	 */
	public void fastFoward()
	{
		this.player.fastFoward();
	}

	/**
	 * Fast backward function
	 *
	 * @return void
	 */
	public void fastBackward()
	{
		this.player.fastBackward();
	}

	/**
	 * Get returned json data after running the run command
	 *
	 * @return String json
	 */
	public String getJsonReturn()
	{
		return this.jsonReturn;
	}

}