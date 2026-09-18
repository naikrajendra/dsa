package com.hackerrank.warmup;

/**
 * Determines the minimum number of characters to add to a password
 * to make it strong according to HackerRank's criteria.
 * A strong password has at least one digit, one uppercase letter,
 * one lowercase letter, one special character, and is at least 6 characters long.
 * 
 * Example usage is provided in the main method.
 * 
 * MinimumNumber
 */


public class PasswordLength {

    public static int minimumNumber(int n, String password) {
        // 1. Initialize category tracking flags
        boolean hasUpperCase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        // Define the special character set as required by HackerRank
        String specialCharacters = "!@#$%^&*()-+";

        // 2. Scan the entire password to flag existing categories
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (specialCharacters.indexOf(c) != -1) {
                hasSpecial = true;
            }
        }

        // 3. Count how many mandatory categories are completely missing
        int missingCategories = 0;
        if (!hasDigit) missingCategories++;
        if (!hasUpperCase) missingCategories++;
        if (!hasLowercase) missingCategories++;
        if (!hasSpecial) missingCategories++;

        // 4. Calculate how many characters are missing to hit the length requirement
        int missingLength = Math.max(0, 6 - password.length());

        // 5. The answer is whichever deficit is larger
        return Math.max(missingCategories, missingLength);
    }

    public static void main(String[] args) {
        // Example usage
        String password = "Ab1";
        int n = password.length();
        int result = minimumNumber(n, password);
        System.out.println(result); // Output: 3
        // You can add more test cases here if needed
        password = "abc";
        n = password.length();
        result = minimumNumber(n, password);
        System.out.println(result); // Output: 3
        password = "ABC123";
        n = password.length();
        result = minimumNumber(n, password);
        System.out.println(result); // Output: 1
        password = "Abc123!";
        n = password.length();
        result = minimumNumber(n, password);
        System.out.println(result); // Output: 0
        password = "123456";
        n = password.length();
        result = minimumNumber(n, password);
        System.out.println(result); // Output: 2
    }
}
