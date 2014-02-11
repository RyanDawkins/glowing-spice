package com.ryanddawkins.glowing_spice.test;

import com.ryanddawkins.glowing_spice.Server;
import com.ryanddawkins.glowing_spice.Glowing_Assert;

import java.net.Socket;
import java.net.InetAddress;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

/**
 * Class to test the Server methods
 *
 * @author Ryan Dawkins
 * @package com.ryanddawkins.glowing_spice.test
 * @since 0.1
 * @extends com.ryanddawkins.glowing_spice.Glowing_Assert
 * @tests com.ryanddawkins.glowing_spice.Server
 */
public class Test_Server extends Glowing_Assert
{

	public static void main(String[] args)
	{
		boolean sentinel = true;
		if(!assertTrue("All of getPort is not correct", getPort()))
		{
			sentinel = false;
		}

		playMovie();

		if(sentinel)
		{
			System.out.println("All Server tests passed");
		}

	}

	/**
	 * Test method to ensure the correct port number is grabbed by the args
	 *
	 * @return boolean
	 */
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

	/**
	 * Play movie method to test how playing a movie works.
	 *
	 * @return void
	 */
	public static void playMovie()
	{
		PrintWriter writer;
		try{
			InetAddress localhost = InetAddress.getLocalHost();
			Socket socket = new Socket(localhost, 13928);
			writer = new PrintWriter(socket.getOutputStream());
			writer.println("{\"command\":\"PLAY_MOVIE\", \"fileName\":\"/media/ryan/Passport/Videos/Movies/Thriller/wwz.avi\"}");
			writer.flush();
		} catch(IOException e){
			System.out.println("IO EXCEPTION");
		}
	}

}