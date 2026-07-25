package com.hackerrank.warmup;

/**
 * Julius Caesar protected his confidential information by encrypting it using a
 * cipher. Caesar's cipher shifts each letter by a number of letters. If the
 * shift takes you past the end of the alphabet, just rotate back to the front
 * of the alphabet. In the case of a rotation by 3, w, x, y and z would map to
 * z, a, b and c.
 * 
 * Original alphabet: abcdefghijklmnopqrstuvwxyz
 * Alphabet rotated +3: defghijklmnopqrstuvwxyzabc
 * Example
 * 
 * 
 * The alphabet is rotated by , matching the mapping above. The encrypted string
 * is .
 * 
 * Note: The cipher only encrypts letters; symbols, such as -, remain
 * unencrypted.
 * 
 * Function Description
 * 
 * Complete the caesarCipher function in the editor below.
 * 
 * caesarCipher has the following parameter(s):
 * 
 * string s: cleartext
 * int k: the alphabet rotation factor
 * Returns
 * 
 * string: the encrypted string
 * Input Format
 * 
 * The first line contains the integer, , the length of the unencrypted string.
 * The second line contains the unencrypted string, .
 * The third line contains , the number of letters to rotate the alphabet by.
 * 
 * Constraints
 * 
 * 
 * 
 * is a valid ASCII string without any spaces.
 * 
 * Sample Input
 * 
 * 11
 * middle-Outz
 * 2
 * Sample Output
 * 
 * okffng-Qwvb
 * Explanation
 * 
 * Original alphabet: abcdefghijklmnopqrstuvwxyz
 * Alphabet rotated +2: cdefghijklmnopqrstuvwxyzab
 * 
 * m -> o
 * i -> k
 * d -> f
 * d -> f
 * l -> n
 * e -> g
 * - -
 * O -> Q
 * u -> w
 * t -> v
 * z -> b
 * 
 */
public class CaesarCipher {
    /*
     */
    public static String caesarCipher(String s, int k) {
        // Write your code here
        // Read each characters in the string
        // shift it
        // use StringBuilder to construct new string
        // time complexity O(N) Linear, space complexity O(N)
        // Ensure k is within the 0 to 25 range
        int shift = k % 26;
        // Use StringBuilder for efficient text assembly
        StringBuilder result = new StringBuilder();

        // Look at each character one by one
        for (int i = 0; i < s.length(); i++) {
            char currentLetter = s.charAt(i);

            if (currentLetter >= 'a' && currentLetter <= 'z') {
                // Step 1: Shift the letter forward
                char shiftedLetter = (char) (currentLetter + shift);

                // Step 2: If we went past 'z', circle back to the start
                if (shiftedLetter > 'z') {
                    shiftedLetter = (char) (shiftedLetter - 26);
                }
                result.append(shiftedLetter);

            } else if (currentLetter >= 'A' && currentLetter <= 'Z') {
                // Step 1: Shift the letter forward
                char shiftedLetter = (char) (currentLetter + shift);

                // Step 2: If we went past 'Z', circle back to the start
                if (shiftedLetter > 'Z') {
                    shiftedLetter = (char) (shiftedLetter - 26);
                }
                result.append(shiftedLetter);

            } else {
                // If it is a symbol or number, keep it exactly the same
                result.append(currentLetter);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "middle-Outz";
        int k = 2;
        String encrypted = caesarCipher(s, k);
        System.out.println(encrypted); // Output: "okffng-Qwvb"
    }

}
