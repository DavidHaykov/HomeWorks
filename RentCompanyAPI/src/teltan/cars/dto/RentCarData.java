package teltan.cars.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@SuppressWarnings("serial")
public class RentCarData implements Serializable {
    String regNumber;
    long licenceId;
    LocalDate rentDate;
    int rentDays;

    public RentCarData() {
    }

    public RentCarData(String regNumber, long licenceId, LocalDate rentDate, int rentDays) {
        this.regNumber = regNumber;
        this.licenceId = licenceId;
        this.rentDate = rentDate;
        this.rentDays = rentDays;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public long getLicenceId() {
        return licenceId;
    }

    public void setLicenceId(long licenceId) {
        this.licenceId = licenceId;
    }

    public LocalDate getRentDate() {
        return rentDate;
    }

    public void setRentDate(LocalDate rentDate) {
        this.rentDate = rentDate;
    }

    public int getRentDays() {
        return rentDays;
    }

    public void setRentDays(int rentDays) {
        this.rentDays = rentDays;
    }
}
