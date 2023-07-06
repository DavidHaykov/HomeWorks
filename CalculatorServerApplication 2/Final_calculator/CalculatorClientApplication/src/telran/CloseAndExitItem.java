package telran;

import view.InputOutput;

import java.io.IOException;

public class CloseAndExitItem extends CalculatorItem{
    public CloseAndExitItem(CalculatorClient client, InputOutput inOut) {
        super(client, inOut);
    }

    @Override
    public boolean isExit() {
        return true;
    }

    @Override
    public String displayedName() {
        return "Close and exit item";
    }

    @Override
    public void perform() throws IOException {
        client.close();
    }
}
