import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;


public class TestFile {

    @BeforeEach
    void setUp() {
        System.out.println("Before each");
    }

    @AfterEach
    void tearDown() {
        System.out.println("After each");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After all");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before all");
    }

    @Test()
    @Timeout(value = 1 , unit = TimeUnit.NANOSECONDS)
    void testEquals(){
        assertEquals(1,1);

    }



    @Test
    @Disabled   //Disable test (chetting)
    void testBoolean(){
        System.out.println("Test boolean");
        assertEquals(2 + 2, 4);
        assertEquals(2 + 2, 5);  //test not passed!
    }

    @Test
    void testNull(){
        System.out.println("Test null");
        assertNull(null);
    }
    @Test
    void testSame(){
        System.out.println("Test same");
        String s = new String("Hello");
        String s1 = new String("Hello");
        String s2 = s;
        assertEquals(s, s1);
        assertEquals(s,s2);

        assertNotSame(s,s1);
        assertSame(s,s2); //ssylky

    }

}
