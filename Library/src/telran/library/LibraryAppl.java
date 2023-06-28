package telran.library;

import telran.library.cli.SaveAndExitItem;
import telran.library.cli.librarian.AddReaderItem;
import telran.library.cli.librarian.GetAuthorBooksItem;
import telran.library.cli.librarian.GetReadersDelayedBooksItem;
import telran.library.cli.librarian.GetReadersDelayingBooks;
import telran.library.cli.manager.AddBookExemplaryItem;
import telran.library.cli.manager.AddBookItemItem;
import telran.library.cli.manager.RemoveAuthorItem;
import telran.library.cli.manager.RemoveBookItem;
import telran.library.cli.reader.GetBookItem;
import telran.library.cli.reader.GetBooksPickedByReaderItem;
import telran.library.cli.reader.GetReaderItem;
import telran.library.cli.reader.GetReadersPickedBookItem;
import telran.library.cli.statist.GetMostActiveReadersItem;
import telran.library.cli.statist.GetMostPopularAuthorsItem;
import telran.library.cli.statist.GetMostPopularBooksItem;
import telran.library.cli.technician.GetPickedRecordsByDatesItem;
import telran.library.model.ILibrary;
import telran.library.model.LibraryMaps;
import telran.library.view.*;

import java.io.IOException;

public class LibraryAppl {
    private static final String LIBRARY_FILE = "library.data";
    static ILibrary library;
    static InputOutput inOut = new ConsoleInputOutput();

    public static void main(String[] args) throws IOException {
        library = LibraryMaps.restoreFromFile(LIBRARY_FILE);
        Menu menu = new Menu(getMainMenuItems(), inOut);
        menu.runMenu();
    }

    private static Item[] getMainMenuItems() {
        Item[] res = {
                new SubMenuItem("Librarian", inOut, getLibrarianMenuItem()),
                new SubMenuItem("Technician", inOut, getTechnicianMenuItem()),
                new SubMenuItem("Manager", inOut, getManagerMenuItems()),
                new SubMenuItem("Statist", inOut, getStatistMEnuItems()),
                new SubMenuItem("Reader", inOut, getReaderMenuItems()),
                new SaveAndExitItem(inOut, library, LIBRARY_FILE),
                new ExitItem()
        };
        return res;
    }

    private static Item[] getReaderMenuItems() {
        Item[] res = {
                new GetBookItem(inOut, library),
                new GetBooksPickedByReaderItem(inOut, library),
                new GetReaderItem(inOut, library),
                new GetReadersPickedBookItem(inOut, library),
                new ExitItem()

        };
        return res;
    }

    private static Item[] getStatistMEnuItems() {
        Item[] res ={
              new GetMostActiveReadersItem(inOut, library),
              new GetMostPopularAuthorsItem(inOut, library),
              new GetMostPopularBooksItem(inOut, library),
              new ExitItem()
        };
        return res;
    }

    private static Item[] getManagerMenuItems() {
        Item[] res ={
                new AddBookExemplaryItem(inOut, library),
                new AddBookItemItem(inOut, library),
                new RemoveAuthorItem(inOut, library),
                new RemoveBookItem(inOut, library),
                new ExitItem()
        };
        return res;
    }

    private static Item[] getTechnicianMenuItem() {
        Item[] res ={
                new GetPickedRecordsByDatesItem(inOut, library),
                new ExitItem()
        };
        return res;
    }

    private static Item[] getLibrarianMenuItem() {
        Item[] res ={
                new AddReaderItem(inOut, library),
                new GetAuthorBooksItem(inOut, library),
                new GetReadersDelayedBooksItem(inOut, library),
                new GetReadersDelayingBooks(inOut, library),
                new ExitItem()
        };
        return res;
    }
}
