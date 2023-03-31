package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void main() {
    }

    @Test
    void testTrue(){
        assertTrue(StringExpression.isTrue("true"));
        assertTrue(StringExpression.isTrue("True"));

        assertFalse(StringExpression.isTrue("tTuE"));
        assertFalse(StringExpression.isTrue("truetrue"));
        assertFalse(StringExpression.isTrue("truet"));
        assertFalse(StringExpression.isTrue("trrue"));
    }
}