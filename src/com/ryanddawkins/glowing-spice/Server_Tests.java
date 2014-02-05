public class Server_Tests extends Glowing_Assert
{

	public static void main(String[] args)
	{
		boolean sentinel = true;
		if(!assertTrue("All of getPort is not correct", getPort()))
		{
			sentinel = false;
		}

		if(sentinel)
		{
			System.out.println("All tests passed");
		}
	}

	public static boolean getPort()
	{
		int portReturned = -1;
		boolean sentinel = true;

		String[] args = new String[0];
		portReturned = Server.getPort(args, false);
		if(!assertEquals("Server returned incorrect port, returned: "+portReturned, Server.DEFAULT_PORT, portReturned))
		{
			sentinel = false;
		}

		args = new String[1];
		args[0] = "crappy";
		portReturned = Server.getPort(args, false);
		if(!assertEquals("Should have returned -1, returned: "+portReturned, -1, portReturned))
		{
			sentinel = false;
		}

		args = new String[2];
		args[0] = "-d";
		args[1] = "2000";
		portReturned = Server.getPort(args, false);
		if(!assertEquals("Should have returned -1", -1, portReturned))
		{
			sentinel = false;
		}

		args = new String[2];
		args[0] = "-p";
		args[1] = "3000";
		portReturned = Server.getPort(args, false);
		if(!assertEquals("Should have returned 3000, returned: "+portReturned, 3000, portReturned))
		{
			sentinel = false;
		}

		return sentinel;

	}

}