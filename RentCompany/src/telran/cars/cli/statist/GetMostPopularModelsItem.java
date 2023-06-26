package telran.cars.cli.statist;

import telran.cars.cli.RentCompanyItem;
import telran.cars.model.IRentCompany;
import telran.cars.view.InputOutput;

import java.io.IOException;
import java.time.LocalDate;

public class GetMostPopularModelsItem extends RentCompanyItem {

    public GetMostPopularModelsItem(InputOutput inOut, IRentCompany company) {
        super(inOut, company);
    }

    @Override
    public String displayedName() {
        return "Get most popular models";
    }

    @Override
    public void perform() throws IOException {
        LocalDate dateFrom = inOut.inputDate("Enter date in FROM format dd-mm-yyyy", "dd-MM-yyyy");
        if(dateFrom == null){
            return;
        }
        LocalDate dateTo = inOut.inputDate("Enter date TO in format dd-mm-yyyy", "dd-MM-yyyy");
        if(dateTo == null){
            return;
        }
        Integer ageFrom = inOut.inputInteger("Enter min ege from 21 to 100", 21, 100);
        if(ageFrom == null){
            return;
        }
        Integer ageTo = inOut.inputInteger(String.format("Enter max age from %d to 100", ageFrom), ageFrom, 100);
        if(ageTo == null){
            return;
        }
        inOut.outputLine(company.getMostPopularCarModels(dateFrom, dateTo, ageFrom, ageTo));
    }
}
