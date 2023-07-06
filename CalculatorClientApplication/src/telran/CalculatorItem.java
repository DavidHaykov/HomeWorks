package telran;


import view.InputOutput;
import view.Item;

import java.io.IOException;

public class CalculatorItem implements Item {
    protected CalculatorClient client;
    protected InputOutput inOut;

    public CalculatorItem(CalculatorClient client, InputOutput inOut) {
        this.client = client;
        this.inOut = inOut;
    }


    @Override
    public String displayedName() {
        return "Arithmetic calculator";
    }

    @Override
    public void perform() throws IOException {
        client.calculate();

    }


}
