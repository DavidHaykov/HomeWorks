package telran.library.cli.librarian;

import telran.library.cli.LibraryItem;
import telran.library.model.ILibrary;
import telran.library.view.InputOutput;

import java.io.IOException;
import java.util.List;

public class GetAuthorBooksItem extends LibraryItem {
    public GetAuthorBooksItem(InputOutput inOut, ILibrary library) {
        super(inOut, library);
    }

    @Override
    public String displayedName() {
        return "Get books by author";
    }

    @Override
    public void perform() throws IOException {
        List<String> authors = library.getAuthorNames();
        String author = inOut.inputString("Enter author from " + authors, authors);
        if(author == null){
            return;
        }
        inOut.outputLine(library.getBooksAuthor(author));
    }
}
