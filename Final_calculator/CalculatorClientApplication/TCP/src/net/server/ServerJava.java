package net.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerJava implements Runnable
{
	ServerSocket serverSocket;
	ProtocolJava protocol;
	int port;
	
	public ServerJava(ProtocolJava protocol, int port) throws Exception
	{
		super();
		this.protocol = protocol;
		this.port = port;
		serverSocket = new ServerSocket(port);
	}

	@Override
	public void run()
	{
		System.out.println("listening clients on port " + port);
		try
		{
			while(true)
			{
				Socket socket = serverSocket.accept();// -> to clerk
				ServerClientJava serverClient = new ServerClientJava(socket, protocol);
				serverClient.run();
			}
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}		
	}
	
}
