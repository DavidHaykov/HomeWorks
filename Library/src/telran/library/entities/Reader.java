package telran.library.entities;


import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@SuppressWarnings("serial")
public class Reader implements Serializable {
    private int readerId;
    private String name;
    private String phone;
    private LocalDate birthDate;

    public Reader() {
    }

    public Reader(int readerId, String name, String phone, LocalDate birthDate) {
        this.readerId = readerId;
        this.name = name;
        this.phone = phone;
        this.birthDate = birthDate;
    }

    public int getReaderId() {
        return readerId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reader reader = (Reader) o;
        return readerId == reader.readerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(readerId);
    }

    @Override
    public String toString() {
        return "Reader{" +
                "readerId=" + readerId +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
