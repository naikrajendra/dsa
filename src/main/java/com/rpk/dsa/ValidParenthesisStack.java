package com.rpk.dsa;

/**
 * A class to check if the parentheses in a string are valid.   
 * A string is considered valid if:
 * 1. Open brackets must be closed by the same type of brackets.    
 * 2. Open brackets must be closed in the correct order.
 * 
 * ValidParenthesisStack
 */

public class ValidParenthesisStack {

    public static void main(String[] args) {
        String s = "({[]})";

        if (isValid(s)) {
            System.out.println("The parentheses are valid.");
        } else {
            System.out.println("The parentheses are not valid.");
        }
    }

    public static boolean isValid(String s) {
        java.util.Stack<Character> stack = new java.util.Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
