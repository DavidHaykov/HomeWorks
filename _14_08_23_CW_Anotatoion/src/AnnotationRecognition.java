import java.lang.reflect.Field;
import java.util.Arrays;

public class AnnotationRecognition {
    public static boolean a_recognition(Class<?> clazz){
        return clazz.isAnnotationPresent(A.class);
    }
    public static void displayFieldsInfo(Object obj){
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        Arrays.asList(fields).forEach(f -> {
            try {
               f.setAccessible(true);
               f.isAnnotationPresent(B.class);
               B an = f.getAnnotation(B.class);
                System.out.printf("Field name : %s, field value: %s, annotation value: %s, number %d, unique: %s\n",
                        f.getName(), f.get(obj).toString(), an.value(), an.number(), an.unique());
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        });
    }
}
