package telran.cars.cli.statist;

import telran.cars.cli.RentCompanyItem;
import teltan.cars.model.IRentCompany;
import view.InputOutput;

import java.io.IOException;

public class GetMostActiveDriversItem extends RentCompanyItem {
    public GetMostActiveDriversItem(InputOutput inOut, IRentCompany company) {
        super(inOut, company);
    }

    @Override
    public String displayedName() {
        return "Get most active drivers";
    }

    @Override
    public void perform() throws IOException {
        inOut.outputLine(company.getMostActiveDrivers());
    }
}
