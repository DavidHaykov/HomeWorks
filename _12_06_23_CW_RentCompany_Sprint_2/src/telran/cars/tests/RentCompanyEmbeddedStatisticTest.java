package telran.cars.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.provider.EnumSource;
import telran.cars.dto.Car;
import telran.cars.dto.Driver;
import telran.cars.dto.Model;
import telran.cars.model.IRentCompany;
import telran.cars.model.RentCompanyEmbedded;

import java.time.LocalDate;
import java.util.List;

class RentCompanyEmbeddedStatisticTest {
    IRentCompany company = new RentCompanyEmbedded();
    int[] pricesDay = {100, 100, 100, 100, 1000};
    int[] birthYears = {2000, 1995, 1950, 1948};

    LocalDate fromDate = LocalDate.of(1900,1,1);
    LocalDate toDate = LocalDate.of(2500, 1, 1);
    LocalDate rentDate = LocalDate.of(2020,1,1);
    int rentDays = 5;




    @BeforeEach
    void setUp() {
        createAndAddModels();
        createAndAddCars();
        createAndAddDrivers();
        rentsReturns();

    }

    private void rentsReturns() {
        int[] licenses = {0,0,1,1,2,2,3,3,0};
        String[] redNumbers = {"car0", "car1", "car0", "car1", "car2", "car3", "car2", "car3", "car4"};
        for(int i = 0; i < licenses.length; i++){
            company.rentCar(redNumbers[i], licenses[i],rentDate, rentDays);
            company.returnCar(redNumbers[i], licenses[i], rentDate.plusDays(rentDays), 0, 100);
            rentDate = rentDate.plusDays(rentDays + 1);
        }
    }

    private void createAndAddDrivers() {
        for(int i = 0; i< birthYears.length; i++) {
            company.addDriver(new Driver(i, "name " + i, birthYears[i], "phone " + i));
        }
    }

    private void createAndAddCars() {
        for (int i = 0; i < pricesDay.length; i++){
            company.addCar(new Car("car" + i, "color", "model " + i));
        }
    }

    private void createAndAddModels() {
        for(int i = 0; i < pricesDay.length; i++){
            company.addModel(new Model("model " + i, 50, "company", "country", pricesDay[i]));
        }
    }

    @Test
    void getMostPopularCarModels() {
        int ageYoungFrom = rentDate.getYear() - birthYears[0];
        int ageYoungTo = rentDate.getYear() - birthYears[1] + 1;
        int ageOldFrom = rentDate.getYear() - birthYears[2];
        int ageOldTo = rentDate.getYear() - birthYears[3] + 1;
        List<String> res = company.getMostPopularCarModels(fromDate, toDate, ageYoungFrom, ageYoungTo);
        List<String> res_1 = company.getMostPopularCarModels(fromDate, toDate, ageOldFrom, ageOldTo);
        assertEquals(2, res.size());
        assertTrue(res.contains("model 0"));
        assertTrue(res.contains("model 1"));
        assertEquals(2, res_1.size());
        assertTrue(res_1.contains("model 2"));
        assertTrue(res_1.contains("model 3"));
    }

    @Test
    void getMostProfitableCarModels() {
        List<String> res = company.getMostProfitableCarModels(fromDate, toDate);
        assertEquals(1, res.size());
        assertTrue(res.contains("model 4"));
    }

    @Test
    void getMostActiveDrivers() {
        List<Driver> res = company.getMostActiveDrivers();
        assertEquals(1,res.size());
        assertTrue(res.contains(company.getDriver(0)));
    }
}