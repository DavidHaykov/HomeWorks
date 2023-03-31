package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangeTest {
    int[] expected = {1,2,3,4,5};
    Range range = new Range(1, 5);

    @Test
    void test()
    {
        int index = 0;
        for(int num : range)
        {
            assertEquals(num, expected[index++]);
        }
    }

}