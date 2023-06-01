package org.example;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;


public class FileIntro
{

    public static void main(String[] args) throws IOException
    {
        File node = new File("file");
        File node1 = new File("C:/Users/user/eclipse-workspace/32.InputOutputStream/file");

        System.out.println(node.exists());
        node.createNewFile();
        System.out.println(node.exists());

        File node2 = new File("dir");
        node2.mkdir();

        File node3 = new File("dir1" + File.separator + "dir2" + File.separator + "dir3");
        node3.mkdirs();

        File node4 = new File(node3, "file1");
        node4.createNewFile();

//		node4.delete();
//		node3.delete();
//
//		File node5 = new File("dir1/dir2");
//		node5.delete();

        System.out.println(node2.isDirectory());
        System.out.println(node2.isFile());
        System.out.println(node2.getAbsolutePath());
        System.out.println(node4.getParent());
        System.out.println(node2.getPath());
        System.out.println(node4.length());
        System.out.println(node4.canRead());
        System.out.println(node4.canWrite());
        node4.setWritable(true);
        node4.setReadable(true);
        System.out.println(node4.canRead());
        System.out.println(node4.canWrite());
        node4.setWritable(false);
        node4.setReadable(false);
        System.out.println(node4.canRead());
        System.out.println(node4.canWrite());

        System.out.println(node4.getTotalSpace());
        System.out.println(node4.getFreeSpace());

        String[] array = node3.list();
        System.out.println(Arrays.toString(array));

        array = node1.list();
        System.out.println(Arrays.toString(array));

        printDir("file");
        printDir("dir1");
        System.out.println();
        printDir(".");
        System.out.println();
        printDir("..");
        System.out.println();
        printDir("../..");

        Path path = node4.toPath();
        File file = path.toFile();
        Files.getLastModifiedTime(node4.toPath());
    }

    public static void printDir(String dirName)
    {
        File node = new File(dirName);
        if(!node.exists())
            throw new RuntimeException(dirName + " not found");
        if(node.isFile())
            System.out.println(node.getName() + " is file");
        else
        {
            String[] ar = node.list();
            for(String s: ar)
            {
                System.out.println(s);
            }
        }
    }

}