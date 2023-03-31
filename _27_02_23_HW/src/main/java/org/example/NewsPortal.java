package org.example;

public class NewsPortal extends MassMedia {
    public String url;
    public int numberOfUsers;
    public final int population = 9291000;

    public NewsPortal(String name, String url, int numberOfUsers) {
        super(name);
        this.url = url;
        this.numberOfUsers = numberOfUsers;
    }

    @Override

    public int getRating() {
        if (numberOfUsers >= population) {
            return 10;
        } else {
            return (int) Math.ceil((double) numberOfUsers / population * 10);
        }
    }

    @Override
    public String toString() {
        return "NewsPortal{" +
                "url='" + url + '\'' +
                ", numberOfUsers=" + numberOfUsers +
                ", name='" + name + '\'' +
                ", rating=" + getRating() +
                '}';
    }


}
