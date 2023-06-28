package telran.library.cli.librarian;

import telran.library.cli.LibraryItem;
import telran.library.entities.PickRecord;
import telran.library.model.ILibrary;
import telran.library.view.InputOutput;

import java.io.IOException;
import java.time.LocalDate;

public class ReturnBookItem extends LibraryItem {
    public ReturnBookItem(InputOutput inOut, ILibrary library) {
        super(inOut, library);
    }

    @Override
    public String displayedName() {
        return "Return book";
    }

    @Override
    public void perform() throws IOException {
        Long isbn = getIsbnIfExist();
        if(isbn == null){
            return;
        }
        Integer readerId = getReaderIdIfExist();
        if(readerId == null){
            return;
        }
        LocalDate returnDate = inOut.inputDate("Enter return date in format dd-mm-yyyy", "dd-MM-yyyy");
        if(returnDate == null){
            return;
        }
        if(library.getPickRecordsAtDates(returnDate.minusYears(5), returnDate).stream().noneMatch(pr -> {
            return pr.getReaderId() == readerId && pr.getIsbn() == isbn && pr.getReturnDate() == null;
        })){
            System.out.println("This deader not use this book now");
            return;
        }


        inOut.outputLine(library.returnBook(isbn, readerId, returnDate));
    }
}
