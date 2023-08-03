package telran.cars.cli.clerk;

import telran.cars.cli.RentCompanyItem;
import teltan.cars.dto.Driver;
import teltan.cars.model.IRentCompany;
import view.*;

import java.io.IOException;

public class AddDriverItem  extends RentCompanyItem {
    private static final int MIN_YEAR = 1950;
    private static final int MAX_YEAR = 2002;

    public AddDriverItem(InputOutput inOut, IRentCompany company) {
        super(inOut, company);
    }

    @Override
    public String displayedName() {
        return "Add driver";
    }

    @Override
    public void perform() throws IOException {
        Long licenceId = getLicenseIdIfNotExist();
        if(licenceId == null){
            return;
        }
        String name = inOut.inputString("Enter driver name");
        if(name == null){
            return;
        }
        Integer birthYear = inOut.inputInteger(String.format("Enter driver birth year from range[%d-%d]", MIN_YEAR, MAX_YEAR), MIN_YEAR, MAX_YEAR);
        if(birthYear == null){
            return;
        }
        String phone = inOut.inputString("Enter driver phone number");
        if(phone == null){
            return;
        }
        Driver driver = new Driver(licenceId, name, birthYear, phone);
        inOut.outputLine(company.addDriver(driver));
    }

}
