/*
 * Basic pattern printing
 * Write a program to print the given pattern in JAVA for any given n
 *
 * Modify the code as indicated to get the output pattern
 *
 * Pattern for n = 3
 * 1 2 3
 *  2 3
 *   3
 *  2 3
 * 1 2 3
 */

import java.util.*;

public class Lab00 {
	public static void pattern(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = i; j <= n; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		for (int i = (n - 1); i >= 1; i--) {
			for (int j = 1; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = i; j <= n; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		pattern(sc.nextInt());
		sc.close();
	}
}
