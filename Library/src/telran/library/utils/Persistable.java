package telran.library.utils;
import org.junit.jupiter.api.Test;
import telran.library.model.ILibrary;

import java.io.IOException;


public interface Persistable {
    void save(String fileName) throws IOException;
}
