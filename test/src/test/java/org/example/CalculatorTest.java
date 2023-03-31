package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void sum() {
        assertEquals(4,Calculator.sum(2,2));
        assertNotEquals(3,Calculator.sum(1,1));
    }

    @Test
    void dic() {
        assertEquals(4, Calculator.dic(16,4));
        assertNotEquals(3, Calculator.dic(16,4));
    }

    @Test
    void mul() {
        assertEquals(16, Calculator.mul(8,2));
        assertNotEquals(16, Calculator.mul(5,4));
    }

    @Test
    void sub() {
        assertEquals(5,Calculator.sub(10,5));
        assertNotEquals(3, Calculator.sub(9,3));
    }

    @Test
    void isEven( ) {
        assertEquals(true,Calculator.isEven(2));
        assertNotEquals(true, Calculator.isEven(3));
    }
}