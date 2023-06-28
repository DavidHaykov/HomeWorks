package telran.library.cli.librarian;

import telran.library.cli.LibraryItem;
import telran.library.model.ILibrary;
import telran.library.view.InputOutput;

import java.io.IOException;

public class GetReadersDelayedBooksItem extends LibraryItem {
    public GetReadersDelayedBooksItem(InputOutput inOut, ILibrary library) {
        super(inOut, library);
    }

    @Override
    public String displayedName() {
        return "Get readers delayed books";
    }

    @Override
    public void perform() throws IOException {
        inOut.outputLine(library.getReadersDelayedBook());
    }
}
