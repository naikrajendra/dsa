package com.rpk.dsa;

/**
 * A class to check if the parentheses in a string are valid.   
 * A string is considered valid if:
 * 1. Open brackets must be closed by the same type of brackets.    
 * 2. Open brackets must be closed in the correct order.
 * 
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.An input string is valid if:Opening brackets 
 * must be closed by the same type of brackets.Opening brackets must be closed in the 
 * correct order.Every close bracket has a corresponding open bracket of the same type.
 * Examples
 * Example 1:Input: s = "()"Output: true
 * Example 2:Input: s = "()[]{}"Output: true
 * Example 3:Input: s = "(]"Output: false
 * Example 4:Input: s = "([)]"Output: false
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
