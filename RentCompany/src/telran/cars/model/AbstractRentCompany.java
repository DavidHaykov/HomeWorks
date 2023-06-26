package telran.cars.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class AbstractRentCompany implements IRentCompany, Serializable {
    protected int finePercent = 15;
    protected int gasPrice = 10;



    @Override
    public int getGasPrice() {
        return gasPrice;
    }

    @Override
    public void setGasPrice(int price) {
        this.gasPrice = price;
    }

    @Override
    public int getFinePercent() {
        return finePercent;
    }

    @Override
    public void setFinePercent(int finePercent) {
        this.finePercent = finePercent;
    }

    protected double computeCost(int rentPrice, int rentDays, int delay, int tankPercent, int tankVolume) {
        double cost = rentPrice * rentDays;
        if(delay > 0){
            cost += delay * (rentPrice * (1 + (double)finePercent / 100));
        }
        if(tankPercent < 100){
            cost += tankVolume * ((double)(100 - tankPercent) / 100) * gasPrice;
        }
        return cost;
    }
}
