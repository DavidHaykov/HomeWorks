package org.example.myString;

public class MyStringAppl {
    public static void main(String[] args) {
        MyString myStr = new MyString("Two beer, or not only two beer");
        for (Character c : myStr) {
            System.out.println(c);
        }
//        for (Character c:
//        myStr) {
//            if(c=='o');
//            myStr.remove(c);
//        }
        MyStrIterator iter = (MyStrIterator) myStr.iterator();
        while (iter.hasNext()){
            if(iter.next()=='o'){
                iter.remove();
            }
        }
        for (Character c : myStr) {
            System.out.println(c);
        }

    }
}
