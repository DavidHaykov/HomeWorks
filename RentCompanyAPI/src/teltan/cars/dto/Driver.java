package teltan.cars.dto;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
public class Driver implements Serializable {
    private long licenceId;
    private String name;
    private int birthYear;
    private String phone;

    public Driver(long licenceId, String name, int birthYear, String phone) {
        this.licenceId = licenceId;
        this.name = name;
        this.birthYear = birthYear;
        this.phone = phone;
    }

    public Driver() {
    }

    public long getLicenceId() {
        return licenceId;
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return licenceId == driver.licenceId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(licenceId);
    }

    @Override
    public String toString() {
        return "Driver{" +
                "licenceId=" + licenceId +
                ", name='" + name + '\'' +
                ", birthYear=" + birthYear +
                ", phone='" + phone + '\'' +
                '}';
    }
}
