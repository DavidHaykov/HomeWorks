package telran.employeesServer;

import telran.employeesServer.net.EmployeesProtocol;
import telran.employeesServer.servise.EmployeesMaps;
import telran.net.server.ServerJava;

public class EmployeeServerAppl {
    public static void main(String[] args) throws Exception {
            ServerJava server = new ServerJava(new EmployeesProtocol(new EmployeesMaps()), 2000);
            server.run();
    }
}
