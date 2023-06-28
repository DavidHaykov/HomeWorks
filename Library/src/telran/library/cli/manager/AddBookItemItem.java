package telran.library.cli.manager;

import telran.library.cli.LibraryItem;
import telran.library.entities.Book;
import telran.library.model.ILibrary;
import telran.library.view.InputOutput;

import java.io.IOException;

public class AddBookItemItem extends LibraryItem {
    public AddBookItemItem(InputOutput inOut, ILibrary library) {
        super(inOut, library);
    }

    @Override
    public String displayedName() {
        return "Add book item";
    }

    @Override
    public void perform() throws IOException {
        Long isbn = getIsbnIfNotExist();
        if(isbn == null){
            return;
        }
        String tittle = inOut.inputString("Enter book tittle");
        if(tittle == null){
            return;
        }
        String author = inOut.inputString("Enter author name");
        if(author == null){
            return;
        }
        Integer amount = inOut.inputInteger("Enter amount", 1, 100);
        if(amount == null){
            return;
        }
        Integer pickPeriod = inOut.inputInteger("Enter pick period", 3, 90);
        if(pickPeriod == null){
            return;
        }
        Book book = new Book(isbn, tittle, author, amount, pickPeriod);
        inOut.outputLine(library.addBookItem(book));
    }


}
