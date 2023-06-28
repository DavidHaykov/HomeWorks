package telran.library.cli;

import telran.library.model.ILibrary;
import telran.library.view.InputOutput;
import telran.library.view.Item;

public abstract class LibraryItem implements Item {
    protected InputOutput inOut;
    protected ILibrary library;

    public LibraryItem(InputOutput inOut, ILibrary library) {
        this.inOut = inOut;
        this.library = library;
    }

    public Integer getReaderIdIfNotExist(){
        Integer id = inOut.inputInteger("Enter new reader ID");
        if(id == null){
            return null;
        }
        if(library.getReader(id) != null){
            inOut.outputLine("Reader already exist");
            return null;
        }
        return id;
    }

    public Integer getReaderIdIfExist(){
        Integer id = inOut.inputInteger("Enter a reader ID");
        if(id == null){
            return null;
        }
        if(library.getReader(id) == null){
            inOut.outputLine("Reader is not exist");
            return null;
        }
        return id;
    }

    public Long getIsbnIfNotExist(){
        Long isbn = inOut.inputLong("Enter new ISBN");
        if(isbn == null){
            return null;
        }
        if(library.getBookItem(isbn) != null){
            inOut.outputLine("Book already exist");
            return null;
        }
        return isbn;
    }
    public Long getIsbnIfExist(){
        Long isbn = inOut.inputLong("Enter a ISBN");
        if(isbn == null){
            return null;
        }
        if(library.getBookItem(isbn) == null){
            inOut.outputLine("Book is not exist");
            return null;
        }
        return isbn;
    }
    public Long getIsbnNotInUse() {
        Long isbn = getIsbnIfExist();
        if(library.getBookItem(isbn).getAmountInUse() == library.getBookItem(isbn).getAmount() ||
                library.getBookItem(isbn).getAmount() == -1){
            System.out.println("Book is not available");
            return null;
        }
        return isbn;
    }

}
