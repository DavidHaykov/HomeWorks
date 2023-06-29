package telran.net.server;

import telran.net.RequestJava;
import telran.net.ResponseJava;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerJava implements Runnable{
    int port;
    ServerSocket serverSocket;
    ProtocolJava protocol;

    public ServerJava(int port, ProtocolJava protocol) throws Exception{
        this.port = port;
        this.protocol = protocol;
        serverSocket = new ServerSocket(port);
    }

    @Override
    public void run() {
        System.out.println("listening clients on port " + port);
        try {
            while (true){
                Socket socket = serverSocket.accept(); // -> to clerk
                ServerClientJava serverClient = new ServerClientJava(socket, protocol);
                serverClient.run();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
