/*
 * Lab 4 - Question 2
 * Integers are stored as a 32-bit value in java.
 *
 * Let the bits be numbered from 1 to 32, where bit 1 is the least significant bit, and bit 32 is the most significant bit.
 *
 * Take two integers n and b (2 <= b <= 16) as input, where n is the number and b is the base nned to be used for the output. Perform the following operations:
 *
 * Find the most significant set bit of the number (i. e. The first bit from the left which is 1). Let the bit number be i, Left rotate n by ⌊i / 4⌋ times, where ⌊x⌋ denotes the floor value of x.
 *
 * Print the resulting number in base b.
 *
 * Perform the operations as far as possible using the methods available in the wrapper classes of primitive data types of Java.
 *
 * Example:
 *
 * Input:
 *
 * 512 16
 *
 * Output:
 *
 * 800
 *
 * Explanation:
 *
 * The binary representation of 512 is 1000000000. The most significant bit which is 1 is the bit number 10.
 *
 * So we left shift 512 by ⌊10 / 4⌋ = 2 times. That would get us 2048, which in base 16 is 800 so the output should be 800.
 */



import java.util.Scanner;

public class Lab04_Q2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), b = sc.nextInt();
		int i = (int) (Math.log(Integer.highestOneBit(n)) / Math.log(2));
		i++; // Makes the integer's positions 1-indexed, instead of 0-indexed
		// System.out.println("i: " + i);
		n = Integer.rotateLeft(n, ((int) Math.floor(i / 4.0)));
		// System.out.println("rotated_left (int): " + n);

		// Changing the base
		String rev_ans = "";
		while (n > 0) {
			int digit = (n % b);
			switch (digit) {
				case 15:
					rev_ans += "f";
					break;
				case 14:
					rev_ans += "e";
					break;
				case 13:
					rev_ans += "d";
					break;
				case 12:
					rev_ans += "c";
					break;
				case 11:
					rev_ans += "b";
					break;
				case 10:
					rev_ans += "a";
					break;
				default:
					rev_ans += digit;
			}
			n /= b;
		}
		String ans = "";
		// Reversing rev_ans
		for (int j = (rev_ans.length() - 1); j >= 0; j--) {
			ans += rev_ans.charAt(j);
		}
		System.out.println(ans);
		sc.close();
	}
}
