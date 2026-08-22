package com.hackerrank.warmup;

/**
 * Given a string s and an integer n, finds the number of occurrences of the character 'a' 
 * in the first n characters of the infinitely repeated string s.   
 * 
 * RepeatedString
 */

public class RepeatedString {

    public static long repeatedString(String s, long n) {
    // Write your code here
        long numOfChars = 0;
        long len = (long) s.length(); //3        
        long repeat = n / len; //10/3 = 3
        long concat = n % len; //10%3 = 1
        int charACount = 0;
        //aba, 10
        for(int i=0; i < s.length(); i++) {
            if('a' == s.charAt(i)) charACount++; 
        } // 2
        //System.out.println("charACount:" + charACount);
        String concatString = s.substring(0, (int) concat); //a
        //System.out.println("concatString:" + concatString);
        
        int concatACount = 0;
        for(int j=0; j < concatString.length(); j++) {
            if('a' == concatString.charAt(j)) concatACount++; 
        } 
        //System.out.println("concatACount:" + concatACount);
        
        numOfChars = concatACount + (repeat * charACount); //1 + (3*2) = 7
        return numOfChars;
        
    }

    public static void main(String[] args) {
        // Example usage
        String s = "aba";
        long n = 10;
        long result = repeatedString(s, n);
        System.out.println(result); // Output should be 7
    }
}
