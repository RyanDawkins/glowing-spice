package com.ryanddawkins.glowing_spice;

/**
 * Class to throw a null JSON exception
 *
 * @author Ryan Dawkins
 * @package com.ryanddawkins.glowing_spice
 * @since 0.1
 * @extends Exception
 */
public class NullJsonException extends Exception
{
	public NullJsonException(){ super(); }
	public NullJsonException(String message) { super(message); }
  	public NullJsonException(String message, Throwable cause) { super(message, cause); }
  	public NullJsonException(Throwable cause) { super(cause); }
}