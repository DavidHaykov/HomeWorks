package telran.library.cli.librarian;

import telran.library.cli.LibraryItem;
import telran.library.model.ILibrary;
import telran.library.view.InputOutput;

import java.io.IOException;
import java.time.LocalDate;

public class PickBookItem extends LibraryItem {
    public PickBookItem(InputOutput inOut, ILibrary library) {
        super(inOut, library);
    }

    @Override
    public String displayedName() {
        return "Pick book";
    }

    @Override
    public void perform() throws IOException {
        Long isbn = getIsbnNotInUse();
        if(isbn == null){
            return;
        }
        Integer readerId = getReaderIdIfExist();
        if(readerId == null){
            return;
        }
        LocalDate pickDate = inOut.inputDate("Enter pick date in format dd-mm-yyyy", "dd-MM-yyyy");
        if(pickDate == null){
            return;
        }
        if(library.getPickRecordsAtDates(pickDate.minusDays(3), pickDate).stream().anyMatch(pr -> {
            return pr.getReaderId() == readerId && pr.getIsbn() == isbn && pr.getReturnDate() == null;
        })){
            System.out.println("Reader already use this book");
            return;
        }
        inOut.outputLine(library.pickBook(isbn, readerId, pickDate));
    }


}
