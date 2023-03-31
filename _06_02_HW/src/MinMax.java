import java.util.Objects;

public class MinMax {
    public static void main(String[] args) {
        Values intValue = new Values("int", String.valueOf(Integer.MIN_VALUE), String.valueOf(Integer.MAX_VALUE));
        Values floatValue = new Values("float", String.valueOf(Float.MIN_VALUE), String.valueOf(Float.MAX_VALUE));
        Values doubleValue = new Values("double", String.valueOf(Double.MIN_VALUE), String.valueOf(Double.MAX_VALUE));
        Values longValue = new Values("long", String.valueOf(Long.MIN_VALUE), String.valueOf(Long.MAX_VALUE));
        Values byteValue = new Values("byte", String.valueOf(Byte.MIN_VALUE), String.valueOf(Byte.MAX_VALUE));
        Values shortValue = new Values("short", String.valueOf(Short.MIN_VALUE), String.valueOf(Short.MAX_VALUE));
        Values charValue = new Values("char", String.valueOf((int)Character.MIN_VALUE), String.valueOf((int)Character.MAX_VALUE));
        Values[] values = {
                intValue, floatValue, doubleValue, longValue, byteValue, shortValue, charValue
        };
        if(args.length==0){
            System.out.println("int"+" Max value = " + Integer.MAX_VALUE + " Min value = " + Integer.MIN_VALUE);
            System.out.println("byte"+" Max value = " + Byte.MAX_VALUE + " Min value = " + Byte.MIN_VALUE);
            System.out.println("short"+" Max value = " + Short.MAX_VALUE + " Min value = " + Short.MIN_VALUE);
            System.out.println("char"+" Max value = " + (int)Character.MAX_VALUE + " Min value = " + (int)Character.MIN_VALUE);
            System.out.println("long"+" Max value = " + Long.MAX_VALUE + " Min value = " + Long.MIN_VALUE);
            System.out.println("double"+" Max value = " + Double.MAX_VALUE + " Min value = " + Double.MIN_VALUE);
            System.out.println("float"+" Max value = " + Float.MAX_VALUE + " Min value = " + Float.MIN_VALUE);
            return;
        }
        for (String arg : args) {
            boolean found = false;
            for (Values value : values) {
                if (Objects.equals(value.getName(), arg)) {
                    System.out.println(value.toString());
                    found=true;
                }
            }
            if (!found) {
                System.out.println(arg + " is wrong type");
            }
        }
        }
    }

