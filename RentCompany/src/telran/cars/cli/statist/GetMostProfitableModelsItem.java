package telran.cars.cli.statist;

import telran.cars.cli.RentCompanyItem;
import telran.cars.model.IRentCompany;
import telran.cars.view.InputOutput;

import java.io.IOException;
import java.time.LocalDate;

public class GetMostProfitableModelsItem extends RentCompanyItem {

    public GetMostProfitableModelsItem(InputOutput inOut, IRentCompany company) {
        super(inOut, company);
    }

    @Override
    public String displayedName() {
        return "Get most profitable models";
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
        if(dateTo.isBefore(dateFrom)){
            System.out.println("Date FROM is after date TO");
            return;
        }
        inOut.outputLine(company.getMostProfitableCarModels(dateFrom, dateTo));
    }
}
