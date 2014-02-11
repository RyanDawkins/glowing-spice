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
		Command command = new Command(commandString, request.getJsonElement());
		command.setPlayer(this.player);
		command.run();
		String response = command.getJsonReturn();

		if(response != null)
		{
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
		System.out.println("Ending..");
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

}