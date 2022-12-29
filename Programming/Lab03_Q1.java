/*
 * Lab 3 - Question 1:
 *
 * There is a string of size n containing only lowercase English alphabets and there is an array of size n which contains points for each character present in string.
 *
 * Your task is to delete characters from the string following the given instruction:
 *
 * Delete exactly one occurrence of every character present in the string and update the array.
 *
 * Note: Here deletion means updating the value of that character in array as 0.
 *
 * For example:
 *
 * String: aabba and array is [1,2,3,4,5] so frequency of character “a” = 3 and frequency of character “b” = 2, let’s say you deleted 4th index i.e. “a” and 3rd index i.e “b” which results in frequency of character “a” =2 and frequency of character “b” =1 and updated array is [1,2,3,0,0].
 *
 * Your goal is to delete the characters according to the instruction given above in a manner that after all deletions, the sum of the array would be minimum.
 *
 * Input:
 *
 * The first line is the value n (size of the string and array).
 *
 * The second line contains the string
 *
 * The third line contains n integers a1,a2,a3 ….an - the array that contain points
 *
 * Output:
 *
 * A single integer that has the minimum value of sum of points after deleting one occurrence of each present character
 *
 * Sample Input
 *
 * 5
 *
 * aabba
 *
 * 1 2 3 4 5
 *
 * Sample Output:
 *
 * 6
 *
 * Explanation: the "b" at index 3 is deleted and "a" at index 4 is deleted so 1 + 2 + 3 = 6
 *
 * Hint:
 *
 * For string input, You can use scanner class:
 *
 * Scanner sc = new Scanner(System.in);
 *
 * String s = sc.next();
 */

import java.util.*;

public class Lab03_Q1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = sc.next();
		int[] a = new int[n];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			sum += a[i];
		}
		for (char c = 'a'; c <= 'z'; c++) {
			int max_points = 0;
			for (int i = 0; i < n; i++)
				if (a[i] > max_points && s.charAt(i) == c)
					max_points = a[i];
			sum -= max_points;
		}
		System.out.println(sum);
		sc.close();
	}
}