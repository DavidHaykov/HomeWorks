package org.example;

public class MemoryService {
    public static int getMaxAvailableMemory() {
        int min = 1;
        int max = Integer.MAX_VALUE;
        int mid;
        int count = 0;


        while (true) {
            mid = min + (max - min) / 2;
            try {
                byte[] array = new byte[mid];
                min = mid+1;

            } catch (OutOfMemoryError e){
                mid -= 1;
                break;
            }
            count++;

        }
        System.out.println("NUMBER OF OPERATIONS = " + count);
        return mid;
    }
}
