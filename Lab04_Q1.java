import java.util.*;

class Interest {
	int principal, rate_of_interest, time_period;

	public Interest() {
		this.principal = 0;
		this.rate_of_interest = 0;
		this.time_period = 0;
	}

	public Interest(int principal, int rate_of_interest, int time_period) {
		this.principal = principal;
		this.rate_of_interest = rate_of_interest;
		this.time_period = time_period;
	}

	public String toString() {
		return ("Principal = Rs " + this.principal + "\nRate of Interest = " + this.rate_of_interest
				+ "%\nTime Period = " + this.time_period + " years");
	}
}

class SimpleInterest extends Interest {
	public SimpleInterest(int principal, int rate_of_interest, int time_period) {
		super(principal, rate_of_interest, time_period);
	}

	public double getFinalAmount() {
		return (this.principal + (this.principal * this.rate_of_interest * this.time_period) / 100.0);
	}
}

class CompoundInterest extends Interest {
	public CompoundInterest(int principal, int rate_of_interest, int time_period) {
		super(principal, rate_of_interest, time_period);
	}

	public double getFinalAmount() {
		return (this.principal * Math.pow((1 + (this.rate_of_interest / 100.0)), this.time_period));
	}
}

public class Lab04_Q1 {
	public static void main(String[] args) {
		// Interest i1 = new Interest(1000, 10, 2);
		// System.out.println(i1.toString());
		// SimpleInterest si1 = new SimpleInterest(1000, 10, 5);
		// System.out.println(si1.getFinalAmount());
		// CompoundInterest ci1 = new CompoundInterest(1000, 10, 5);
		// System.out.println(ci1.getFinalAmount());
		Scanner sc = new Scanner(System.in);
		int p = sc.nextInt(), r = sc.nextInt(), t = sc.nextInt();
		char c = sc.next().charAt(0);

		if (c == 'c') {
			CompoundInterest obj = new CompoundInterest(p, r, t);
			System.out.println(obj.toString());
			double ans = obj.getFinalAmount();
			double rounded_ans = Math.round(ans * 100.0) / 100.0; // Rounds to 2 decimal places
			System.out.println(rounded_ans);

		} else if (c == 's') {
			SimpleInterest obj = new SimpleInterest(p, r, t);
			System.out.println(obj.toString());
			double ans = obj.getFinalAmount();
			double rounded_ans = Math.round(ans * 100.0) / 100.0; // Rounds to 2 decimal places
			System.out.println(rounded_ans);
		}
		sc.close();
	}
}