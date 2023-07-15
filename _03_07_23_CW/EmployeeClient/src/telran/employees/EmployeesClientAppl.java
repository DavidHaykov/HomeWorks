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
            new DisplayCompaniesAvgSalaryItem(service, inOut),
            new HireEmployeeItem(service, inOut),
            new FireEmployeeItem(service, inOut),
            new DisplayAverageSalaryItem( service, inOut),
            new DisplayEmployeeItem(service, inOut),
            new DisplayCompaniesAvgSalaryItem(service, inOut),
            new DisplayEmployeesSalaryItem(service, inOut),
            new CloseConnectionAndExitItem(service, inOut)
        };
        Menu menu = new Menu(items, inOut);
        menu.runMenu();

    }
}
