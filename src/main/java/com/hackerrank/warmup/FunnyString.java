package com.hackerrank.warmup;

public class FunnyString {

    public static String funnyString(String s) {
        String r = new StringBuilder(s).reverse().toString();
        for (int i = 1; i < s.length(); i++) {
            int diffOriginal = Math.abs(s.charAt(i) - s.charAt(i - 1));
            int diffReverse = Math.abs(r.charAt(i) - r.charAt(i - 1));
            if (diffOriginal != diffReverse) {
                return "Not Funny";
            }
        }
        return "Funny";
    }

    public static void main(String[] args) {
        System.out.println(funnyString("acxz"));
        System.out.println(funnyString("bcxz"));
    }

}
