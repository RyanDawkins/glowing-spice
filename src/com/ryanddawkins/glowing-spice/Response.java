package com.ryanddawkins.glowing_spice;

public class Response
{

	private String message;

	public Response setMessage(String message)
	{
		this.message = message;
		return this;
	}

	public String getMessage()
	{
		return this.message;
	}
}