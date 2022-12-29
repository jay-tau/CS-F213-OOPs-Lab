/*
 * Write a program to check whether a given number (n-digit number) is armstrong or not. Print YES if it is an armstrong number and NO if it is not an armstrng number.
 * Definition: An Armstrong number is an integer such that the sum of its digits raise to the power of n is equal to the number itself.
 * For Example: For example for a 3 digit number, 371 is an Armstrong number since 3^3 + 7^3 + 1^3 = 371
 */

package Lab01;

import java.util.*;

public class Lab01_Armstrong {

	public static int numberOfDigits(int n) {
		int numDigits = 0;
		if (n == 0)
			numDigits = 1;
		while (n > 0) {
			numDigits++;
			n /= 10;
		}
		return numDigits;
	}

	public static boolean armstrongNumber(int n) {
		int nCopy = n;
		int sumOfCubes = 0;
		int numDigits = numberOfDigits(n);
		while (nCopy > 0) {
			int digit = nCopy % 10;
			nCopy /= 10;
			int prod = 1;
			for (int i = 0; i < numDigits; i++) {
				prod *= digit;
			}
			sumOfCubes += prod;
		}
		return ((sumOfCubes == n) ? true : false);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// System.out.println(armstrongNumber(sc.nextInt()));
		if (armstrongNumber(sc.nextInt()))
			System.out.println("YES");
		else
			System.out.println("NO");

		// System.out.println(numberOfDigits(sc.nextInt()));
		sc.close();
	}
}