package teltan.cars.dto;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class ReturnCarData implements Serializable {
    String regNumber;
    long licenceId;
    LocalDate returnDate;
    int damages;
    int tankPercent;

    public ReturnCarData() {
    }

    public ReturnCarData(String regNumber, long licenceId, LocalDate returnDate, int damages, int tankPercent) {
        this.regNumber = regNumber;
        this.licenceId = licenceId;
        this.returnDate = returnDate;
        this.damages = damages;
        this.tankPercent = tankPercent;
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

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public int getDamages() {
        return damages;
    }

    public void setDamages(int damages) {
        this.damages = damages;
    }

    public int getTankPercent() {
        return tankPercent;
    }

    public void setTankPercent(int tankPercent) {
        this.tankPercent = tankPercent;
    }
}
