package telran.library.model;


import org.junit.jupiter.api.Test;

public abstract class AbstractLibrary implements ILibrary{
    protected int maxPickPeriod;
    protected int minPickPeriod;

    public int getMaxPickPeriod() {
        return maxPickPeriod;
    }

    public void setMaxPickPeriod(int maxPickPeriod) {
        this.maxPickPeriod = maxPickPeriod;
    }

    public int getMinPickPeriod() {
        return minPickPeriod;
    }

    public void setMinPickPeriod(int minPickPeriod) {
        this.minPickPeriod = minPickPeriod;
    }

    public AbstractLibrary() {
        maxPickPeriod = 90;
        minPickPeriod = 5;
    }
}
