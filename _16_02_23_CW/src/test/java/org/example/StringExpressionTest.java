package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringExpressionTest {

    @Test
    void isTrue() {
        assertTrue(StringExpression.isTrue("true"));
        assertTrue(StringExpression.isTrue("True"));

        assertFalse(StringExpression.isTrue("tTuE"));
        assertFalse(StringExpression.isTrue("truetrue"));
        assertFalse(StringExpression.isTrue("truet"));
        assertFalse(StringExpression.isTrue("trrue"));
    }
    @Test
    void testNumber(){
        assertTrue(StringExpression.isNumber("12345"));
        assertTrue(StringExpression.isNumber("0"));

        assertFalse(StringExpression.isNumber("123,45"));
        assertFalse(StringExpression.isNumber("123a45"));
    }
    @Test
    void test3DigitsNumber(){
        assertTrue(StringExpression.isThreeDigitNumber("111"));
        assertTrue(StringExpression.isThreeDigitNumber("123"));

        assertFalse(StringExpression.isThreeDigitNumber("1"));
        assertFalse(StringExpression.isThreeDigitNumber("11"));
        assertFalse(StringExpression.isThreeDigitNumber("1111"));
        assertFalse(StringExpression.isThreeDigitNumber("1a1"));

    }
    @Test
    void testPositiveLessThan300Number(){
        assertTrue(StringExpression.isPositiveNumberLessThan300("0"));
        assertTrue(StringExpression.isPositiveNumberLessThan300("299"));
        assertTrue(StringExpression.isPositiveNumberLessThan300("10"));

        assertFalse(StringExpression.isPositiveNumberLessThan300("-10"));
        assertFalse(StringExpression.isPositiveNumberLessThan300("300"));
        assertFalse(StringExpression.isPositiveNumberLessThan300("a10"));
    }

    @Test
    void testWord(){
        assertTrue(StringExpression.isWord("Word"));
        assertTrue(StringExpression.isWord("word"));
        assertTrue(StringExpression.isWord("non-word"));
        assertTrue(StringExpression.isWord("a"));

        assertFalse(StringExpression.isWord("-word"));
        assertFalse(StringExpression.isWord("word-"));
        assertFalse(StringExpression.isWord("WOrd"));
        assertFalse(StringExpression.isWord("wo rd"));
        assertFalse(StringExpression.isWord("wo,rd"));
        assertFalse(StringExpression.isWord("wo.rd"));
        assertFalse(StringExpression.isWord("9word"));
    }
    @Test
    void testIsIsraelMobilePhone(){
        assertTrue(StringExpression.isIsraelMobilePhone("0541111111"));
        assertTrue(StringExpression.isIsraelMobilePhone("+972541111111"));
        assertTrue(StringExpression.isIsraelMobilePhone("+972-54-111-1111"));

        assertTrue(StringExpression.isIsraelMobilePhone("(+972)54-111-11-11"));
        assertTrue(StringExpression.isIsraelMobilePhone("054-111-1111"));
        assertTrue(StringExpression.isIsraelMobilePhone("054-111-11-11"));


        assertFalse(StringExpression.isIsraelMobilePhone("541111111"));
        assertFalse(StringExpression.isIsraelMobilePhone("054--1111111"));
        assertFalse(StringExpression.isIsraelMobilePhone("054?1111111"));
        assertFalse(StringExpression.isIsraelMobilePhone("54-111-1111"));
        assertFalse(StringExpression.isIsraelMobilePhone("972541111111"));
        assertFalse(StringExpression.isIsraelMobilePhone("00541111111"));
        assertFalse(StringExpression.isIsraelMobilePhone("0000000000"));
        assertFalse(StringExpression.isIsraelMobilePhone("000000000000"));
        assertFalse(StringExpression.isIsraelMobilePhone("a2134-0-0412"));
    }
}