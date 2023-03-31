package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherAppl {
    public static void main(String[] args) {
        String string = "Don't trouble trouble until trouble troubles you";
        String regex = "[Tt]rouble\\w*";
        System.out.println(string.matches(regex));

        Pattern pattern = Pattern.compile(regex);
        System.out.println(pattern.flags());
        System.out.println(pattern.pattern());

        pattern = Pattern.compile("trouble\\w", Pattern.CASE_INSENSITIVE);
        System.out.println(pattern.flags());
        System.out.println(pattern.pattern());

        Matcher matcher = pattern.matcher(string);
        System.out.println(matcher.matches());
        System.out.println(matcher.lookingAt());
        System.out.println(matcher.find());
        System.out.println(matcher.start());
        System.out.println(matcher.end());



    }
}
