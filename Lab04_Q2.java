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
