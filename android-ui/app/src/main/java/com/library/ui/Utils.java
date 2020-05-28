package com.library.ui;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Random;

public class Utils {
    private static String digits = "0123456789";
    private static String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
    private static String upperCaseLetters = lowerCaseLetters.toUpperCase();
    private static String alphabet = lowerCaseLetters.concat(upperCaseLetters);
    private static String symbols = ".!?_";

    public static String generateUsername(String prefix, int length) {
        return prefix + generateSequence(length, false, false, true);
    }

    public static String generatePassword(int length) {
        return generateSequence(length, true, true, true);
    }

    private static String generateSequence(int length, boolean withAlphabet, boolean withSymbols, boolean withDigits) {
        Random r = new Random();
        String allSymbols = "";
        if (withAlphabet) {
            allSymbols = allSymbols.concat(alphabet);
        }
        if (withDigits) {
            allSymbols = allSymbols.concat(digits);
        }
        if (withSymbols) {
            allSymbols = allSymbols.concat(symbols);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(allSymbols.charAt(r.nextInt(allSymbols.length())));
        }
        return sb.toString();
    }

    public static String formatDate(Long milliseconds) {
        return DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM).format(new Date(milliseconds));
    }
    public static Long parseDate(String date) {
        try {
            return DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM).parse(date).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
