package telran.library.cli.manager;

import telran.library.cli.LibraryItem;
import telran.library.model.ILibrary;
import telran.library.view.InputOutput;

import java.io.IOException;

public class RemoveBookItem extends LibraryItem {
    public RemoveBookItem(InputOutput inOut, ILibrary library) {
        super(inOut, library);
    }

    @Override
    public String displayedName() {
        return "Remove book";
    }

    @Override
    public void perform() throws IOException {
        Long isbn = getIsbnIfExist();
        if(isbn == null){
            return;
        }
        inOut.outputLine(library.removeBook(isbn));
    }
}
