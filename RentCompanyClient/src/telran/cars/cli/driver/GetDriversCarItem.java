package telran.cars.cli.driver;

import telran.cars.cli.RentCompanyItem;
import telran.cars.model.IRentCompany;
import view.InputOutput;

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
        String regNumber = getRegNumberIfExist();
        if(regNumber == null){
            return;
        }
        inOut.outputLine(company.getDriversByCar(regNumber));
    }
}
