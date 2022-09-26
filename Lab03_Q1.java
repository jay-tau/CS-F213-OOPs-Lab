import java.util.*;

public class Lab03_Q1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = sc.next();
		int[] a = new int[n];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			sum += a[i];
		}
		for (char c = 'a'; c <= 'z'; c++) {
			int max_points = 0;
			for (int i = 0; i < n; i++)
				if (a[i] > max_points && s.charAt(i) == c)
					max_points = a[i];
			sum -= max_points;
		}
		System.out.println(sum);
		sc.close();
	}
}