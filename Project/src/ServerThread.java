import java.io.*;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Scanner;

public class ServerThread implements Runnable {

	private Socket server;
	private BufferedReader br;
	
	public ServerThread(Socket s)
	{
		server = s;
		try 
		{
			br = new BufferedReader(new InputStreamReader(server.getInputStream()));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		try
		{
			while(true)
			{
				
				String serverResponse = br.readLine();
				if (serverResponse.equals("gameover")) {
					break;
				}
				System.out.println("From SERVER: " + serverResponse);
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				server.close();
				br.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
	}
}