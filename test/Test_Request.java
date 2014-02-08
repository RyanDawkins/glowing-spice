package com.ryanddawkins.glowing_spice.test;

import com.ryanddawkins.glowing_spice.Glowing_Assert;
import com.ryanddawkins.glowing_spice.Request;
import com.ryanddawkins.glowing_spice.NullJsonException;
import com.ryanddawkins.glowing_spice.JsonCommandNotFoundException;

/**
 * This is the test class to handle the 
 *
 * @author Ryan Dawkins
 * @package com.ryanddawkins.glowing_spice.test
 * @since 0.1
 * @extends com.ryanddawkins.glowing_spice.Glowing_Assert
 * @tests com.ryanddawkins.glowing_spice.Request
 */
public class Test_Request extends Glowing_Assert
{
	public static void main(String[] args)
	{
		boolean sentinel = true;
		if(!getCommand())
		{
			sentinel = false;
		}
		if(sentinel)
		{
			System.out.println("All tests passed for Request");
		}
		else
		{
			System.out.println("One or more tests failed");
		}
	}
	
	private static final String JSON_TO_PARSE_1 = "{\"fun\":[], \"Other\":\"Test\",\"command\":\"GET_MOVIES\"}";
	private static final String EXPECTED_COMMAND_1 = "GET_MOVIES";
	private static final String JSON_TO_PARSE_2 = "{}";

	/**
	 * Method to check to see if we can parse a JSON string to get the command object
	 *
	 * @return boolean
	 */
	public static boolean getCommand()
	{
		boolean sentinel = true;

		Request r;

		// Should pass
		r = new Request(JSON_TO_PARSE_1);
		try
		{
			r.parse();
		}
		catch(NullJsonException nj)
		{
			return false;
		}
		catch(JsonCommandNotFoundException jc)
		{
			return false;
		}

		String json = r.getCommand();
		if(!assertEquals("Incorrect Command!", EXPECTED_COMMAND_1, json))
		{
			sentinel = false;
		}

		// Should fail
		r = new Request(JSON_TO_PARSE_2);
		try
		{
			r.parse();
		}
		catch(NullJsonException nj)
		{
			return false;
		}
		catch(JsonCommandNotFoundException jc)
		{
			// This should happen
		}

		return sentinel;
	}

}