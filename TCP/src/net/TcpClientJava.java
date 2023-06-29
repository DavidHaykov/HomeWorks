package net;

import java.io.*;
import java.net.Socket;

public class TcpClientJava implements Closeable
{
	protected ObjectOutputStream out;
	protected ObjectInputStream in;
	protected Socket socket;
	
	public TcpClientJava(String hostname, int port) throws Exception
	{
		socket = new Socket(hostname, port);
		out = new ObjectOutputStream(socket.getOutputStream());
		in = new ObjectInputStream(socket.getInputStream());
	}

	@Override
	public void close() throws IOException
	{
		socket.close();
	}
	
	protected <T> T sendRequest(String requestType, Serializable requestData)
	{
		try
		{
			RequestJava request = new RequestJava(requestType, requestData);
			out.writeObject(request);
			ResponseJava response = (ResponseJava) in.readObject();
			if(response.code != TcpResponseCode.OK)
				throw new Exception(response.code.toString());
			return (T) response.responseData;
		}
		catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}
