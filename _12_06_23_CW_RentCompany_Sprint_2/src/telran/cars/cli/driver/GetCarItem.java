package telran.cars.cli.driver;

import telran.cars.cli.RentCompanyItem;
import telran.cars.model.IRentCompany;
import telran.cars.view.InputOutput;

import java.io.IOException;

public class GetCarItem  extends RentCompanyItem {
    public GetCarItem(InputOutput inOut, IRentCompany company) {
        super(inOut, company);
    }

    @Override
    public String displayedName() {
        return "Get car data";
    }

    @Override
    public void perform() throws IOException {
        String regNumber = getRegNumberIfExist();
        inOut.outputLine(company.getCar(regNumber));
    }


}
