import com.sun.jdi.CharType;

public class MinMaxValues {
    public static void main(String[] args) {
        System.out.println("Min value of byte = " + getMinByteValue());
        System.out.println("Max value of byte = " + (byte)(getMinByteValue()-1));
        System.out.println("Min value of int = " + getMinIntValue());
        System.out.println("Max value of int = " + (int)(getMinIntValue()-1));
        System.out.println("Min value of double = " + getLongMinValue());
        System.out.println("Max value of double = " + (long)(getLongMinValue()-1));
        System.out.println("Min value of short = " + getShortMinValue());
        System.out.println("Max value of short = " + (short)(getShortMinValue()-1));
        System.out.println("Min char value = "+(int)(char)(getCharMinValues()));
        System.out.println("Max char value = "+(int)((char)(getCharMinValues()-1)));
    }
    private static long getLongMinValue(){
        long x = 1;
        while(x>0){
            x*=2;
        }
        return x;
    }
    private static char getCharMinValues(){
        char z = 1;
        for(int i = 0; i<z; i++){
            z = (char)i;
        }
        return z;
    }
    private static short getShortMinValue(){
        short res = 1;
        while (res>0){
            res++;
        }
        return res;
    }
    private static byte getMinByteValue(){
        byte res = 1;
        while (res>0){
            res += 1;
        }
        return  res;
    }
    private static int getMinIntValue() {
        int res = 1;
        while (res > 0) {
            if(res*2>0){
                res*=2;
            }else{
                res += res;
            }
        }
        return res;
    }
    private static double square(double x, double square){
        double x1 = x;
        for(int i = 1; i<square;i++){
            x*=x1;
        }
        return x;
    }
}
