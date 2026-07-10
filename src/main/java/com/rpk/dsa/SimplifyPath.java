package com.rpk.dsa;

import java.util.Stack;


/**
 * This code implements a method to simplify a given Unix-style file path. 
 * The `simplifyPath` method takes a string representing the path as input and 
 * returns the simplified canonical path. The algorithm processes the
 * path by splitting it into components, handling special cases such 
 * as "." (current directory) and ".." (parent directory), and using a 
 * stack to build the final simplified path. The resulting path is constructed 
 * by joining the valid directory names with slashes. The method ensures that 
 * the output is in the correct format, starting with a single slash and not 
 * ending with a trailing slash unless it is the root directory.
 * 
 */

public class SimplifyPath {

    public String simplifyPath(String path) {
        String[] components = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String component : components) {
            if (component.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!component.isEmpty() && !component.equals(".")) {
                stack.push(component);
            }
        }

        StringBuilder simplifiedPath = new StringBuilder();
        for (String dir : stack) {
            simplifiedPath.append("/").append(dir);
        }

        return simplifiedPath.length() > 0 ? simplifiedPath.toString() : "/";
    }

    //main method to test the simplifyPath function
    public static void main(String[] args) {
        SimplifyPath sp = new SimplifyPath();
        String path = "/a/./b/../../c/";
        String simplified = sp.simplifyPath(path);
        System.out.println("Simplified Path: " + simplified); // Output: "/c"
    }

    
}
