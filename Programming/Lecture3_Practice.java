import java.util.*;

public class Lecture3_Practice {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] splitStr = str.trim().split(" ");
		for (int i = 0; i < splitStr.length; i++)
			System.out.print(splitStr[i] + ' ');
		System.out.println();
		sc.close();
	}
}
