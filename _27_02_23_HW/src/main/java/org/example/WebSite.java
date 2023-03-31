package org.example;

public class WebSite extends MassMedia {
    public int numberOfUsers;
    public String url;
    public String author;
    public final int population = 9291000;

    public WebSite(String name, int numberOfUsers, String url, String author) {
        super(name);
        this.numberOfUsers = numberOfUsers;
        this.url = url;
        this.author = author;
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
        return "WebSite{" +
                "numberOfUsers=" + numberOfUsers +
                ", url='" + url + '\'' +
                ", author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", rating=" + getRating() +
                '}';
    }

}
