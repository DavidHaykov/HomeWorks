package telran.net.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class ServerJava implements Runnable
{
    ServerSocket serverSocket;
    ProtocolJava protocol;
    int port;
    static AtomicBoolean shutdown = new AtomicBoolean(false);
    ExecutorService executor;
    private int timeout;

    public ServerJava(ProtocolJava protocol, int port, ExecutorService executor, int timeout) throws Exception
    {
        super();
        this.protocol = protocol;
        this.port = port;
        this.timeout = timeout;
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(timeout);//timer for accept()
        this.executor = executor;
    }

    public void shutdown()
    {
        shutdown.set(true);
    }

    @Override
    public void run()
    {
        System.out.println("listening clients on port " + port);
        try
        {
            while(!shutdown.get())
            {
                try
                {
                    Socket socket = serverSocket.accept();// -> to clerk
                    socket.setSoTimeout(timeout);// timer for readObject()
                    ServerClientJava serverClient = new ServerClientJava(socket, protocol);
                    executor.execute(serverClient);
                } catch (SocketTimeoutException e)
                {
//					continuing loop
                }
            }
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

}
