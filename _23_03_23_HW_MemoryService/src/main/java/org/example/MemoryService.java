package org.example;

public class MemoryService {
    public static int getMaxAvailableMemory() {
        int min = 1;
        int max = Integer.MAX_VALUE;
        int mid;

        while (min <= max) {
            mid = min + (max - min) / 2;
            try {
                byte[] array = new byte[mid];
                min = mid+1;

            } catch (OutOfMemoryError e){
                max = mid -1;
            }
        }
        return max;
    }
}
