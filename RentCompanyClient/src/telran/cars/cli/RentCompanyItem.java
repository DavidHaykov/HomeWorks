package telran.cars.cli;


import teltan.cars.model.IRentCompany;
import view.*;

public abstract class RentCompanyItem implements Item {
    protected InputOutput inOut;
    protected IRentCompany company;

    public RentCompanyItem(InputOutput inOut, IRentCompany company) {
        this.inOut = inOut;
        this.company = company;
    }
    public String getRegNumberIfNotExist() {
        String regNumber = inOut.inputString("Enter new registraton number");
        if(regNumber == null){
            return null;
        }
        if(company.getCar(regNumber) != null){
            inOut.outputLine("Car already exist");
            return null;
        }
        return regNumber;
    }
    public Long getLicenseIdIfNotExist() {
        Long licenceId = inOut.inputLong("Enter new licence ID");
        if(licenceId == null){
            return null;
        }
        if(company.getDriver(licenceId) != null){
            inOut.outputLine("Driver already exist");
            return null;
        }
        return licenceId;
    }
    public Long getLicenseIdIfExist() {
        Long licenceId = inOut.inputLong("Enter new licence ID");
        if(licenceId == null){
            return null;
        }
        if(company.getDriver(licenceId) == null){
            inOut.outputLine("Driver is not exist");
            return null;
        }
        return licenceId;
    }
    public String getRegNumberIfExist() {
        String regNumber = inOut.inputString("Enter new registraton number");
        if(regNumber == null){
            return null;
        }
        if(company.getCar(regNumber) == null){
            inOut.outputLine("Car is not exist");
            return null;
        }
        return regNumber;
    }
    public String getRegNumberNotInUse() {
        String regNumber = getRegNumberIfExist();
        if(company.getCar(regNumber).isInUse()){
            System.out.println("Car already in use");
            return null;
        }
        return regNumber;
    }
    public String getRegNumberInUse() {
        String regNumber = getRegNumberIfExist();
        if(!company.getCar(regNumber).isInUse()){
            System.out.println("Car not in use");
            return null;
        }
        return regNumber;
    }


}
