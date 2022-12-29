/*
 * Given an array, find the largest and second largest element in the array without sorting the array. Assume that all the elements are positive int. (Do not use any java Library functions)
 */

package Lab01;

import java.util.Scanner;

public class Lab01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Input size of array: ");
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		// System.out.println(Arrays.toString(a));
		// Find largest number
		int maxIndex = 0, largestNum = 0;
		for (int i = 0; i < n; i++) {
			int currentElement = a[i];
			if (currentElement > largestNum) {
				largestNum = currentElement;
				maxIndex = i;
			}
		}
		if (n != 0)
			a[maxIndex] = -1; // Removes maxElement
		int secondNum = 0;
		// Find 2nd largest number
		for (int i = 0; i < n; i++) {
			int currentElement = a[i];
			if (currentElement > secondNum) {
				secondNum = currentElement;
			}
		}
		System.out.println(largestNum + "," + secondNum);
		sc.close();
	}
}