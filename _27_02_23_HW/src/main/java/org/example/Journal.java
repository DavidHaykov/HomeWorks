package org.example;

public class Journal extends MassMedia implements IPrintable{
    public int issueNumber;
    public int numberOfPages;
    public int circulation;
    public boolean glossy;
    public final int population = 9291000;

    public Journal(String name, int issueNumber, int numberOfPages, int circulation, boolean glossy) {
        super(name);
        this.issueNumber = issueNumber;
        this.numberOfPages = numberOfPages;
        this.circulation = circulation;
        this.glossy = glossy;
    }

    @Override

    public int getRating() {
        if (circulation >= population) {
            return 10;
        } else {
            return (int) Math.ceil((double) circulation / population * 10);
        }
    }

    @Override
    public String toString() {
        return "Journal{" +
                "issueNumber=" + issueNumber +
                ", numberOfPages=" + numberOfPages +
                ", circulation=" + circulation +
                ", glossy=" + glossy +
                ", name='" + name + '\'' +
                ", rating=" + getRating() +
                '}';
    }
    @Override
    public void print() {

    }
}
