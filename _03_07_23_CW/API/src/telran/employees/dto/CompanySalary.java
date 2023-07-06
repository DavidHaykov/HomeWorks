package telran.employees.dto;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
public class CompanySalary implements Serializable {
    private String companyName;
    private double avgSalary;

    public CompanySalary() {
    }

    public CompanySalary(String companyName, double avgSalary) {
        this.companyName = companyName;
        this.avgSalary = avgSalary;
    }

    public String getCompanyName() {
        return companyName;
    }

    public double getAvgSalary() {
        return avgSalary;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setAvgSalary(double avgSalary) {
        this.avgSalary = avgSalary;
    }

    @Override
    public String toString() {
        return "CompanySalary{" +
                "companyName='" + companyName + '\'' +
                ", avgSalary=" + avgSalary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanySalary that = (CompanySalary) o;
        return Objects.equals(companyName, that.companyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyName, avgSalary);
    }
}
