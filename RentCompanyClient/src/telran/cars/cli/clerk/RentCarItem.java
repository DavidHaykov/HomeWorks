package telran.cars.cli.clerk;

import telran.cars.cli.RentCompanyItem;

import java.io.IOException;
import java.time.LocalDate;
import teltan.cars.model.IRentCompany;
import view.*;

public class RentCarItem extends RentCompanyItem {
    public RentCarItem(InputOutput inOut, IRentCompany company) {
        super(inOut, company);
    }

    @Override
    public String displayedName() {
        return "Rent car";
    }

    @Override
    public void perform() throws IOException {
        String regNumber = getRegNumberNotInUse();
        if(regNumber == null){
            return;
        }
        Long licenceId = getLicenseIdIfExist();
        if(licenceId == null){
            return;
        }
        LocalDate dateFrom = inOut.inputDate("Enter rent start date in format dd-mm-yyyy", "dd-MM-yyyy");
        if(dateFrom == null){
            return;
        }
        Integer rentDays = inOut.inputInteger("Enter rent days from 1 to 180", 1, 180);
        if(rentDays == null){
            return;
        }
        inOut.outputLine(company.rentCar(regNumber, licenceId, dateFrom, rentDays));
    }


}
