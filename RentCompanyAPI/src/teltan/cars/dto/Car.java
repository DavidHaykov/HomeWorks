package teltan.cars.dto;

import java.io.Serializable;
import java.util.Objects;
@SuppressWarnings("serial")
public class Car implements Serializable {
    private String regNumber;
    private String color;
    private State state = State.EXCELLENT;
    private String modelName;
    private boolean inUse;
    private boolean flRemoved;

    public Car() {
    }

    public Car(String regNumber, String color, String modelName) {
        this.regNumber = regNumber;
        this.color = color;
        this.modelName = modelName;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public String getColor() {
        return color;
    }

    public State getState() {
        return state;
    }

    public String getModelName() {
        return modelName;
    }

    public boolean isInUse() {
        return inUse;
    }

    public boolean isFlRemoved() {
        return flRemoved;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }

    public void setFlRemoved(boolean flRemoved) {
        this.flRemoved = flRemoved;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(regNumber, car.regNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regNumber);
    }

    @Override
    public String toString() {
        return "Car{" +
                "regNumber='" + regNumber + '\'' +
                ", color='" + color + '\'' +
                ", state=" + state +
                ", modelName='" + modelName + '\'' +
                ", inUse=" + inUse +
                ", flRemoved=" + flRemoved +
                '}';
    }
}
