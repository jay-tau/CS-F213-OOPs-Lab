public class Fraction {
	int num, denom;

	public Fraction(int p, int q) {
		num = p;
		denom = q;
		this.reduce();
	}

	public static int gcd(int a, int b) {
		while (a != b) {
			if (a > b)
				a = a - b;
			else
				b = b - a;
		}
		return a;
	}

	public Fraction reduce() {
		int gcd = gcd(num, denom);
		this.num /= gcd; this.denom /= gcd;
		return this;
	}

	public Fraction invert(Fraction a) {
		if (a.num == 0) {
			System.out.println("Error: Cannot invert 0");
			return null;
		}
		int temp = a.num;
		a.num = a.denom;
		a.denom = temp;
		return a;
	}

	public static Fraction add(Fraction a, Fraction b) {
		return ((new Fraction((a.num * b.denom + b.num * a.denom), (a.denom * b.denom))).reduce());
	}

	public static Fraction add(Fraction a, int n) {
		return add(a, (new Fraction(n, 1)));
	}
}