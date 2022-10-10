/*
 * Lab 5 - Question 2
 * You are given n pairs of integers(x, y). Each pair is modelled as a Pair class.
 *
 * Your task is to implement the 2 methods:
 *
 * private static int solveUnique(Object[] pairs)
 * private static int solveSimilar(Object[] pairs)
 * solveUnique() method creates the largest possible subsequence arr such that every element in this array is unique and returns the length of the array
 *
 * solveSimilar() method creates the largest possible susequence arr such that the score of any 2 elements in the array is the same and and returns the length of the array.
 *
 * An element in an array is said to be unique for all elements in the array if their corresponding (x, y) values are not equal.
 *
 * The score of a Pair (x, y) is defined as:
 *
 * Ceil( (100 * (sin(x) + tanh(y) ) ) ) % 10
 * NOTE: Only code in the sections mentioned in the starter code. DO NOT code anywhere else
 *
 * INPUT FORMAT: The first line contains a single integer ‘n’ denoting the number of pairs
 *
 * ‘n’ lines follow
 *
 * Each of the next ‘n’ lines contains 2 space-separated integers denoting the (x, y) values of the ‘Pair’ object.
 *
 * OUTPUT FORMAT:
 * The output consists of 2 lines, each containing a single integer value.
 * The first line contains the output of the ‘solveUnique’ function.
 * The second line contains the output of the ‘solveSimilar’ function.
 *
 * EXAMPLE:
 *
 * INPUTS
 * 3           # (n=3)
 * 0 0         # (x=0, y=0 for pair 1)
 * 1 1         # (x=1, y=1 for pair 2)
 * 0 0         # (x=0, y=0 for pair 3)
 *
 * OUTPUTS:
 * 2
 * 2
 *
 * OUTPUT EXPLANATION:
 * The largest possible subsequence of pairs is Pair1(0, 0) and Pair2(1, 1)
 * Hence the output of solveUnique is 2
 * The Score of Pair1 = 0
 * The Score of Pair2 = 1
 * The Score of Pair3 = 0
 * Hence the output of solveSimilar is 2
 */

import java.util.Scanner;

class Pair {
	private int x;
	private int y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// ******** START OF YOUR CODE ********
	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
	// ******** END OF YOUR CODE ********
}

public class Lab05_Q2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		Object[] arr = new Object[n];

		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[i] = new Pair(x, y);
		}

		sc.close();

		int result_unique = solveUnique(arr);
		int result_similar = solveSimilar(arr);

		System.out.println(result_unique);
		System.out.println(result_similar);
	}

	private static int solveUnique(Object[] pairs) {
		// ******** START OF YOUR CODE ********
		Pair[] pairs_new = new Pair[pairs.length];
		for (int i = 0; i < pairs.length; i++) {
			pairs_new[i] = (Pair) pairs[i];
		}
		int unique_count = 0;
		for (int i = 0; i < pairs.length; i++) {
			Pair current_pair = pairs_new[i];
			boolean already_counted = false;
			for (int j = 0; j < i; j++) {
				Pair previous_pair = pairs_new[j];
				if (current_pair.getX() == previous_pair.getX() && current_pair.getY() == previous_pair.getY()) {
					already_counted = true;
					break;
				}
			}
			if (!already_counted)
				unique_count++;
		}
		return unique_count;
		// ******** END OF YOUR CODE ********
	}

	private static int solveSimilar(Object[] pairs) {
		// ******** START OF YOUR CODE ********
		double[] scores = new double[pairs.length];
		for (int i = 0; i < pairs.length; i++) {
			Pair p = (Pair) pairs[i];
			scores[i] = Math.ceil((100 * (Math.sin(p.getX()) + Math.tanh(p.getY())))) % 10;
		}
		int max_count = 0;
		for (int i = 0; i < scores.length; i++) {
			int count = 0;
			for (int j = 0; j < scores.length; j++) {
				if (scores[i] == scores[j]) {
					count++;
				}
			}
			if (count > max_count) {
				max_count = count;
			}
		}
		return max_count;
		// ******** END OF YOUR CODE ********
	}

}