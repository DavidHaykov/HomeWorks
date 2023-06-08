package telran.cars.utils;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Persistable {
    void save(String fileName) throws IOException;
}
