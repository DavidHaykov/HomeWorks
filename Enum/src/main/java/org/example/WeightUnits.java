package org.example;

public enum WeightUnits {
    GR(1), KG(1000), TN(1000000), LBS(453.592);
    double gramAmount;

    WeightUnits(double gramAmount) {
        this.gramAmount = gramAmount;
    }

    public double convert(WeightUnits other){
        return gramAmount / other.getGramAmount();
    }
    public double convert(WeightUnits other, double amount){
        return gramAmount / other.getGramAmount() * amount                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   ;
    }
    public double getGramAmount() {
        return gramAmount;
    }
}

