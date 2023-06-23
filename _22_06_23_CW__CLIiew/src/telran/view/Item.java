package telran.view;

import org.junit.jupiter.api.Test;

public interface Item {
    String displayedName();
    void perform();
    default boolean esExit(){
        return false;

    }
}
