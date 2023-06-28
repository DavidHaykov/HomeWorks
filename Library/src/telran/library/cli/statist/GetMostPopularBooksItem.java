package telran.library.cli.statist;

import telran.library.cli.LibraryItem;
import telran.library.model.ILibrary;
import telran.library.view.InputOutput;

import java.io.IOException;
import java.time.LocalDate;

public class GetMostPopularBooksItem extends LibraryItem {
    public GetMostPopularBooksItem(InputOutput inOut, ILibrary library) {
        super(inOut, library);
    }

    @Override
    public String displayedName() {
        return "Get most popular books";
    }

    @Override
    public void perform() throws IOException {
        LocalDate dateFrom = inOut.inputDate("Enter date in FROM format dd-mm-yyyy", "dd-MM-yyyy");
        if(dateFrom == null){
            return;
        }
        LocalDate dateTo = inOut.inputDate("Enter date TO in format dd-mm-yyyy", "dd-MM-yyyy");
        if(dateTo == null){
            return;
        }
        if(dateTo.isBefore(dateFrom)){
            System.out.println("Date FROM is after date TO");
            return;
        }
        Integer ageFrom = inOut.inputInteger("Enter MIN ege from 21 to 100", 21, 100);
        if(ageFrom == null){
            return;
        }
        Integer ageTo = inOut.inputInteger(String.format("Enter MAX age from %d to 100", ageFrom), ageFrom, 100);
        if(ageTo == null){
            return;
        }
        if(ageFrom > ageTo){
            System.out.println("MIN age is greater than MAX age");
            return;
        }
        inOut.outputLine(library.getMostPopularBooks(dateFrom, dateTo, ageFrom, ageTo));
    }
}
