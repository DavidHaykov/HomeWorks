package telran.employees;

import telran.employees.item.*;
import telran.employees.service.EmployeesTcpProxy;
import telran.employees.service.IEmployees;
import view.ConsoleInputOutput;
import view.InputOutput;
import view.Item;
import view.Menu;

public class EmployeesClientAppl {
    private static final String HOST = "localHost";
    private static final int PORT = 2000;
    static InputOutput inOut = new ConsoleInputOutput();
    static IEmployees service;

    static {
        try {
            service = new EmployeesTcpProxy(HOST, PORT);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {

        Item[] items = {
            new DisplayCompaniesAvgSalaryItem((EmployeesTcpProxy) service, inOut),
            new HireEmployeeItem((EmployeesTcpProxy) service, inOut),
            new FireEmployeeItem((EmployeesTcpProxy) service, inOut),
            new DisplayAverageSalaryItem((EmployeesTcpProxy) service, inOut),
            new DisplayEmployeeItem((EmployeesTcpProxy) service, inOut),
            new DisplayCompaniesAvgSalaryItem((EmployeesTcpProxy) service, inOut),
            new DisplayEmployeesSalaryItem((EmployeesTcpProxy) service, inOut),
            new CloseConnectionAndExitItem((EmployeesTcpProxy) service, inOut)
        };
        Menu menu = new Menu(items, inOut);
        menu.runMenu();

    }
}
