package telran.library.cli.manager;

import jdk.dynalink.NamedOperation;
import telran.library.cli.LibraryItem;
import telran.library.model.ILibrary;
import telran.library.view.InputOutput;

import java.io.IOException;

public class AddBookExemplaryItem extends LibraryItem {
    public AddBookExemplaryItem(InputOutput inOut, ILibrary library) {
        super(inOut, library);
    }

    @Override
    public String displayedName() {
        return "Add book exemplary";
    }

    @Override
    public void perform() throws IOException {
        Long isbn = getIsbnIfExist();
        if(isbn == null){
            return;
        }
        Integer amount = inOut.inputInteger("Enter amount of books to add", 1, 100);
        if(amount == null){
            return;
        }
        inOut.outputLine(library.addBookExemplars(isbn, amount));
    }
}
