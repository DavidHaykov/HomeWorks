package org.example;

import com.sun.jdi.PrimitiveValue;

import java.util.PropertyResourceBundle;

public enum LengthUnit {
    MM(1), CM(10), INCH(25.4), FT(304.08), M(1000);

    private double value;

    LengthUnit(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public double between(Length l1, Length l2) {
        double l1Convert = l1.convert(this).getNumber();
        double l2Convert = l2.convert(this).getNumber();
        return l2Convert - l1Convert;
    }



}
