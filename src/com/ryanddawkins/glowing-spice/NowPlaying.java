package com.ryanddawkins.glowing_spice;

import com.ryanddawkins.glowing_spice.VideoPlayer;
import java.lang.StringBuilder;

/**
 * Now playing is an class designed to store the data
 * for the currently playing file.
 *
 * @author Ryan Dawkins
 * @since 0.3
 * @package com.ryanddawkins.glowing_spice
 * @extends com.ryanddawkins.glowing_spice.MediaFile
 */

public class NowPlaying extends MediaFile<NowPlaying>
{

	private VideoPlayer player;
	private boolean isPaused;
	private boolean playerIsOpen;

	protected NowPlaying getThis(){ return this; }

	/**
	 * Calls super constructor
	 *
	 */
	public NowPlaying(String fileName)
	{
		super(fileName);
	}

	/**
	 * Setter for VideoPlayer
	 *
	 * @param VideoPlayers player
	 * @return NowPlaying this
	 */
	public NowPlaying setPlayer(VideoPlayer player)
	{
		this.player = player;
		this.playerIsOpen = true;
		return this;
	}

	/**
	 * Getter method for the VideoPlayer object
	 *
	 * @return VideoPlayer player
	 */
	public VideoPlayer getPlayer()
	{
		return this.player;
	}

	public String toJSON()
	{
		StringBuilder json = new StringBuilder();
		json.append("{");
		if(this.playerIsOpen)
		{
			json.append("\"isPlaying\":\"").append(this.player.isPlaying()).append("\",");
			json.append("\"isPaused\":\"").append(this.player.isPaused()).append("\",");
			json.append("\"movie\":\"").append(this.player.getPlayingFile().getName()).append("\"");
		} 
		else {
			json.append("\"isPlaying\":\"").append(false).append("\",");
			json.append("\"isPaused\":\"").append(false).append("\",");
			json.append("\"movie\":\"").append(false).append("\"");
		}
		json.append("}");

		return json.toString();
	}

}