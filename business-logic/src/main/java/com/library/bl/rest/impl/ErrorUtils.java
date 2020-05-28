package com.library.bl.rest.impl;

/**
 *
 * @author gdimitrova
 */
public class ErrorUtils {

    public static boolean isValid(String value) {
        if(!isNull(value)){
            return value.isBlank() || value.isEmpty();
        }
        return false;
    }

    public static boolean isNull(Object value) {
        return value == null;
    }
}
