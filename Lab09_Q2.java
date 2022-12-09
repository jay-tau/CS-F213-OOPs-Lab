/*
 * You are given an array of integers arr, there is a sliding window of size k which is moving from left to right.
 * There is a window present with k integers in it.
 * Return the array of maximum sliding window.
 *
 * Input:
 * nums = [1,3,3,6,-5,3,-6,7], k = 4
 *
 * Output:
 * [6,6,6,6,7]
 *
 * Explanation:
 * Window position          	Max
 * ----------------------- -----
 * [1,3,3,6],-5,3,-6,7		    6
 * 1,[3,3,6,-5],3,-6,7		    6
 * 1,3,[3,6,-5,3],-6,7		    6
 * 1,3,3,[6,-5,3,-6],7		    6
 * 1,3,3,6,[-5,3,-6,7]		    7
 */

import java.util.*;

public class Lab09_Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        for (int i = 0; i <= (arr.length - k); i++) {
            int max = arr[i];
            for (int j = i + 1; j < (i + k); j++) {
                try {
                    max = Math.max(max, arr[j]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    break;
                }
            }

            System.out.print(max + " ");
        }

        sc.close();
    }
}
