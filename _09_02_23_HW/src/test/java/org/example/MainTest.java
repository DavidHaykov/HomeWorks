package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void main() {
    }

    @Test
    void validPassword() {
        Main.validPassword("Aa12345!");
    }

    @Test
    void countChar() {
        assertEquals(Main.countChar("a b c d c r c e c", 'c'),4);
        assertNotEquals(Main.countChar("a e r t s s e", 'h'), 1);
    }

    @Test
    void printStringInColumn() {
        Main.printStringInColumn("1 2 3 4 5 6 7 8");
    }

    @Test
    void printSubStringReverse() {
        Main.printSubStringReverse("1 2 3 4 5",1,7 );


    }

    @Test
    void isPalindrome() {
        assertTrue(Main.isPalindrome("1234321"));
        assertFalse(Main.isPalindrome("1234567"));
    }

    @Test
    void isReverse() {
        assertTrue(Main.isReverse("123","321"));
        assertFalse(Main.isReverse("123","132"));
    }


}