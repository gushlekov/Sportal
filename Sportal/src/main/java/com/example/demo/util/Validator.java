package com.example.demo.util;

public class Validator {


    public static boolean validateString(String text) {
        return text != null && !text.isEmpty();
    }

    public static boolean validUsername(String username) throws Exception {
        String regexUsername = "(\\S){5,}";
        if (validateString(username) && username.matches(regexUsername)) {
            return true;
        }
        throw new Exception("Username must be at least 6 characters, without spaces");
    }

    public static boolean validPassword(String password) throws Exception {
        String regPassword = "(\\S){5,}";
        if (validateString(password) && password.matches(regPassword)){
            return true;
        }
        throw new Exception("Password must be at least 5 characters, at least one letter and one number");

    }

    public static boolean validEMail(String email) throws Exception {
        String regEmail = "[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}".toLowerCase();
        if (validateString(email) && email.matches(regEmail)){
            return true;
        }
        throw new Exception("Invalid email");
    }

    public static boolean checkForPositiveNum(int a) {
        if (a < 0) {
            System.out.println("Please enter correct number");
            return false;
        }
        return a > 0;
    }


}

