package telran.cars.model;

@SuppressWarnings("serial")
public abstract class AbstractRentCompany implements IRentCompany{
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
}
