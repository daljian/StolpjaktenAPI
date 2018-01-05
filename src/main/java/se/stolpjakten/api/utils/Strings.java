/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.stolpjakten.api.utils;

/**
 *
 * @author gengdahl
 */
public class Strings {

    /**
     * Check if a String is empty or null.
     *
     * @param s variable to check
     * @return true if variable is empty or null
     */
    public static boolean isNullOrEmpty(String s) {
        boolean isNullOrEmpty = true;
        // Attempt fast check first
        if (s == null || s.isEmpty()) {
            isNullOrEmpty = true;
        } else {
            //String contains characters, find at least one that isn't whitespace
            for (final char c : s.toCharArray()) {
                if (!Character.isWhitespace(c)) {
                    isNullOrEmpty = false;
                }
            }
        }
        return isNullOrEmpty;
    }
    /**
     * Password restrictions that apply are TODO
     * @param s
     * @return 
     */
    public static boolean isValidPasswordString(String s) { 
        if (isNullOrEmpty(s)) {
            return false;
        }
        return s.length() > 5 && s.length() < 40;
        
    }

}
