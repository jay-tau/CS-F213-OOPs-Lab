import java.util.*;


public class Lab04_Practice {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int sum = 0, number = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				number = number * 10 + c - '0';
			} else {
				sum += number;
				number = 0;
			}
		}
		sum += number;
		// System.out.println(sum);
		System.out.println((Integer.toBinaryString(sum)) + '\n' + (Integer.toOctalString(sum)) + '\n' + (Integer.toHexString(sum)));
		if (sum % 2 == 0)
			System.out.println(Math.round(Math.tan(sum)));
		else
			System.out.println(Math.ceil(Math.log(sum)));
		sc.close();
	}
}