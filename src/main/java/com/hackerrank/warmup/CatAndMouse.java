package com.hackerrank.warmup;

/**
 * CatAndMouse
 *
 * This class contains a method to determine which cat will catch the mouse first,
 * or if the mouse escapes when both cats are equidistant from it.
 */


public class CatAndMouse {

    static String catAndMouse(int x, int y, int z) {
        String catMouse = "";
        //Find the distance between Cat A and Mouse C
        //Find the distance between Cat B and Mouse C
        //if distance Cat A == cat B is equal print Mouse C
        //if Cat A is greater than Cat B, print CAT B
        //else print Cat B
        //2
        //1
        //3
        int catADistance = Math.abs(z - x);
        int catBDistance = Math.abs(z - y);
        if(catADistance == catBDistance) catMouse = "Mouse C";
        else if(catADistance > catBDistance) catMouse = "Cat B";
        else catMouse = "Cat A";
        
        return catMouse;
    }

    public static void main(String[] args) {
        int x = 1;
        int y = 2;
        int z = 3;
        System.out.println(catAndMouse(x, y, z));
    }

}
