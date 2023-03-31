package org.example;

import java.io.Serializable;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SelectorPhoto
{
    private static Matcher matcher;
    private static Pattern pattern;

    private static boolean isCorrectFormat(String s) {
        return s.matches("([A-Za-z])+\\\\(\\d{4})(0[1-9]|1[0-2])(0[1-9]|[12]\\d|3[01])_" +
                "(0[1-9]|1\\d|2[0-3])([0-5]\\d){2}\\.([a-z]{3,4})");
    }

    public static String[] selectPictures(String[] pictures, String regEx) {
        pattern = Pattern.compile(regEx);
        String[] preRes = new String[pictures.length];
        int j = 0;
        for (String picture : pictures) {
            matcher = pattern.matcher(picture);
            if (isCorrectFormat(picture) && matcher.find()) {
                preRes[j] = picture;
                j++;

            }
        }
        String[] res = new String[j];
        System.arraycopy(preRes, 0, res, 0, res.length);
        return res;
    }
}

