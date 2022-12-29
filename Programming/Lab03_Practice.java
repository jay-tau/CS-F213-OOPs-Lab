/*
 * Given a string, find the first repeated character in it. Print the character that occurs more than once and whose index of the second occurrence is the smallest. The string contains only lowercase English alphabets. If the whole string is unique then print -1.
 * Hint: Try to make an array of size 26 where each array element refers to an alphabet.
 * For example: 0th index refers to a, 1st to b, and so on till z. The lower-case alphabets narrow down your range of characters available in the string.
 *
 * Ex:
 * abba, then here the b at index 2 is the first repeating element, hence it is the answer is b
 *
 * Hint
 * For string input, You can use scanner class -
 * Scanner sc = new Scanner(System.in);
 * String s = sc.next();
 */

import java.util.*;

public class Lab03_Practice {

	public static String returnFirstRepeatedCharacter(String s) {
		int[] char_count = new int[26]; // All values are initialised to 0 by default
		for (int i = 0; i < s.length(); i++) {
			char_count[s.charAt(i) - 'a']++;

			if (char_count[s.charAt(i) - 'a'] > 1)
				return ("" + s.charAt(i));
		}
		return "-1";
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();

		System.out.println(returnFirstRepeatedCharacter(s));

		sc.close();
	}
}
