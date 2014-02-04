import java.net.InetAddress;
import java.net.Socket;
import java.io.PrintWriter;

public class Client_Test
{

	public static void main(String[] args)
	{

		try
		{
			InetAddress local = InetAddress.getLocalHost();
			Socket socket = new Socket(local, Server.DEFAULT_PORT);
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			for(int i = 0; i < args.length; i++)
			{
				out.println(args[i]);
			}
			out.flush();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}