package org.example;

public class Newspaper extends MassMedia implements IPrintable{
    public int issueNumber;
    public int numberOfPages;
    public int circulation;
    public final int population = 9291000;


    public Newspaper(String name, int issueNumber, int numberOfPages, int circulation) {
        super(name);
        this.issueNumber = issueNumber;
        this.numberOfPages = numberOfPages;
        this.circulation = circulation;
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
        return "Newspaper{" +
                "issueNumber=" + issueNumber +
                ", numberOfPages=" + numberOfPages +
                ", circulation=" + circulation +
                ", name='" + name + '\'' +
                ", rating=" + getRating() +
                '}';
    }

    @Override
    public void print() {
        System.out.println(this);
    }
}
