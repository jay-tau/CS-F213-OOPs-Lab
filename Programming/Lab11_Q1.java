/*
 * Problem Description
 * Given a string A denoting a stream of lowercase alphabets, you have to make a new string B. B is formed such that we have to find the first non-repeating character each time a character is inserted to the stream and append it at the end to B. If no non-repeating character is found, append '#' at the end of B.
 *
 * Example Input:
 *
 * Input:
 * A = abadbc
 * Output:
 * aabbdd
 *
 * Explanation:
 *
 * "a" - first non repeating character 'a'
 * "ab" - first non repeating character 'a'
 * "aba" - first non repeating character 'b'
 * "abad" - first non repeating character 'b'
 * "abadb" - first non repeating character 'd'
 * "abadbc" - first non repeating character 'd'
 *
 * Input:
 * A = abcabc
 * Output:
 * aaabc#
 *
 * Explanation:
 *
 * "a" - first non repeating character 'a'
 * "ab" - first non repeating character 'a'
 * "abc" - first non repeating character 'a'
 * "abca" - first non repeating character 'b'
 * "abcab" - first non repeating character 'c'
 * "abcabc" - no non repeating character so '#'
 */

import java.util.*;
import java.util.Queue;

public class Lab11_Q1 {

    public static void solve(String A) {
        Queue<Character> qu = new LinkedList<>();
        HashMap<Character, Integer> letter_count = new HashMap<>();
        String B = "";
        for (int i = 0; i < A.length(); i++) {
            char current_char = A.charAt(i);
            qu.add(current_char);
            if (letter_count.containsKey(current_char))
                letter_count.put(current_char, (letter_count.get(current_char) + 1));
            else
                letter_count.put(current_char, 1);
            while (!qu.isEmpty() && letter_count.get(qu.peek()) > 1) { // Remove from queue till we find a character
                                                                       // with a count of 1
                qu.poll();
            }
            if (qu.isEmpty()) // No character with count 1
                B += "#";
            else
                B += (qu.peek()); // Add first character with count 1
        }
        System.out.println(B);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.nextLine();
        solve(A);
        sc.close();
    }
}