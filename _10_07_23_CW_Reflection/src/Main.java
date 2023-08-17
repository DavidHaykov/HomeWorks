import reflection.X;
import reflection.Y;
import reflection.Z;

import java.util.Arrays;


public class Main {
    static String pack = "reflection.";
    public static void main(String[] args) throws ClassNotFoundException {
        X x1 = new Y();
        X x2 = new Z();
        Class clazz = x1.getClass();
        Class clazz1 = Y.class;
        Class clazz2 = Class.forName("reflection.Z");
        Class wrap = Integer.TYPE;

        for(String str : args){
            try{
                Class<X> c1 = (Class<X>) Class.forName(pack + str);
                System.out.println(Arrays.toString(c1.getConstructors()));
                X obj = c1.getConstructor(String.class).newInstance(" Hello");
                obj.action();
            }catch (Exception e){

            }
        }
    }
}