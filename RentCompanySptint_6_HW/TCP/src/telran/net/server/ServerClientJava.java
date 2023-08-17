package telran.net.server;

import telran.net.RequestJava;
import telran.net.ResponseJava;

import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;


public class ServerClientJava implements Runnable
{
    ObjectOutputStream out;
    ObjectInputStream in;
    Socket socket;
    ProtocolJava protocol;


    public ServerClientJava(Socket socket, ProtocolJava protocol) throws Exception
    {
        super();
        this.socket = socket;
        this.protocol = protocol;
        out = new ObjectOutputStream(socket.getOutputStream());
        in = new ObjectInputStream(socket.getInputStream());
    }

    @Override
    public void run()
    {
        while (!ServerJava.shutdown.get())
        {
            try
            {
                RequestJava request = (RequestJava) in.readObject();
                ResponseJava response = protocol.getResponse(request);
                out.writeObject(response);
                out.reset();
            } catch (SocketTimeoutException e)
            {
                // TODO: handle exception
            }
            catch (EOFException e) {
                System.out.println("Client closed connection");
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
    }

}
