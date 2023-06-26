package telran.cars.cli.clerk;

import telran.cars.cli.RentCompanyItem;
import telran.cars.model.IRentCompany;
import telran.cars.view.InputOutput;

import java.io.IOException;
import java.util.List;

public class GetModelCarsItem extends RentCompanyItem {
    public GetModelCarsItem(InputOutput inOut, IRentCompany company) {
        super(inOut, company);
    }

    @Override
    public String displayedName() {
        return "Get cars by model";
    }

    @Override
    public void perform() throws IOException {
        List<String> models = company.getModelNames();
        String modelName = inOut.inputString("Enter model from " + models, models);
        if(modelName == null){
            return;
        }
        inOut.outputLine(company.getCarsByModel(modelName));
    }
}
