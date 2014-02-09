package com.ryanddawkins.glowing_spice;

import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.StringBuilder;

import com.ryanddawkins.glowing_spice.NullJsonException;
import com.ryanddawkins.glowing_spice.JsonCommandNotFoundException;
import com.ryanddawkins.glowing_spice.Request;

/**
 * Class to deal with client connections and to execute their commands
 *
 * @author Ryan Dawkins
 * @package com.ryanddawkins.glowing_spice
 * @since 0.1
 * @implements Runnable
 */
public class ClientConnection implements Runnable
{
	
	private Socket socket;

	/**
	 * Constructor to take and store the socket
	 *
	 * @param Socket socket
	 */
	public ClientConnection(Socket socket)
	{
		this.socket = socket;
	}

	/**
	 * Run method to execute when thread is called
	 *
	 * @return void
	 */
	public void run()
	{
		try
		{
			StringBuilder jsonBuilder = new StringBuilder();
			String input = "";
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while((input = reader.readLine()) != null)
			{
				jsonBuilder.append(input);
			}
			Request request;
			try
			{
				request = new Request(jsonBuilder.toString());
			}
			catch(NullJsonException e)
			{
				return;
			}
			catch(JsonCommandNotFoundException e)
			{
				return;
			}
			String commandString = request.getCommand();
			Command command = new Command(commandString, request.getJsonElement());
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}