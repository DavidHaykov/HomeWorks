package telran.library.cli.manager;

import telran.library.cli.LibraryItem;
import telran.library.model.ILibrary;
import telran.library.view.InputOutput;

import java.io.IOException;
import java.util.List;

public class RemoveAuthorItem extends LibraryItem {
    public RemoveAuthorItem(InputOutput inOut, ILibrary library) {
        super(inOut, library);
    }

    @Override
    public String displayedName() {
        return "Remove author";
    }

    @Override
    public void perform() throws IOException {
        List<String> authors = library.getAuthorNames();
        String author = inOut.inputString("Enter author to remove from" + authors, authors);
        if(author == null){
            return;
        }
        inOut.outputLine(library.removeBooksOfAuthor(author));
    }
}
