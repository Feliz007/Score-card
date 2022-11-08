package com.feliz.scorecard.utility;

public class PasswordGenerator {

    public static StringBuilder generatePassword(int passwordLength) {
        String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String specialCharacters = "!@#$";
        String numbers = "1234567890";

        String values = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;

        StringBuilder password = new StringBuilder();

        for (int i = 0; i <= passwordLength; i++) {
            int index = (int) (values.length() * Math.random());
            password.append(values.charAt(index));
        }
        return password;
    }
}
