package com.hackerrank.warmup;

import java.util.List;

/**
 * BonAppetit class provides a method to determine if Anna was charged correctly 
 * for her share of the bill.
 * 
 * BonAppetit
 */

public class BonAppetit {

    public static void bonAppetit(List<Integer> bill, int k, int b) {
    // Write your code here
    // 
    // loop through bill
    // if billitem = k, then dont add to billSumActual
    // else add to billSumActual
    // after loop is complete, find Anna's share by billSumActual / 2
    // compare Anna's share with b
    // if it is equal --> print Bon Appetit
    // else print difference
        int billSumActual = 0;
        //3,10,2,9 
        //1
        for(int i=0; i < bill.size(); i++) {
            int billItemAmount = bill.get(i); //3,10,2,9
            if( i != k) { //exclude kth billItem 0,1 1,1 2,1 3,1
                billSumActual += billItemAmount; //3 5 14
            }
        }
        int Annasshare = billSumActual / 2; //7,12
        if( b == Annasshare) System.out.println("Bon Appetit");
        else System.out.println(b-Annasshare); //12-7=5

    }

    public static void main(String[] args) {
        List<Integer> bill = List.of(3, 10, 2, 9);
        int k = 1;
        int b = 12;
        bonAppetit(bill, k, b);
    }
}
