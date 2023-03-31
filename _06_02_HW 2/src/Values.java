import java.util.Objects;

public class Values {
    private String name;
    private String minValue;
    private String maxValue;

    public Values(String name, String minValue, String maxValue) {
        this.name = name;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMinValue() {
        return minValue;
    }

    public void setMinValue(String minValue) {
        this.minValue = minValue;
    }

    public String getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(String maxValue) {
        this.maxValue = maxValue;
    }

    @Override
    public String toString() {
        return
                "Name= " + name +
                ", MIN VALUE= " + minValue  +
                ", MAX VALUE= " + maxValue
                ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Values values = (Values) o;
        return Objects.equals(name, values.name) && Objects.equals(minValue, values.minValue) && Objects.equals(maxValue, values.maxValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, minValue, maxValue);
    }
}
