package telran.library.cli.reader;

import telran.library.cli.LibraryItem;
import telran.library.model.ILibrary;
import telran.library.view.InputOutput;

import java.io.IOException;

public class GetBooksPickedByReaderItem extends LibraryItem {
    public GetBooksPickedByReaderItem(InputOutput inOut, ILibrary library) {
        super(inOut, library);
    }

    @Override
    public String displayedName() {
        return "Get books picked by reader";
    }

    @Override
    public void perform() throws IOException {
        Integer readerId = getReaderIdIfExist();
        if(readerId == null){
            return;
        }
        inOut.outputLine(library.getBooksPickedByReader(readerId));
    }
}
