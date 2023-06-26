package telran.cars.tests;


import org.junit.jupiter.api.*;

import telran.cars.dto.Car;
import telran.cars.dto.Driver;
import telran.cars.dto.Model;
import telran.cars.model.RentCompanyEmbedded;


import static org.junit.jupiter.api.Assertions.*;

class RentCompanyEmbeddedTest {

    private static final String MODEL_NAME = "BMW X5";
    private static final int GAS_TANK = 85;
    private static final int PRICE_DAY = 1000;
    private static final String COMPANY = "BMW";
    private static final String COUNTRY = "Germany";
    private static final String REG_NUMBER = "123";

    private static final long LICENCE_ID = 123;

    private static final String FILE_NAME = "company.data";
    static RentCompanyEmbedded company;

    static Car car = new Car(REG_NUMBER, "color", MODEL_NAME);
    static Model model = new Model(MODEL_NAME, GAS_TANK, COMPANY, COUNTRY, PRICE_DAY);
    static Driver driver = new Driver(LICENCE_ID, "name", 2000, "223322148");


    @BeforeEach
    void setUp() throws Exception{
        company = new RentCompanyEmbedded();
        company.addModel(model);
        company.addCar(car);
        company.addDriver(driver);
        company.save(FILE_NAME);


    }

    @AfterAll
    static void afterAll() throws Exception{

    }

    @BeforeAll
    static void beforeAll() throws Exception{

    }

    @AfterEach
    void tearDown() throws Exception{

    }

    @Test
    void name() {
    }
}