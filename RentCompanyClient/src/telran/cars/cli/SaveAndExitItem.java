package telran.cars.cli;


import telran.cars.utils.Persistable;
import teltan.cars.model.IRentCompany;
import view.InputOutput;

import java.io.IOException;

public class SaveAndExitItem extends RentCompanyItem{
    String fileName;

    public SaveAndExitItem(InputOutput inOut, IRentCompany company, String fileName) {
        super(inOut, company);
        this.fileName = fileName;
    }

    public boolean isExit(){
        return true;
    }

    @Override
    public String displayedName() {
        return "Save and exit";
    }

    @Override
    public void perform() throws IOException {
        ((Persistable)company).save(fileName);
    }
}
