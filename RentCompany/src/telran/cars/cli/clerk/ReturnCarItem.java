package telran.cars.cli.clerk;

import telran.cars.cli.RentCompanyItem;
import telran.cars.model.IRentCompany;
import telran.cars.view.InputOutput;

import java.io.IOException;
import java.time.LocalDate;

public class ReturnCarItem extends RentCompanyItem {
    public ReturnCarItem(InputOutput inOut, IRentCompany company) {
        super(inOut, company);
    }

    @Override
    public String displayedName() {
        return "Return car";
    }

    @Override
    public void perform() throws IOException {
        String regNumber = getRegNumberInUse();
        if(regNumber == null){
            return;
        }
        Long licenceId = getLicenseIdIfExist();
        if(licenceId == null){
            return;
        }
        LocalDate returnDate = inOut.inputDate("Enter return date in format dd-mm-yyyy", "dd-MM-yyyy");
        if(returnDate == null){
            return;
        }
        Integer damages = inOut.inputInteger("Enter damages percent from 0 to 100", 0 ,100);
        if(damages == null){
            return;
        }
        Integer tankPercent = inOut.inputInteger("Enter tank percent from 0 to 100", 0 ,100);
        if(tankPercent == null){
            return;
        }
        if(!company.getDriversByCar(regNumber).contains(company.getDriver(licenceId))){
            System.out.println("This driver doesn't rent this car");
            return;
        }
        inOut.outputLine(company.returnCar(regNumber, licenceId, returnDate, damages, tankPercent));
    }
}
