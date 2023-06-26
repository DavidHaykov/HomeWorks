package telran.cars.view;

import java.io.IOException;

public class Menu {

    Item[] items;
    InputOutput inOut;


    public Menu(Item[] items, InputOutput inOut) {
        this.items = items;
        this.inOut = inOut;
    }
    public void runMenu() throws IOException {
        while (true) {
            for(int i = 0; i < items.length; i++){
                inOut.outputLine((i+1) + ". " + items[i].displayedName());
            }
            Integer select = inOut.inputInteger("Type item number", 1, items.length);
            if(select == null){
                return;
            }
            items[select-1].perform();
            if(items[select-1].esExit()){
                return;
            }
        }
    }
}
