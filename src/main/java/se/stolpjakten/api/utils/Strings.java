/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.stolpjakten.api.utils;

import java.util.regex.Pattern;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

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
     *
     * @param password
     * @return
     */
    public static boolean isValidPasswordString(String password) {
        if (isNullOrEmpty(password)) {
            return false;
        } else {
            return Pattern.matches(ConfigurationStore.PASSWORD_PATTERN.get(),
                    password);
        }
    }

    public static boolean isValidUsername(String username) {
        if (isNullOrEmpty(username)) {
            return false;
        } else {
            return Pattern.matches(ConfigurationStore.USERNAME_PATTERN.get(),
                    username);
        }

    }

    public static boolean isValidEmail(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }
}
