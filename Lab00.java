import java.util.*;

public class Lab00 {
	public static void pattern(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = i; j <= n; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		for (int i = (n - 1); i >= 1; i--) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = i; j <= n; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("n = ");
		pattern(sc.nextInt());
		sc.close();
	}
}
