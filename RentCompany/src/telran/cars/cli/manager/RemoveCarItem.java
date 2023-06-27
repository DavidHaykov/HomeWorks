package telran.cars.cli.manager;

import telran.cars.cli.RentCompanyItem;
import telran.cars.model.IRentCompany;
import telran.cars.view.InputOutput;

import java.io.IOException;

public class RemoveCarItem extends RentCompanyItem {

    public RemoveCarItem(InputOutput inOut, IRentCompany company) {
        super(inOut, company);
    }

    @Override
    public String displayedName() {
        return "Remove car";
    }

    @Override
    public void perform() throws IOException {
        String regNumber = getRegNumberIfExist();
        if(regNumber == null){
            return;
        }
        inOut.outputLine(company.removeCar(regNumber));
    }
}
