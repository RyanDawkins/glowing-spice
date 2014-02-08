package com.ryanddawkins.glowing_spice;

public class Response
{

	private String message;

	/**
	 * Chainable Setter method to spat a message into the json
	 *
	 * @param String message
	 * @return Response this
	 */
	public Response setMessage(String message)
	{
		this.message = message;
		return this;
	}

	/**
	 * Setter method to grab the message attribute
	 *
	 * @return String message
	 */
	public String getMessage()
	{
		return this.message;
	}

}