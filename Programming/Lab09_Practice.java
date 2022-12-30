/*
 * Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses substring (A substring is a contiguous non-empty sequence of characters within a string).
 *
 * (Hint: Use Collections to solve this problem)
 *
 * Sample Test Cases:
 *
 * Test Case 1:
 *
 * Input
 * “)()())”
 *
 * Output:
 * 4
 *
 * Test Case 2:
 * Input
 * “((()))”
 *
 * Output
 * 6
 */

import java.util.*;
import java.util.Stack;

public class Lab09_Practice {
    public static int solve(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int max_len = 0;
        for (int i = 0; i < s.length(); i++) {
            char current_char = s.charAt(i);
            if (current_char == '(') {
                st.push(i);
            } else {
                st.pop();
                if (st.empty()) {
                    st.push(i);
                } else {
                    max_len = Math.max(max_len, i - st.peek());
                }
            }
        }
        return max_len;
    }

    public static void main(String[] args) {
        String s;
        Scanner sc = new Scanner(System.in);
        s = sc.next();
        System.out.println(solve(s));
        sc.close();
    }
}
