package com.ryanddawkins.glowing_spice;

/**
 * Class to deal with unit testing
 *
 * @author Ryan Dawkins
 * @package com.ryanddawkins.glowing_spice
 * @since 0.1
 */
public class Glowing_Assert
{
	
	/**
	 * Throws an error message if the case is not true
	 * 
	 * @param String message
	 * @param boolean result
	 * @return boolean
	 */
	public static boolean assertTrue(String message, boolean result)
	{
		if(!result)
		{
			System.out.println(message);
			return false;
		}
		else
		{
			return true;
		}
	}

	/**
	 * Checks the equality of expected and result
	 *
	 * @param String message
	 * @param int expected
	 * @param int result
	 * @return boolean
	 */
	public static boolean assertEquals(String message, int expected, int result)
	{
		if(expected != result)
		{
			System.out.println(message);
			return false;
		}
		else
		{
			return true;
		}
	}

	/**
	 * Checks to see if expected is equal to result
	 *
	 * @param String message
	 * @param double expected
	 * @param double result
	 * @return boolean
	 */
	public static boolean assertEquals(String message, double expected, double result)
	{
		if(expected != result)
		{
			System.out.println(message);
			return false;
		}
		else
		{
			return true;
		}
	}

	/**
	 * Checks to see if expected is equal to result are equal
	 *
	 * @param String message
	 * @param String expected
	 * @param String result
	 */
	public static boolean assertEquals(String message, String expected, String result)
	{
		if(result == null)
		{
			System.out.println("Error compared string is null!");
			return false;
		}
		else if(!expected.equals(result))
		{
			System.out.println(message+": "+result);
			return false;
		}
		else
		{
			return true;
		}
	}

}