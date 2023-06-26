package telran.cars.cli.driver;

import telran.cars.cli.RentCompanyItem;
import telran.cars.model.IRentCompany;
import telran.cars.view.InputOutput;

import java.io.IOException;

public class GetDriversCarItem extends RentCompanyItem {
    public GetDriversCarItem(InputOutput inOut, IRentCompany company) {
        super(inOut, company);
    }

    @Override
    public String displayedName() {
        return "Get drivers by car";
    }

    @Override
    public void perform() throws IOException {
        inOut.outputLine(company.getDriversByCar(getRegNumberIfExist()));
    }
}
