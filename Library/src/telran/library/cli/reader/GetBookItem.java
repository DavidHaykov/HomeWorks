package telran.library.cli.reader;

import telran.library.cli.LibraryItem;
import telran.library.model.ILibrary;
import telran.library.view.InputOutput;

import java.io.IOException;

public class GetBookItem extends LibraryItem {
    public GetBookItem(InputOutput inOut, ILibrary library) {
        super(inOut, library);
    }

    @Override
    public String displayedName() {
        return "Get book";
    }

    @Override
    public void perform() throws IOException {
        Long isbn = getIsbnIfExist();
        if(isbn == null){
            return;
        }
        inOut.outputLine(library.getBookItem(isbn));
    }
}
