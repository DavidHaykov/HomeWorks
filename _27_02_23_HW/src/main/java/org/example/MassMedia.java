package org.example;

public abstract class MassMedia {
    String name;
     public abstract int getRating();
    public MassMedia(String name) {
        this.name = name;
    }
}
