package org.example;

import java.util.ArrayList;
import java.util.List;

public class PasswordCheck {
    public static final String WRONG_LENGTH_MESSAGE = "wrong length";
    public static final String WRONG_SYMBOL_MESSAGE = "wrong symbol";
    public static final String NO_UPPER_CASE_MESSAGE = "no upper case letter";
    public static final String NO_LOWER_CASE_MESSAGE = "no lower case letter";
    public static final String NO_DIGIT_MESSAGE = "no digit";
    public static final String NO_SPEC_SYMBOL_MESSAGE = "no symbol";

    public static void check(String password) throws  IllegalPasswordException{
        if (password == null) {
            throw new IllegalArgumentException("null");
        }
        if(password.length() < 8) {
            throw new IllegalPasswordException(new String[]{WRONG_LENGTH_MESSAGE});
        }
        if(password.matches(".*\\s.*")){
            throw new IllegalPasswordException(new String[]{WRONG_SYMBOL_MESSAGE});
        }

        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecSymbol = false;

        for(int i = 0; i< password.length(); i++){
            if(Character.isUpperCase(password.charAt(i))){
                hasUpperCase = true;
            } else if (Character.isLowerCase(password.charAt(i))){
                hasLowerCase = true;
            } else if (Character.isDigit(password.charAt(i))){
                hasDigit = true;
            } else if (!Character.isWhitespace(password.charAt(i))){
                hasSpecSymbol = true;
            }
        }

        if(!hasUpperCase || !hasLowerCase || !hasDigit || !hasSpecSymbol){
            List<String> messages= new ArrayList<>();
            if(!hasUpperCase){
                messages.add(NO_UPPER_CASE_MESSAGE);
            }
            if(!hasLowerCase){
                messages.add((NO_LOWER_CASE_MESSAGE));
            }
            if(!hasDigit) {
                messages.add(NO_DIGIT_MESSAGE);
            }
            if(!hasSpecSymbol){
                messages.add(NO_SPEC_SYMBOL_MESSAGE);
            }
            throw new IllegalPasswordException(messages.toArray(new String[0]));
        }


    }
}

