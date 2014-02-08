package com.ryanddawkins.glowing_spice;

/**
 * Class to get mad if we can't find the command
 *
 * @author Ryan Dawkins
 * @package com.ryanddawkins.glowing_spice
 * @since 0.1
 * @extends Exception
 */
public class JsonCommandNotFoundException extends Exception
{
	public JsonCommandNotFoundException(){ super(); }
	public JsonCommandNotFoundException(String message) { super(message); }
  	public JsonCommandNotFoundException(String message, Throwable cause) { super(message, cause); }
  	public JsonCommandNotFoundException(Throwable cause) { super(cause); }
}