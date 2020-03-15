package io.droidtech.authentification;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static boolean validateNumTel(String numTel) {

        if (numTel.length() < 8) {
            return false;
        } else if (numTel.charAt(0) != '2' || numTel.charAt(0) != '5' || numTel.charAt(0) != '9' || numTel.charAt(0) != '4') {
            return false;
        }

        return true;
    }

    public static boolean validateEmail(String email){
        return !(Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$").matcher(email).matches());
    }
}
