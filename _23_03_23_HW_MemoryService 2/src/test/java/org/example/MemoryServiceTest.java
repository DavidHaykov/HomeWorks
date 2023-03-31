package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemoryServiceTest {
    byte[] array;

    @Test
    void testGetMaxAvailableMemory() {
        Runtime runtime = Runtime.getRuntime();
        System.out.printf("max free memory = %d, max available memory %d, total memory %d\n",
                runtime.freeMemory(), runtime.maxMemory(), runtime.totalMemory());

        int max = MemoryService.getMaxAvailableMemory();
        array = new byte[max];

        array = null;
        boolean flag = false;
        try {
            array = new byte[max+1];
        } catch (OutOfMemoryError e){
            flag = true;
        }
        assertTrue(flag);
    }

}

