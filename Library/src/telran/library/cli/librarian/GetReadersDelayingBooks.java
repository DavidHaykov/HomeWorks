package telran.library.cli.librarian;

import telran.library.cli.LibraryItem;
import telran.library.model.ILibrary;
import telran.library.view.InputOutput;

import java.io.IOException;
import java.time.LocalDate;

public class GetReadersDelayingBooks extends LibraryItem {
    public GetReadersDelayingBooks(InputOutput inOut, ILibrary library) {
        super(inOut, library);
    }

    @Override
    public String displayedName() {
        return "Get readers delaying books";
    }

    @Override
    public void perform() throws IOException {
        LocalDate date = inOut.inputDate("Enter a date in format dd-mm-yyyy", "dd-MM-yyyy");
        if(date == null){
            return;
        }
        inOut.outputLine(library.getReadersDelayingBooks(date));
    }
}
