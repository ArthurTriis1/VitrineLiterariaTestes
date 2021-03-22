/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import exceptions.EmailNotMatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author arthur
 */
public class ValidateEmail {
    public static void validateEmail(String emailStr) throws EmailNotMatchException {
        Pattern VALID_EMAIL_ADDRESS_REGEX = 
        Pattern.compile("(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))", Pattern.CASE_INSENSITIVE);
        
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        if(!matcher.find()){
            throw new EmailNotMatchException(emailStr + "is not a valid email");
        };
    }
}
