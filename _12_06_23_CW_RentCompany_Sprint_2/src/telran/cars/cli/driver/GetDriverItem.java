package telran.cars.cli.driver;

import telran.cars.cli.RentCompanyItem;
import telran.cars.model.IRentCompany;
import telran.cars.view.InputOutput;

import java.io.IOException;

public class GetDriverItem extends RentCompanyItem {
    public GetDriverItem(InputOutput inOut, IRentCompany company) {
        super(inOut, company);
    }

    @Override
    public String displayedName() {
        return "Get driver data";
    }

    @Override
    public void perform() throws IOException {
        Long licenceId = getLicenseIdIfExist();
        inOut.outputLine(company.getDriver(licenceId));
    }
}
