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
 * Explanation: Note that there are two elements that appear two times, 1 and 2.The smallest window for 1 is whole array and smallest window for 2 is {2, 2}. Since window for 2 is smaller, this is our output.
 *
 * Example 2:
 * Input
 *
 * n= 7
 * A[]=[1,2,1,2,1,2,3]
 *
 * Output [1,2,1,2,1]
 *
 * Explanation:
 *
 * Note that there are 2 elements that appear thrice, 1 and 2 and the window
 * Size for both the numbers are also 5, but because the window [1,2,1,2,1] appears before [2,1,2,1,2] the output is [1,2,1,2,1]
 */

import java.util.*;

public class Lab11_Q2 {
    public static void smallestSubsegment(int a[], int n) {
        HashMap<Integer, Integer> left = new HashMap<>();
        HashMap<Integer, Integer> count = new HashMap<>(); // Store frequency of each element

        int max_count = 0; // Store maximum frequency
        int min = -1, str_index = -1; // Store length and starting index of smallest result window

        for (int i = 0; i < n; i++) {
            int current_element = a[i];

            if (!count.containsKey(current_element)) { // First time we are seeing this element
                left.put(current_element, i);
                count.put(current_element, 1);
            } else
                count.put(current_element, count.get(current_element) + 1);

            // Find maximum repeating element and store its first and last occurrence
            int current_element_count = count.get(current_element);
            if (current_element_count > max_count) {
                max_count = count.get(current_element);
                min = i - left.get(current_element) + 1; // Smallest length of subsegment
                str_index = left.get(current_element);
            } else if ((current_element_count == max_count) && (i - left.get(current_element) + 1 < min)) {
                min = i - left.get(current_element) + 1;
                str_index = left.get(current_element);
            }
        }

        // Print smallest subsegment with all occurrences of most frequent element
        // System.out.println(str_index + " " + min);
        for (int i = str_index; i < (str_index + min); i++) {
            System.out.print(a[i] + " ");
            // System.out.print("Inside loop");
        }
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
