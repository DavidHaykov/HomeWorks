package telran.cars.view;

public class ExitItem implements Item{
    @Override
    public String displayedName() {
        return "Exit";
    }

    @Override
    public void perform() {

    }
    public boolean esExit(){
        return true;
    }
}
