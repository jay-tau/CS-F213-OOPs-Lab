/*
 * There is a road of length n, and there are some chocolates lying on the road each chocolate has some type which is given in the form of integer array.
 * Let X be a type of chocolate which has the maximum frequency.
 * The objective is to identify the roads smallest subsegment that likewise has X as the highest frequency element.
 *
 * Note: Print the sub segment that appears first in the array if two or more subsegments have the same frequency (i.e., maximum frequency) and same sub segment size.
 *
 * Example1:
 *
 * Input
 * n= 5
 * A[] = {1, 2, 2, 3, 1}
 * Output [2,2]
 *
 * Explaination: Note that there are two elements that appear two times, 1 and 2.The smallest window for 1 is whole array and smallest window for 2 is {2, 2}. Since window for 2 is smaller, this is our output.
 *
 * Example 2:
 * Input
 *
 * n= 7
 * A[]=[1,2,1,2,1,2,3]
 *
 * Output [1,2,1,2,1]
 *
 * Explaination:
 *
 * Note that there are 2 elements that appear thrice, 1 and 2 and the window
 * Size for both the numbers are also 5, but because the window [1,2,1,2,1] appears before [2,1,2,1,2] the output is [1,2,1,2,1]
 */

import java.util.*;

public class Lab11_Q2 {
    public static void smallestSubsegment(int a[], int n) {

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        smallestSubsegment(a, n);

        sc.close();
    }
}
