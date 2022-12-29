public class Main {
	public static void main(String[] args) {
		Fraction f1 = new Fraction(1, 2);
		Fraction f2 = new Fraction(6, 9);
		System.out.println(f1.num + "/" + f1.denom);
		System.out.println(f2.num + "/" + f2.denom);
		Fraction f3 = Fraction.add(f1, f2);
	}
}
