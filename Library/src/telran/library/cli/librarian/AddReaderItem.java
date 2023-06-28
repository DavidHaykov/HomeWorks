package telran.library.cli.librarian;

import telran.library.cli.LibraryItem;
import telran.library.entities.Reader;
import telran.library.model.ILibrary;
import telran.library.view.InputOutput;

import java.io.IOException;
import java.time.LocalDate;

public class AddReaderItem extends LibraryItem {

    public AddReaderItem(InputOutput inOut, ILibrary library) {
        super(inOut, library);
    }

    @Override
    public String displayedName() {
        return "Add reader";
    }

    @Override
    public void perform() throws IOException {
        Integer id = getReaderIdIfNotExist();
        if(id == null){
            return;
        }
        String name = inOut.inputString("Enter a reader name");{
            if(name == null){
                return;
            }
        }
        String phone = inOut.inputString("Enter a reader phone number");
        if(phone ==  null){
            return;
        }
        LocalDate birthDate = inOut.inputDate("Enter a reader birth date in format dd-mm-yyy", "dd-MM-yyyy");
        if(birthDate == null){
            return;
        }
        Reader reader = new Reader(id, name, phone, birthDate);
        inOut.outputLine(library.addReader(reader));
    }
}
