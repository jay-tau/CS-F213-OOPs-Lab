/*
 * Lab 4 - Question 1
 * Define a class Interest, which contains 3 integer fields:
 *
 * Principal, Rate of interest (per annum), Time period
 *
 * Create a default constructor and a parameterized constructor for this class. Override the toString() method so that on printing the object, we get the output in the below format:
 *
 * If the principal is 5000, rate of interest is 5% and the time period is 2 years, the output should be
 *
 * Output:
 *
 * Principal = Rs 5000
 *
 * Rate of Interest = 5%
 *
 * Time Period = 2 years
 *
 * (Hint: Use \n for inserting a new line).
 *
 * Define two more classes called SimpleInterest and Compound Interest, both of which extend the Interest class. Create a getFinalAmount() method in these classes that returns the final amount at the end of the time period.
 *
 * Formula for final amount for Simple Interest:
 * Principal + (Principal * Rate * Time) / 100
 *
 * Formula for final amount for Compound Interest:
 * Principal ( (1 + Rate/100)^Time)
 *
 * Finally, create a class Test, whose main method takes the input of the principal, the rate of interest, the time period, and whether the interest is simple or compound (char input where c denotes compound, s denotes simple).
 *
 * According to the input, create an object of the appropriate class and print the object along with the final amount. Round off the final amount to 2 decimal places while printing.
 *
 * Example:
 *
 * Input:
 *
 * 1000 10 5 s
 *
 * Output:
 *
 * Principal = Rs 1000
 *
 * Rate of Interest = 10%
 *
 * Time Period = 5 years
 *
 * 1500.0
 *
 * Explanation:
 *
 */



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