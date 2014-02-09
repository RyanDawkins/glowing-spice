package com.ryanddawkins.glowing_spice;

import java.net.Socket;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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

		String jsonString = readJson();

		Request request;
		try
		{
			request = new Request(jsonString);
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
		String response = getResponse(commandString, request);

		BufferedWriter bf;
		try
		{
			bf = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
			bf.write(response);
			bf.flush();
			bf.close();
		}
		catch(IOException e)
		{
			System.out.println("Null socket sent");
		}
	}

	public String readJson()
	{
		StringBuilder jsonBuilder;
		String jsonString = "{}";
		try
		{
			jsonBuilder = new StringBuilder();
			String input = "";
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while((input = reader.readLine()) != null)
			{
				jsonBuilder.append(input);
			}
			jsonString = jsonBuilder.toString();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return jsonString;
	}

	public String getResponse(String commandString, Request request)
	{
		Command command = new Command(commandString, request.getJsonElement());
		return command.getJsonReturn();
	}

}