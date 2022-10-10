/*
 * Lab 3 - Question 2:
 *
 * Chandler has 2 friends “joey” and “Dhamo”. There is a string given and she wants to know if that string is good or bad.
 *
 * A string is good if and only if it contains one of Chandler's friends' name exactly once.
 *
 * Note: The problem is case-sensitive.
 *
 * Input:
 *
 * The only line contains string from lowercase and uppercase letters.
 *
 * Output:
 *
 * Print "Good", if the string is good, and "Bad" otherwise.
 *
 * Hint:
 *
 * For string input, You can use scanner class
 *
 * Scanner sc = new Scanner(System.in);
 *
 * String s = sc.next();
 */



import java.util.*;

public class Lab03_Q2 {

	public static int countSubstring(String str, String findStr) {
		return (str.split(findStr, -1).length - 1); // -1 is to ensure that answer is correct even when `str` ends with
													// `findStr`
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String frnd1 = "joey", frnd2 = "Dhamo";
		String s = sc.next();
		if ((countSubstring(s, frnd1) == 0 && countSubstring(s, frnd2) == 1)
				|| (countSubstring(s, frnd1) == 1 && countSubstring(s, frnd2) == 0))
			System.out.println("Good");
		else
			System.out.println("Bad");
		sc.close();
	}
}