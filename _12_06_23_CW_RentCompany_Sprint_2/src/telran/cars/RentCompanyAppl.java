package telran.cars;

import telran.cars.cli.SaveAndExitItem;
import telran.cars.cli.manager.AddCarItem;
import telran.cars.cli.manager.AddModelItem;
import telran.cars.dto.State;
import telran.cars.model.IRentCompany;
import telran.cars.model.RentCompanyEmbedded;
import telran.cars.view.*;

import java.io.IOException;

public class RentCompanyAppl {
    private static final String COMPANY_FILE = "company.data";
    static IRentCompany company;
    static InputOutput inOut = new ConsoleInputOutput();

    public static void main(String[] args) throws IOException {
        company = RentCompanyEmbedded.restoreFromFile(COMPANY_FILE);
        Menu menu = new Menu(getMainMenuItems(), inOut);
        menu.runMenu();
    }

    private static Item[] getMainMenuItems() {
        Item[] res = {
           new SubMenuItem("Manager", inOut, getManagerMenuItem()) ,
                //todo 4
           new SaveAndExitItem(inOut, company, COMPANY_FILE),
           new ExitItem()
        };
        return res;
    }

    private static Item[] getManagerMenuItem() {
        Item[] res = {
               new AddModelItem(inOut, company),
               new AddCarItem(inOut, company),
               new ExitItem()
        };
        return res;
    }
}
