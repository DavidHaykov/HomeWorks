package org.example.driver;

public class User implements CarDrive, PrinterDrive{
    @Override
    public void say() {
        System.out.println("I'm user");
    }

    @Override
    public void drive() {
        CarDrive.super.drive();
        PrinterDrive.super.drive();
    }


}
