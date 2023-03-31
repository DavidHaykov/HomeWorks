package org.example;

public class GenericAppl {
    public static void main(String[] args) {
        String str = (String) get();
        int x = 10;
        double y = 10.1;
        boolean b = true;



        Box<String> box = new Box<String>(str);
        Box<Integer> box1 = new Box<Integer>(x);
        Box<Boolean> box2 = new Box<Boolean>(b);
        Pair<Integer, String> pair = new Pair<Integer, String>(10, "hello");
        Pair<Integer, String> pair1 = new Pair<Integer, String>(10, "hello");
        Pair<Integer, Integer> pair2 = new Pair<Integer,Integer>(10,10);
        Box[] array1 = {box, box1, box2};
        System.out.println(equalsPairs(pair, pair1));

    }
    public static <K, V> boolean equalsPairs(Pair<K, V> p1, Pair<K, V> p2) {
        return p1.getKey().equals(p2.getKey())&&p1.getValue().equals(p2.getValue());
    }
    public static Object get (){

        return "str";
    }
}
