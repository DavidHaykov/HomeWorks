package org.example;


public class PerfomanceTest {
    static int nConcat = 100_000;
    static String string = "ab";
    public static void main(String[] args) {
       long start = System.currentTimeMillis();
       stringBuilderConcat(nConcat);
       long finish = System.currentTimeMillis();
       System.out.println(finish-start);

       start = System.currentTimeMillis();
       stringConcat(nConcat);
       finish = System.currentTimeMillis();
       System.out.println(finish-start);



    }
    public static String stringConcat(int count){
        String res = "";
        while (count>0){
            res += string;
            count--;
        }
        return res;
    }
    public static String stringBuilderConcat(int count){
        StringBuilder sb = new StringBuilder();
        while(count>0){
            sb.append(string);
            count--;
        }
        return sb.toString();
    }
}
