/*
 * Create a class Reverse that consists of one global attribute :
 * In main() take an integer as a user input, and assign each of the digit as an element to an int array. (Assume the size of input is less than 10).
 * Create a method reverse_array() which reverses the given integer (without using the java library functions) and then returns the reversed value as an array.
 * Print the returned value from the function as an int.
 * Topics involved : Array, new, method and objects
 */

import java.util.*;

public class Lab02_Q1 {

    public static int[] reverse_array(int[] arr) {
        int[] rev_array = new int[10];

        for (int i = 0; i < 10; i++) {
            rev_array[i] = arr[9 - i];
        }
        // for (int i = 0; i < rev_array.length; i++)
        // System.out.print(rev_array[i] + " ");
        return rev_array;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // Bulding the array from an integer
        int[] arr = new int[10];
        int present_index = 10 - 1;
        while (n > 0) {
            arr[present_index] = n % 10;
            n /= 10;
            present_index--;
        }

        // for (int i = 0; i < 10; i++)
        // System.out.print(arr[i] + " ");

        int[] reversed_array = reverse_array(arr);

        int last_non_zero_digit = 0;
        for (int i = 0; i < 10; i++) {
            if (reversed_array[i] != 0) {
                last_non_zero_digit = i;
            }
        }

        int ans = 0;
        for (int i = 0; i <= last_non_zero_digit; i++) {
            ans += reversed_array[i];
            if (i != last_non_zero_digit)
                ans *= 10;
        }
        System.out.println(ans);

        sc.close();
    }
}
