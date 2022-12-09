/*
 * Your task in this question is to find if the input string is valid or not. A string will be valid only if
 *
 * 1. It’s Parenthesis is balances (i.e. (()) and (){[]} are balanced while ([) is not balanced.
 * 2. There can be three types of brackets implemented in the string i.e. ‘[‘ ,’]’, ’(‘, ’)’, ’{‘, ’}’.
 * 3. The strings can also have letters input in it and for letters we will see that the last letter to the left of the current element is the same letter. This means that ‘aba’ is not a valid string while ‘abba’ is a valid string.
 * 4. Strings can be combination of all these steps, i.e. [([yash])] can be an input string.
 *
 * Explanation of 3rd Point:
 * There is only at most one string present in each test case and you have to check if the string is even palindrome or not.
 * That is why aba is not valid in spite of being palindrome while abba is valid.
 *
 * Constraints:
 * Only letters and brackets allowed in a string.
 * Size of the string should be greater than or equal to 1.
 *
 * The program should give true for all the valid strings while should give false for all the invalid strings.
 */

import java.util.*;

class Answer {
    public boolean validstring(String s) {
        Stack<Character> st = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {

            char current_char = s.charAt(i);
            if (st.isEmpty()) {
                if (current_char == ')' || current_char == ']' || current_char == '}')
                    return false;
                else
                    st.push(current_char);
            } else {
                char top = st.peek();
                if ((top == '(' && current_char == ')') || (top == '[' && current_char == ']')
                        || (top == '{' && current_char == '}'))
                    st.pop();
                else if ((top == current_char) && Character.isAlphabetic(current_char)) // For letters
                    st.pop();
                else
                    st.push(current_char);
            }
        }

        return st.isEmpty();
    }
}

public class Lab09_Q1 {
    public static void main(String[] args) {
        String s;
        Scanner sc = new Scanner(System.in);
        s = sc.next();
        Answer ans = new Answer();
        System.out.println(ans.validstring(s));
        sc.close();
    }
}
