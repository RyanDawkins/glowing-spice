public class Glowing_Assert
{
	
	/**
	 * Throws an error message if the case is not true
	 * 
	 * @param String message, boolean case
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
	 * Checks equality between two integers
	 *
	 * @param int x, int y
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