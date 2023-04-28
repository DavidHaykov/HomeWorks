package org.example;

import java.util.Objects;

public class Length {
    private double number;
    private LengthUnit unit;

    public Length(double number, LengthUnit unit) {
        this.number = number;
        this.unit = unit;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    public void setUnit(LengthUnit unit) {
        this.unit = unit;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }


    public String toString() {
        return (int)number + unit.name();
    }

    public Length convert(LengthUnit lengthUnit){
        double convertedNumber = this.number * this.unit.getValue() / lengthUnit.getValue();
        return new Length(convertedNumber, lengthUnit);
    }
    public Length minus(Length length){
        return new Length(this.number - length.convert(this.unit).getNumber(), this.unit);
    }
    public Length plus (Length length){
        return new Length(this.number + length.convert(this.unit).getNumber(), this.unit);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Length length = (Length) o;
        return Double.compare(length.number, number) == 0 && unit == length.unit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, unit);
    }
}
