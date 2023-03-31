package org.example.driver;

public class UserAppl {
    public static void main(String[] args) {
        User user = new User();
        user.say();
        user.drive();
        CarDrive.greeting();;
        PrinterDrive.greeting();;
    }
}
