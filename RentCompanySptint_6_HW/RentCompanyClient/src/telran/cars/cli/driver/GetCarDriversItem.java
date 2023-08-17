package telran.cars.cli.driver;

import telran.cars.cli.RentCompanyItem;
import telran.cars.model.IRentCompany;
import view.InputOutput;

import java.io.IOException;

public class GetCarDriversItem extends RentCompanyItem {
    public GetCarDriversItem(InputOutput inOut, IRentCompany company) {
        super(inOut, company);
    }

    @Override
    public String displayedName() {
        return "Get cars by drivers";
    }

    @Override
    public void perform() throws IOException {
        Long licenceId = getLicenseIdIfExist();
        if(licenceId == null){
            return;
        }
        inOut.outputLine(company.getCarsByDriver(licenceId));
    }
}
