package telran;

import telran.view.InputOutput;
import telran.view.Item;

import java.io.IOException;

public class CalculatorItem implements Item {
    private CalculatorClient client;
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
        client.close();
    }

    @Override
    public boolean esExit() {
        return true;
    }
}
