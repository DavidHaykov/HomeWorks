package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayUtilsTest
{
    @Test
    void testAdd()
    {
        int[] array = {1,2,3};
        int[] exp = {1,2,3,4};
        assertArrayEquals(exp, ArrayUtils.add(array, 4));
    }

    @Test
    void testRemoveArray()
    {
        int[] ar = { 10, 2, 7 };
        int[] exp = { 10, 2 };
        assertArrayEquals(exp, ArrayUtils.remove(ar));
    }

    @Test
    void testRemoveArrayIndex()
    {
        int[] ar = { 10, 2, 7 };
        int[] exp = { 10, 7 };
        assertArrayEquals(exp, ArrayUtils.remove(ar, 1));
    }

    @Test
    void testSum()
    {
        int[][] matrix = { { 1, 1, 1 }, { 1, 1, 1 } };
        assertEquals(6, ArrayUtils.marixSum(matrix));
    }


    @Test
    void testAddColumn()
    {
        int[][] matrix = {{ 10, 20, 30 }, { 7, 5, 3 }};
        int[] rowElements = {100, 200, 300 };
        int[][] expMatrix2 = {{ 10, 20, 30 }, { 7, 5, 3 }, { 100, 200, 300 }};
        int[][] expMatrix1 = {{ 10, 20, 30 }, { 100, 200, 300 }, { 7, 5, 3 }};
        int[][] expMatrix0 = {{ 100, 200, 300 }, { 10, 20, 30 }, { 7, 5, 3 }};
        assertArrayEquals(expMatrix2, ArrayUtils.addColumn(matrix, 2, rowElements));
        assertArrayEquals(expMatrix1, ArrayUtils.addColumn(matrix, 1, rowElements));
        assertArrayEquals(expMatrix0, ArrayUtils.addColumn(matrix, 0, rowElements));
    }

    @Test
    void testRemoveRow()

    {

        int[][] matrix = {{ 10, 20, 30 }, { 7, 5, 3 }};
        int[][] expMatrix2 = {{ 10, 20 }, { 7, 5 }};
        int[][] expMatrix1 = {{ 10, 30 }, { 7, 3 }};
        int[][] expMatrix0 = {{ 20, 30 }, { 5, 3 }};
        assertArrayEquals(expMatrix2, ArrayUtils.removeRow(matrix, 2));
        assertArrayEquals(expMatrix1, ArrayUtils.removeRow(matrix, 1));
        assertArrayEquals(expMatrix0, ArrayUtils.removeRow(matrix, 0));
    }

    @Test
    void testRemoveColumn()
    {
        int[][] matrix = { { 10, 20, 30 }, { 7, 5, 3 }, { 100, 200, 300 } };
        int[][] expMatrix2 = { { 10, 20, 30 }, { 7, 5, 3 } };
        int[][] expMatrix1 = { { 10, 20, 30 }, { 100, 200, 300 } };
        int[][] expMatrix0 = { { 7, 5, 3 }, { 100, 200, 300 } };
        assertArrayEquals(expMatrix2, ArrayUtils.removeColumn(matrix, 2));
        assertArrayEquals(expMatrix1, ArrayUtils.removeColumn(matrix, 1));
        assertArrayEquals(expMatrix0, ArrayUtils.removeColumn(matrix, 0));
    }
}
