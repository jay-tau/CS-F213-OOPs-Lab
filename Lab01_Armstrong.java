import java.util.*;

public class Lab01_Armstrong {

	public static int numberOfDigits(int n) {
		int numDigits = 0;
		if (n == 0)
			numDigits = 1;
		while (n > 0) {
			numDigits++;
			n /= 10;
		}
		return numDigits;
	}

	public static boolean armstrongNumber(int n) {
		int nCopy = n;
		int sumOfCubes = 0;
		int numDigits = numberOfDigits(n);
		while (nCopy > 0) {
			int digit = nCopy % 10;
			nCopy /= 10;
			int prod = 1;
			for (int i = 0; i < numDigits; i++) {
				prod *= digit;
			}
			sumOfCubes += prod;
		}
		return ((sumOfCubes == n) ? true : false);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// System.out.println(armstrongNumber(sc.nextInt()));
		if (armstrongNumber(sc.nextInt()))
			System.out.println("YES");
		else
			System.out.println("NO");

		// System.out.println(numberOfDigits(sc.nextInt()));
		sc.close();
	}
}