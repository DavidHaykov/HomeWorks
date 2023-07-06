package src.telran;


import net.server.ServerJava;

public class CalculatorServerAppl {
    public static void main(String[] args) throws Exception
    {
        ServerJava server = new ServerJava(new ProtocolCalculator(), 4400);
        server.run();

    }

}
