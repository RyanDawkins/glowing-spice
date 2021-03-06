package com.ryanddawkins.glowing_spice;

import java.net.ServerSocket;
import java.io.IOException;
import java.lang.NumberFormatException;
import java.lang.IllegalArgumentException;
import com.ryanddawkins.glowing_spice.ClientConnection;
import com.ryanddawkins.glowing_spice.VideoPlayer;

/**
 * This is the main class to be ran in the project
 *
 * @author Ryan Dawkins
 * @package com.ryanddawkins.glowing_spice 
 * @since 0.1
 */
public class Server
{

	public static final int DEFAULT_PORT = 13928;
	public static final String PORT_COMMAND = "-p";

    /**
     * Main method to run the server and accepts port number
     *
     * @param String[] args -d <port>
     * @return void
     */
    public static void main(String[] args)
    {
        VideoPlayer player = new VideoPlayer();
   		ServerSocket server = null;
    	int port = getPort(args);

    	try
    	{
    		server = new ServerSocket(port);
    	}
    	catch(SecurityException e)
    	{
    		System.out.println("It appears you cannot use the port: "+port);
    		System.out.println("Please rerun the application with a new port as the argument.");
    		System.out.println("Example: -d <port>");
    		System.exit(1);
    	}
    	catch(IOException e)
    	{
    		System.out.println("Error connecting to the port "+port+", maybe something else is using it?");
    		System.exit(1);
    	}
    	catch(IllegalArgumentException e)
    	{
    		System.out.println("Out of port range! The range is between 0 and 65535");
    		System.exit(1);
    	}
    	while(true)
    	{
    		try
    		{
    			Thread connection = new Thread(new ClientConnection(server.accept(), player));
                connection.start();
    		}
            catch(IOException e)
            {
                System.out.println("Error with connection");
            }
    	}
    }

    /**
     * Static method to get port from args
     *
     * @param String[] args
     * @return int port
     */
    public static int getPort(String[] args)
    {
        return getPort(args, true);
    }

    /**
     * Method to get port and can turn messages_on
     *
     * @param String[] args
     * @param boolean messages_on
     * @return int port
     */
    public static int getPort(String[] args, boolean messages_on)
    {
    	int port = -1;
    	if(args.length == 0)
    	{
    		port = DEFAULT_PORT;
    	}
    	else if(args.length % 2 == 0)
    	{
    		if(args[0].equals(PORT_COMMAND))
    		{
    			try
    			{
    				port = Integer.parseInt(args[1]);
    			}
    			catch(NumberFormatException e)
    			{
    				if(messages_on)
                    {
                        System.out.println("Not a valid port: "+args[1]+" returning -1");
                        System.exit(1);
                    }
    				port = -1;
    			}
    		}
    		else
    		{
                if(messages_on)
                {
                    System.out.println("Invalid command try: -p <port>");
                    System.exit(1);
                }
                port = -1;
    		}
    	}
    	else
    	{
            if(messages_on)
            {
                System.out.println("Invalid argument for command " + args[args.length-1]+" returning -1");
                System.exit(1);
            }
            port = -1;
    	}
    	return port;
    }
}