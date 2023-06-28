package telran.library.cli;

import telran.library.model.ILibrary;
import telran.library.utils.Persistable;
import telran.library.view.InputOutput;

import java.io.IOException;

public class SaveAndExitItem extends LibraryItem{
    String fileName;

    public SaveAndExitItem(InputOutput inOut, ILibrary library, String fileName) {
        super(inOut, library);
        this.fileName = fileName;
    }

    @Override
    public String displayedName() {
        return "Save and exit";
    }

    @Override
    public void perform() throws IOException {
        ((Persistable)library).save(fileName);
    }

    @Override
    public boolean esExit() {
        return true;
    }
}
