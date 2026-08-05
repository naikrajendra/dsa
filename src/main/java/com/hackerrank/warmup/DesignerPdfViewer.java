package com.hackerrank.warmup;

import java.util.HashMap;
import java.util.List;

/**
 * DesignerPdfViewer
 *
 * This class contains a method to determine the size of the highlighted area
 * for a given word in the Designer PDF Viewer.
 */

public class DesignerPdfViewer {
    /*
     * Complete the 'designerPdfViewer' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h
     *  2. STRING word
     */

    public static int designerPdfViewer(List<Integer> h, String word) {
    // Write your code here
        //create a return variable
        //create a HashMap where key is letter and value is from provided list h
        //{a,1}, {b,3}
        //for loop for word
        //for each word find its value from hashmap
        // Math.max(height of tallest letter)
        //loop ends
        //size of highlighted area = maxHeightLetter x word.length
        //return variable
        
        int size = 0;
        char[] englishChars = new char[52];
        int index = 0;
        // Populate lowercase letters (a-z)
        for (char c = 'a'; c <= 'z'; c++) {
            englishChars[index++] = c;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i < h.size(); i++) {
            map.putIfAbsent(englishChars[i], h.get(i));
        }
        
        int maxHeight = 0;
        for(int a=0; a < word.length(); a++) {
            char c = word.charAt(a);
            if(map.containsKey(c)) {
                maxHeight = Math.max(maxHeight, map.get(c));
            }
        }
        size = maxHeight * word.length();
        return size;
    }

    public static void main(String[] args) {
        List<Integer> h = List.of(1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 1, 2, 1, 3, 1, 4, 1, 2, 1, 3, 1, 4, 1, 2, 1, 3);
        String word = "abc";
        int result = designerPdfViewer(h, word);
        System.out.println(result); // Expected output: size of highlighted area
    }

}
