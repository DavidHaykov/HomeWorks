package telran.cars.view;

import java.io.IOException;

public interface Item {
    String displayedName();
    void perform() throws IOException;
    default boolean esExit(){
        return false;

    }
}
