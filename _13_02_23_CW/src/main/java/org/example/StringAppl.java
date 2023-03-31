package org.example;

public class StringAppl {
    public static void main(String[] args) {
        countChars("Two beer or not two beer");
    }
    public static void countChars(String string){
        if(string==null||string.isEmpty()){
            return;
        }
        int[] res = new int[127];
        char[] temp = string.toCharArray();
        for(int  i = 0; i < string.length(); i++){
            res[temp[i]]++;
        }
        for(int i = 0; i< res.length; i++){
            if(res[i]!=0){
                System.out.printf("%c -> %d\n", i, res[i]);
            }
        }
    }
}
