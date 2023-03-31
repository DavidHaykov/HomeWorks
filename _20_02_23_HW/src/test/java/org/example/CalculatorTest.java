package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testWrongExpression()
    {
        assertNull(Calculator.computeExpression("*3 /7"));
        assertNull(Calculator.computeExpression("3 /7+"));
        assertNull(Calculator.computeExpression("2..5 +8/2"));// ..
        assertNull(Calculator.computeExpression("2*5 +8#2"));
    }

    @Test
    void testRightExpression()
    {
        assertEquals(10, Calculator.computeExpression(" 10+10    -10"));
        assertEquals(10, Calculator.computeExpression(" 10	*10/10"));
        assertEquals(10, Calculator.computeExpression("10+10-10*10/10"));
    }
}