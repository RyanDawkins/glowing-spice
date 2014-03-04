package com.ryanddawkins.glowing_spice;

import java.net.Socket;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.lang.StringBuilder;

import com.ryanddawkins.glowing_spice.NullJsonException;
import com.ryanddawkins.glowing_spice.JsonCommandNotFoundException;
import com.ryanddawkins.glowing_spice.Request;
import com.ryanddawkins.glowing_spice.VideoPlayer;

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
	private VideoPlayer player;

	/**
	 * Constructor to take and store the socket
	 *
	 * @param Socket socket
	 */
	public ClientConnection(Socket socket, VideoPlayer player)
	{
		this.socket = socket;
		this.player = player;
		System.out.println("Started client connections");
	}

	/**
	 * Run method to execute when thread is called
	 *
	 * @return void
	 */
	public void run()
	{

		String jsonString = readJson();

		// Parsing the jsonString sent to the server
		Request request;
		try
		{
			request = new Request(jsonString);
		}
		catch(NullJsonException e)
		{
			e.printStackTrace();
			return;
		}
		catch(JsonCommandNotFoundException e)
		{
			e.printStackTrace();
			return;
		}

		// Takes the command from the Request object and performs some action
		String commandString = request.getCommand();
		Command command = new Command(commandString, request.getJsonElement());
		command.setPlayer(this.player);
		command.run();
		String response = command.getJsonReturn();

		// Writes some correct response signified by the 
		PrintWriter writer;
		try
		{
			writer = new PrintWriter(this.socket.getOutputStream());
			if(response != null)
			{
				writer.println(response);
			}
			writer.println(Request.TERMINATOR);
			writer.flush();
		}
		catch(IOException e)
		{
			System.out.println("Null socket sent");
			e.printStackTrace();
		}

		System.out.println("Ending client connection");
	}

	/**
	 * Method to grab the json string from the inputstream given from socket
	 *
	 * @return String json
	 */
	public String readJson()
	{
		StringBuilder jsonBuilder;
		String jsonString = "{}";
		try
		{
			// This reads data into the stringbuilder until the terminator is sent
			jsonBuilder = new StringBuilder();
			String input = "";
			BufferedReader reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			while((input = reader.readLine()) != null)
			{
			 	if(!input.equals(Request.TERMINATOR)){
					jsonBuilder.append(input);
				} else{
					break;
				}
			}
			jsonString = jsonBuilder.toString();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return jsonString;
	}

}