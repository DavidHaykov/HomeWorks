import telran.net.server.ServerJava;

public class TestServerAppl {
    public static void main(String[] args) throws Exception {
        ServerJava server = new ServerJava(2000, new ProtocolTest());
        server.run();
    }
}
