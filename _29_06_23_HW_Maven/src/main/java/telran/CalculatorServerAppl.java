package telran;

import telran.net.server.ServerJava;

public class CalculatorServerAppl {
    public static void main(String[] args) throws Exception
    {
        ServerJava server = new ServerJava(new ProtocolCalculator(), 3000);
        server.run();

    }

}
