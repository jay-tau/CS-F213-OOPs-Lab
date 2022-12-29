/*
 * A palindrome is a sequence that reads the same backward as forward. Complete the Java program given that takes a non-negative integer as input and checks whether the given number is a palindrome. It will Print “YES” if the given number is a palindrome, and print “NO” in all other cases. (Do not use any java Library functions)
 */

package Lab01;

import java.util.*;

public class Lab01_Practice {

	public static boolean palindromeWithArray(int n) {
		int[] a = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
		// Initialize the array with digits of n
		int free_index = 0;
		while (n > 0) {
			int digit = n % 10;
			n /= 10;
			// Find the first empty slot in the array
			while (a[free_index] != -1) {
				free_index++;
			}
			a[free_index] = digit;
		}
		// System.out.println(free_index);
		// System.out.println(Arrays.toString(a));
		for (int i = 0; i <= ((free_index - 1)/2); i++) {
			if (a[i] != a[free_index - i]) {
				// System.out.println(a[i] + " " + a[free_index - 1 - i]);
				return false;
			}
		}
		return true;
	}

	public static boolean palindromeWithoutArray(int n) {
		int rev = 0;
		int n_copy = n;
		while (n_copy > 0) {
			int digit = n_copy % 10;
			n_copy /= 10;
			rev *= 10; rev += digit;
		}
		// System.out.println(rev);
		return (rev == n);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// System.out.print("Enter a number: ");
		int n = in.nextInt();
		// System.out.println(palindromeWithArray(n));
		// System.out.println(palindromeWithoutArray(n));

		if (palindromeWithArray(n) && palindromeWithoutArray(n))
			System.out.println("YES");
		else
			System.out.println("NO");

		in.close();
	}
}