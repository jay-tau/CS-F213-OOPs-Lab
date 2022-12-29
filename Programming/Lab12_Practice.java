/*
 * Create a class with a generic method which gives the maximum of the 3 elements provided to it. For char or strings it must give the Alphabetically higher value.
 *
 * Example
 * Input
 * 1 2 3
 * Output
 * 3
 */

import java.util.*;

public class Lab12_Practice {
    // determines the largest of three Comparable objects

    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x; // assume x is initially the largest

        if (y.compareTo(max) > 0) {
            max = y; // y is the largest so far
        }

        if (z.compareTo(max) > 0) {
            max = z; // z is the largest
        }

        return max; // returns the largest object
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String type = sc.next();
        if (type.equals("Integer")) {
            List<Integer> arr = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                arr.add(sc.nextInt());
            }
            System.out.println(maximum(arr.get(0), arr.get(1), arr.get(2)));
        } else if (type.equals("String")) {
            List<String> arr = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                arr.add(sc.next());
            }

            System.out.println(maximum(arr.get(0), arr.get(1), arr.get(2)));
        } else if (type.equals("Float")) {
            List<Float> arr = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                arr.add(sc.nextFloat());
            }
            System.out.println(maximum(arr.get(0), arr.get(1), arr.get(2)));
        } else if (type.equals("Character")) {
            List<Character> arr = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                arr.add(sc.next().charAt(0));
            }

            System.out.println(maximum(arr.get(0), arr.get(1), arr.get(2)));
        }
        sc.close();

    }
}
