package telran.cars.cli.manager;

import telran.cars.cli.RentCompanyItem;
import telran.cars.model.IRentCompany;
import telran.cars.view.InputOutput;

import java.io.IOException;
import java.util.List;

public class RemoveModelItem extends RentCompanyItem {

    public RemoveModelItem(InputOutput inOut, IRentCompany company) {
        super(inOut, company);
    }

    @Override
    public String displayedName() {
        return "Remove model";
    }

    @Override
    public void perform() throws IOException {
        List<String> models = company.getModelNames();
        if(models == null || models.isEmpty()){
            System.out.println("Models list is empty, you need to add cars");
            return;
        }
        String modelName = inOut.inputString("Enter model from " + models, models);
        if(modelName == null){
            return;
        }
        inOut.outputLine(company.removeCarsOfModel(modelName));
    }
}
