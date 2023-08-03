package telran.net.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ServerJava implements Runnable {
    ServerSocket serverSocket;
    ProtocolJava protocol;
    int port;
    ExecutorService executor = Executors.newFixedThreadPool(10);
    private volatile boolean isRunning = true;


    public ServerJava(ProtocolJava protocol, int port) throws Exception {
        super();
        this.protocol = protocol;
        this.port = port;
        serverSocket = new ServerSocket(port);
    }

    public void stopServer() throws Exception {
        isRunning = false;
        serverSocket.close();
        executor.shutdown();
        if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
            executor.shutdownNow();
        }
    }

    @Override
    public void run() {
        System.out.println("listening clients on port " + port);
        try {
            while (isRunning) {
                Socket socket = serverSocket.accept();
                ServerClientJava serverClient = new ServerClientJava(socket, protocol);
                executor.execute(serverClient);
            }
        } catch (SocketException e) {
            System.err.println("\nServer shutting down now...\n");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

