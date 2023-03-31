import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ArraysTest {
    @Test
    void testArray(){
        int[] array = new int[4];
        array[0] =10;
        array[3] =-10;
        int[] array1 = {1,2,3,4};
        int[] array2 = {1,2,3,4};
        int[] array3 = array2;
        assertArrayEquals(array1,array2);
        assertEquals(array3, array2);
        System.out.println(Arrays.toString(array1));
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        array = new int[] {3,6,1,-59,5};
        Arrays.sort(array,1,array.length-1);
        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        System.out.println(Arrays.binarySearch(array,3));
        System.out.println(Arrays.binarySearch(array,4));
    }

    @Test
    void testMatrix(){
        int[][] matrix = new int[2][2];
        matrix[0][0]= 1;
        matrix[0][1]= 2;
        matrix[1][0]= 3;
        matrix[1][1]= 4;

        int[][] matrix1 = {{1,2},{3,4}};
        for(int i = 0; i< matrix.length; i++){
            for(int j = 0; j<matrix[i].length; j++){
                System.out.println(matrix[i][j]);
            }
        }                                                       //EQUALS (43)
        System.out.println(Arrays.deepToString(matrix));
    }

    @Test
    void matrixTranspTest(){
        int[][] matrix = new int[2][3];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[1][0] = 4;
        matrix[1][1] = 5;
        matrix[1][2] = 6;
        System.out.println(Arrays.deepToString(ArraysMethods.transp(matrix)));
        int[][] ex = {{1,4},{2,5},{3,6}};
        assertArrayEquals(ex, ArraysMethods.transp(matrix));
    }

    @Test
    void testAddRow(){
        int[][] mat = {{1,2},{3,4}};
        int[][] exEnd = {{1,2,10},{3,4,20}};
        int[][] exStart = {{10,1,2},{20,3,4}};
        int[][] ex1 = {{1,10,2},{3,20,4}};
        int[] temp = {10,20};
        assertArrayEquals(exStart, ArraysMethods.addRow(mat, temp, 0));
        assertArrayEquals(exEnd, ArraysMethods.addRow(mat, temp, 2));
        assertArrayEquals(ex1, ArraysMethods.addRow(mat, temp, 1));
    }
}