package com.hackerrank.warmup;

public class TaumBday {

    public static long taumBday(long b, long w, long bc, long wc, long z) {
        long costBlack = Math.min(bc, wc + z);
        long costWhite = Math.min(wc, bc + z);
        return b * costBlack + w * costWhite;
    }

    public static void main(String[] args) {    
        long b = 10;
        long w = 5;
        long bc = 1;
        long wc = 2;
        long z = 1;
        long result = taumBday(b, w, bc, wc, z);
        System.out.println("Minimum Cost: " + result);
    }
}
