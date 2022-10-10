/*
 * Lab 4 - Practice Question
 * You are given a string input which consists of alphabets, numbers, special characters etc. Your task is to extract all the numbers (not digits) from the given string, calculate their sum, and perform the following:
 *
 * Print the binary, octal and hexadecimal equivalents of the sum, in that order.
 *
 * If the sum is even, calculate and print the tan of the sum rounded off to the nearest integer(assuming sum is in radians).
 *
 * If the sum is odd, calculate and print the natural log of the number, rounded up to the nearest integer.
 *
 * Keep in mind that numbers are supposed to be extracted, not individual digits. Two numbers are different if they have a non-digit character between them.
 *
 * See the example below for more clarity.
 *
 * Example:
 *
 * Input: ds23ew2k9
 *
 * Output: 100010 42 22 -1
 *
 * Explaination:
 *
 * For the string "ds23ew2k9", sum will be 23+2+9 = 34 So you have to print the binary, octal and hexadecimal equivalents of the sum.
 *
 * 100010 is the binary equivalent, 42 is the octal equivalent, 22 is the hex equivalent, and -1 is the tan(34) rounded off to the nearest integer.
 */



import java.util.*;


public class Lab04_Practice {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int sum = 0, number = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				number = number * 10 + c - '0';
			} else {
				sum += number;
				number = 0;
			}
		}
		sum += number;
		// System.out.println(sum);
		System.out.println((Integer.toBinaryString(sum)) + '\n' + (Integer.toOctalString(sum)) + '\n' + (Integer.toHexString(sum)));
		if (sum % 2 == 0)
			System.out.println(Math.round(Math.tan(sum)));
		else
			System.out.println(Math.ceil(Math.log(sum)));
		sc.close();
	}
}