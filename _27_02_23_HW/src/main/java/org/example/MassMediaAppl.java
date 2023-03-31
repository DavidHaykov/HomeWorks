package org.example;

import java.util.Arrays;


public class MassMediaAppl {
    public static void main(String[] args) {
        Newspaper np1 = new Newspaper("np1", 101,10,5000000);
        Newspaper np2 = new Newspaper("np2", 102,10,7000000);
        Newspaper np3 = new Newspaper("np3", 103,10,4000000);
        Newspaper np4 = new Newspaper("np4", 104,10,1000000);
        Journal j1 = new Journal("j1", 11, 15, 6000000, true);
        Journal j2 = new Journal("j2", 12, 15, 6000000, false);
        Journal j3 = new Journal("j3", 13, 15, 6000000, true);
        NewsPortal nsP1  = new NewsPortal("nsP1", "fakenews.com", 10000);
        WebSite ws1 = new WebSite("Forum of the bastards",10000, "bastards_forum.com", "Main bastard");
        MassMedia[] array = {np1,np2,np3,np4,j1,j2,j3,nsP1,ws1};
        displayPrintable(array);
        System.out.println(Arrays.toString(getPrintableElements(array)));
        displayMassMediaRatingMoreThen(array, 2);
    }
    public static void displayMassMediaRatingMoreThen(MassMedia [] ar, int thresholdrating){
        for (MassMedia massMedia : ar) {
            if (massMedia.getRating() > thresholdrating) {
                System.out.println(massMedia);
            }
        }
    }
    private static IPrintable[] getPrintableElements(MassMedia[] arr){
        IPrintable[]  preRes = new IPrintable[arr.length];
        int j = 0;
        for(int i = 0; i< arr.length; i++){
            if(arr[i] instanceof IPrintable){
                preRes[i] = (IPrintable) arr[j];
                j++;
            }
        }
        IPrintable[] res = new IPrintable[j];
        System.arraycopy(preRes, 0, res, 0, j);
        return res;
    }
    private static void displayPrintable(MassMedia[] array){
        for (MassMedia massMedia : array) {
            if (massMedia instanceof IPrintable) {
                ((IPrintable) massMedia).print();
            }
        }
    }
}
