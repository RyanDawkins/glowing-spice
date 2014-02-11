package com.ryanddawkins.glowing_spice.test;

import java.util.Scanner;
import java.net.Socket;
import java.net.InetAddress;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;

/**
 * This is a test example class to show how to talk to the server
 *
 * @author Ryan Dawkins
 * @package com.ryanddawkins.glowing_spice.test
 * @since 0.1
 */

public class Test_Client
{

	public static void main(String[] args)
	{

		Scanner scan = new Scanner(System.in);
		InetAddress localhost;
		Socket socket;
		PrintWriter ostream = null;
		BufferedReader reader;
		StringBuilder jsonBuilder = new StringBuilder();

		String input = "";
		boolean sentinel = true;
		while(sentinel)
		{
			if(scan.hasNextLine())
			{
				input = scan.nextLine();
				System.out.println();
			}
			if(input.equals("exit"))
			{
				sentinel = false;
				continue;
			}
			if(!input.equals(""))
			{
				try
				{

					localhost = InetAddress.getLocalHost();
					socket = new Socket(localhost, 13928);
					ostream = new PrintWriter(socket.getOutputStream());
					reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

					ostream.println(input);
					ostream.println("--DONE--");
					ostream.flush();
					StringBuilder response = new StringBuilder();
					String temp = "";
					while((temp = reader.readLine()) != null)
					{
						if(!temp.equals("--DONE--"))
						{
							response.append(temp);
						}
						else
						{
							break;
						}
					}
					System.out.println(response.toString());
				}
				catch(Exception e)
				{
					e.printStackTrace();
					sentinel = false;
					continue;
				}
			}
		}
		ostream.close();
	}
}