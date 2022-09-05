import java.util.*;

public class Lab01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("n = ");
		int n = sc.nextInt();
		System.out.println("Pattern 1: ");
		pattern1(n);
		System.out.println();
		System.out.println("Pattern 2: ");
		// pattern2(n);
		sc.close();
	}

	public static void pattern1(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < (n - i); j++)
				System.out.print(" ");
			for (int j = 0; j < i; j++)
				System.out.print("*");
			System.out.println();
		}
	}

	public static void pattern2(int n) {
		// TODO
	}
}
