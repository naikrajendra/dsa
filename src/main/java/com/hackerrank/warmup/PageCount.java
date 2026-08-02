package com.hackerrank.warmup;

/**
 * PageCount
 *
 * This class contains a method to calculate the minimum number of pages
 * to turn in order to reach a specific page in a book.
 * Example: If the book has 6 pages and you want to reach page 5, 
 * you can either turn 2 pages from the front or 1 page from the back. 
 * The minimum number of pages to turn is 1.
 * 
 */

public class PageCount {

    /*
     * Complete the 'pageCount' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER p
     */

    public static int pageCount(int n, int p) {
        
        int pageCount = 0;
        int beginPageCount = p/2;
        int endPageCount = (n / 2) - (p / 2);
        pageCount = Math.min(beginPageCount, endPageCount);
        return pageCount;
    }

    public static void main(String[] args) {
        int n = 6;
        int p = 5;
        System.out.println(pageCount(n, p));
    }

}
