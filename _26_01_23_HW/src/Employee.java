import java.util.Objects;

public class Employee extends Person{
    private String company;
    private int salaryPedDay;

    public Employee(String name, int age, boolean married, String company, int salaryPedDay) {
        super(name, age, married);
        if(company!=null&&!company.isEmpty()) {
            this.company = company;
        }else{
            System.out.println("No company");
        }
        if(salaryPedDay>0&&salaryPedDay<500) {
            this.salaryPedDay = salaryPedDay;
        }else {
            System.out.println("No salary");
        }
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        if(company!=null&&!company.isEmpty()) {
            this.company = company;
        }else{
            System.out.println("No company");
        }
    }

    public int getSalaryPedDay() {
        return salaryPedDay;
    }

    public void setSalaryPedDay(int salaryPedDay) {
        if(salaryPedDay>0&&salaryPedDay<500) {
            this.salaryPedDay = salaryPedDay;
        }else {
            System.out.println("No salary");
        }
    }
    public int computeSalary(int countDays){
        if(countDays<0||countDays>31){
            return -1;
        }
        return salaryPedDay*countDays;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "salaryPedDay=" + salaryPedDay +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", married=" + isMarried() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return salaryPedDay == employee.salaryPedDay && Objects.equals(company, employee.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), company, salaryPedDay);
    }
}
