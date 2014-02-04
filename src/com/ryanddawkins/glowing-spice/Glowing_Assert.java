public class Glowing_Assert
{
	
	/**
	 * Throws an error message if the case is not true
	 * 
	 * @param String message
	 * @param boolean input
	 * @return boolean
	 */
	public static boolean assertTrue(String message, boolean input)
	{
		if(!input)
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
	 * Checks the equality of x and y
	 *
	 * @param String message
	 * @param int x
	 * @param int y
	 * @return boolean
	 */
	public static boolean assertEquals(String message, int x, int y)
	{
		if(x != y)
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
	 * Checks to see if x is equal to y
	 *
	 * @param String message
	 * @param double x
	 * @param double y
	 * @return boolean
	 */
	public static boolean assertEquals(String message, double x, double y)
	{
		if(x != y)
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
	 * Checks to see if x is equal to y are equal
	 *
	 * @param String message
	 * @param String x
	 * @param String y
	 */
	public static boolean assertEquals(String message, String x, String y)
	{
		if(!x.equals(y))
		{
			System.out.println(message);
			return false;
		}
		else
		{
			return true;
		}
	}

}