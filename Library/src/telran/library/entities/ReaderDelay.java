package telran.library.entities;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Objects;

public class ReaderDelay extends Reader{
    private Reader reader;
    private int delay;

    public ReaderDelay() {
    }

    public ReaderDelay(int readerId, String name, String phone, LocalDate birthDate, Reader reader, int delay) {
        super(readerId, name, phone, birthDate);
        this.reader = reader;
        this.delay = delay;
    }

    public Reader getReader() {
        return reader;
    }

    public int getDelay() {
        return delay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ReaderDelay that = (ReaderDelay) o;
        return delay == that.delay && Objects.equals(reader, that.reader);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), reader, delay);
    }

}
