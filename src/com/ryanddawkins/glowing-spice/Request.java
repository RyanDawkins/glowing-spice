package com.ryanddawkins.glowing_spice;

import com.ryanddakwins.glowing_spice.Response;

/**
 * Class to handle and deal with the various commands sent to the server.
 *
 * @author Ryan Dawkins
 * @package com.ryanddawkins.glowing_spice
 * @since 0.1
 */
public class Request
{

	private String command;
	private Response response;

	/**
	 * 
	 *
	 *
	 */
	public Request(String command)
	{
		this.command = command;
	}

	public String getCommand()
	{
		return this.command;
	}

	public void runCommand()
	{
	`
	}

}