package telran.library.cli.statist;

import telran.library.cli.LibraryItem;
import telran.library.model.ILibrary;
import telran.library.view.InputOutput;

import java.io.IOException;

public class GetMostPopularAuthorsItem extends LibraryItem {
    public GetMostPopularAuthorsItem(InputOutput inOut, ILibrary library) {
        super(inOut, library);
    }

    @Override
    public String displayedName() {
        return "Get most popular authors";
    }

    @Override
    public void perform() throws IOException {
        inOut.outputLine(library.getMostPopularAuthors());
    }
}
