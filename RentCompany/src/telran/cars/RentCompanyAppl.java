package telran.cars;

import telran.cars.cli.SaveAndExitItem;
import telran.cars.cli.clerk.AddDriverItem;
import telran.cars.cli.clerk.GetModelCarsItem;
import telran.cars.cli.clerk.RentCarItem;
import telran.cars.cli.clerk.ReturnCarItem;
import telran.cars.cli.driver.GetCarDriversItem;
import telran.cars.cli.driver.GetCarItem;
import telran.cars.cli.driver.GetDriverItem;
import telran.cars.cli.driver.GetDriversCarItem;
import telran.cars.cli.manager.AddCarItem;
import telran.cars.cli.manager.AddModelItem;
import telran.cars.cli.manager.RemoveCarItem;
import telran.cars.cli.manager.RemoveModelItem;
import telran.cars.cli.statist.GetMostActiveDriversItem;
import telran.cars.cli.statist.GetMostPopularModelsItem;
import telran.cars.cli.statist.GetMostProfitableModelsItem;
import telran.cars.cli.technician.GetRecordsItem;
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
                new SubMenuItem("Cleck", inOut, getClerkMenuItem()),
                new SubMenuItem("Driver", inOut, getDriverMenuItem()),
                new SubMenuItem("Manager", inOut, getManagerMenuItem()),
                new SubMenuItem("Statist", inOut, getStatistMenuItem()),
                new SubMenuItem("Technician", inOut, getTechnicianMenuitem()),
                new SaveAndExitItem(inOut, company, COMPANY_FILE),
                new ExitItem()
        };
        return res;
    }

    private static Item[] getTechnicianMenuitem() {
        Item[] res = {
                new GetRecordsItem(inOut, company),
                new ExitItem()
        };
        return res;
    }

    private static Item[] getStatistMenuItem() {
        Item[] res = {
                new GetMostActiveDriversItem(inOut, company),
                new GetMostPopularModelsItem(inOut, company),
                new GetMostProfitableModelsItem(inOut, company),
                new ExitItem()
        };
        return res;
    }

    private static Item[] getDriverMenuItem() {
        Item[] res = {
                new GetCarDriversItem(inOut, company),
                new GetCarItem(inOut, company),
                new GetDriverItem(inOut, company),
                new GetDriversCarItem(inOut, company)
        };
        return res;
    }

    private static Item[] getClerkMenuItem() {
        Item[] res = {
                new AddDriverItem(inOut, company),
                new GetModelCarsItem(inOut, company),
                new RentCarItem(inOut, company),
                new ReturnCarItem(inOut, company),
                new ExitItem()
        };
        return res;
    }

    private static Item[] getManagerMenuItem() {
        Item[] res = {
               new AddModelItem(inOut, company),
               new AddCarItem(inOut, company),
               new RemoveModelItem(inOut, company),
               new RemoveCarItem(inOut, company),
               new ExitItem()
        };
        return res;
    }
}
