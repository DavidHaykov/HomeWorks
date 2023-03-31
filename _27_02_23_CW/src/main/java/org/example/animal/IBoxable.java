package org.example.animal;

public interface IBoxable {
    default double size(double height, double length, double width){
        return height*length*width;
    }
    static void box(){
        System.out.println("box");
    }
}
