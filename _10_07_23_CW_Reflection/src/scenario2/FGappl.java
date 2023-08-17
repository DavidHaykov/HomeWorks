package scenario2;

import java.lang.reflect.Method;

public class FGappl {
    public static void main(String[] args) {  //f1 hello
        for(Method m : F.class.getMethods()){
            System.out.println(m.getName());
        }
        for(Method m : F.class.getDeclaredMethods()){
            System.out.println(m.getName());
        }
        F obj = new F();
        for(int i = 0; i < args.length; i+=2){
            try{
                Method m = F.class.getDeclaredMethod(args[i], String.class);
                m.setAccessible(true);
                m.invoke(obj, args[i+1]);
            }catch (Exception e){
                System.out.println("Error " + e.getMessage());
            }
        }
    }
}
