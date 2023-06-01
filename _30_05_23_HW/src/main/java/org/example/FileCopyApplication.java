package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyApplication {

    public static void main(String[] args) throws IOException {
        File file1 = new File("sourceFile.txt");
        File file2 =  new File("destinationFile.txt");
        file1.createNewFile();


        String sourceFileName = file1.getName();
        String destinationFileName = file2.getName();
        boolean overwrite = destinationFileName.equals("overwrite");

        try {
            File sourceFile = new File(sourceFileName);
            File destinationFile = new File(destinationFileName);

            if (!sourceFile.exists()) {
                System.out.println("Source file does not exist.");
                return;
            }

            if (destinationFile.exists() && !overwrite) {
                System.out.println("Not overwrite.");
                return;
            }

            long startTime = System.currentTimeMillis();
            copyFile(sourceFile, destinationFile);
            long endTime = System.currentTimeMillis();

            System.out.println("File copied with speed " + sourceFile.length() / (endTime - startTime) + " byte/ms.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        file2.delete();

    }

    private static void copyFile(File sourceFile, File destinationFile) throws IOException {
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {
            byte[] buffer = new byte[16 * 1024]; // 16 KB буфер

            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }
}