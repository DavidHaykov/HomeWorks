package scenario3;

import java.lang.reflect.Field;
import java.util.Arrays;

public class CatAppl {
    public static void main(String[] args) throws Exception {
        Cat cat = new Cat("name1", "master1", 10, "color1", Cat.Gender.F, 10);
        System.out.println(Arrays.toString(Cat.class.getFields()));
        System.out.println(Arrays.toString(Cat.class.getDeclaredFields()));

        Field f = Cat.class.getDeclaredField("color");
        System.out.println(f.getType());
        System.out.println(f.get(cat));
        f.set(cat, "black");
        System.out.println(f.get(cat));

        Field fAge = Cat.class.getDeclaredField("id");
        System.out.println(fAge.getType());
        fAge.setAccessible(true);
        System.out.println(fAge.get(cat));
        fAge.set(cat, 120);
        System.out.println(fAge.get(cat));
        Class catClass = cat.getClass();
        System.out.println(Arrays.toString(catClass.getClasses()));
        System.out.println(Arrays.toString(catClass.getDeclaredClasses()));
        System.out.println(catClass.getSuperclass());

    }
}
