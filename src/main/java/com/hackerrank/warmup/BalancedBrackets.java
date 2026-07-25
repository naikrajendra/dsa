package com.hackerrank.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * A bracket is considered to be any one of the following characters: (, ), {,
 * }, [, or ].
 * 
 * Two brackets are considered to be a matched pair if the an opening bracket
 * (i.e., (, [, or {) occurs to the left of a closing bracket (i.e., ), ], or })
 * of the exact same type. There are three types of matched pairs of brackets:
 * [], {}, and ().
 * 
 * A matching pair of brackets is not balanced if the set of brackets it
 * encloses are not matched. For example, {[(])} is not balanced because the
 * contents in between { and } are not balanced. The pair of square brackets
 * encloses a single, unbalanced opening bracket, (, and the pair of parentheses
 * encloses a single, unbalanced closing square bracket, ].
 * 
 * By this logic, we say a sequence of brackets is balanced if the following
 * conditions are met:
 * 
 * It contains no unmatched brackets.
 * The subset of brackets enclosed within the confines of a matched pair of
 * brackets is also a matched pair of brackets.
 * Given strings of brackets, determine whether each sequence of brackets is
 * balanced. If a string is balanced, return YES. Otherwise, return NO.
 * 
 * Function Description
 * 
 * Complete the function isBalanced in the editor below.
 * 
 * isBalanced has the following parameter(s):
 * 
 * string s: a string of brackets
 * Returns
 * 
 * string: either YES or NO
 * Input Format
 * 
 * The first line contains a single integer , the number of strings.
 * Each of the next lines contains a single string , a sequence of brackets.
 * 
 * Constraints
 * 
 * , where is the length of the sequence.
 * All chracters in the sequences ∈ { {, }, (, ), [, ] }.
 * Output Format
 * 
 * For each string, return YES or NO.
 * 
 * Sample Input 1
 * 1
 * {}
 * Sample Output 1
 * YES
 * Sample Input 2
 * 3
 * {[()]}
 * {[(])}
 * {{[[(())]]}}
 * 
 * STDIN Function ----- -------- 3 n = 3 {[()]} first s = '{[()]}' {[(])} second
 * s = '{[(])}' {{[[(())]]}} third s ='{{[[(())]]}}'
 * 
 * Sample Output
 * 
 * YES
 * NO
 * YES
 * Explanation
 * 
 * The string {[()]} meets both criteria for being a balanced string.
 * The string {[(])} is not balanced because the brackets enclosed by the
 * matched pair { and } are not balanced: [(]).
 * The string {{[[(())]]}} meets both criteria for being a balanced string.
 * 
 */

public class BalancedBrackets {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */
    public static String isBalanced(String s) {
        // Use Deque as a Stack implementation (recommended over java.util.Stack)
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If it's an opening bracket, push it onto the stack
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            // If it's a closing bracket, verify it matches the top of the stack
            else {
                // If the stack is empty, we have a closing bracket with no opening pair
                if (stack.isEmpty()) {
                    return "NO";
                }

                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                        (ch == ']' && top != '[') ||
                        (ch == '}' && top != '{')) {
                    return "NO"; // Mismatched brackets
                }
            }
        }

        // If the stack is completely empty, all brackets found their matching halves
        return stack.isEmpty() ? "YES" : "NO";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // Read number of bracket strings
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        for (int i = 0; i < n; i++) {
            String s = bufferedReader.readLine();
            String result = BalancedBrackets.isBalanced(s);
            System.out.println(result);
        }

        bufferedReader.close();
    }

}
