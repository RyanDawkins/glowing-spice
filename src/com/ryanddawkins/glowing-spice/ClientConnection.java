import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ClientConnection implements Runnable
{
	
	private Socket socket;

	public ClientConnection(Socket socket)
	{
		this.socket = socket;
	}

	public void run()
	{
		try
		{
			String input = "";
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while((input = reader.readLine()) != null)
			{
				System.out.println(input);
			}

		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}