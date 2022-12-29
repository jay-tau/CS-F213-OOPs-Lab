/*
 * Complex numbers have an imaginary part and a real part associated with it. They can be added and subtracted like regular numbers. The real parts and imaginary parts are respectively added or multiplied.
 * Implement the complex number class that contains the following functions-
 * Constructor (you need to create the appropriate constructor)
 * Add() function - The function adds two given complex numbers and updates the first complex number
 * Subtract() function - The function subtracts two given complex numbers and updates the first complex number.
 * Multiply() function - The function multiplies two given complex numbers and updates the first complex number.
 * Print() function - The function prints the complex numbers in the a + ib format (already given).
 * In main() take two complex numbers as input, take another integer as an input for choice of operations).
 * 	1. Multiply()
 * 	2. Add()
 * 	3. Subtract()
 * Print Error for any other choice (default).
 */

import java.util.*;

public class Lab02_Q2_Complex {
	public int real = 0;
	public int complex = 0;

	public Lab02_Q2_Complex(int real, int complex) { // Constructor
		this.real = real;
		this.complex = complex;
	}

	public void add(Lab02_Q2_Complex num) {
		this.real += num.real;
		this.complex += num.complex;
		this.print();
	}

	public void multiply(Lab02_Q2_Complex num) {
		int real = ((this.real * num.real) - (this.complex * num.complex));
		int complex = ((this.real * num.complex) + (this.complex * num.real));

		this.real = real;
		this.complex = complex;

		this.print();
	}

	public void subtract(Lab02_Q2_Complex num) {
		this.real -= num.real;
		this.complex -= num.complex;
		this.print();
	}

	public void print() {
		System.out.println(this.real + ((this.complex > 0) ? "+" : "-") + Math.abs(this.complex) + "i");

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(), b = sc.nextInt();
		Lab02_Q2_Complex c_1 = new Lab02_Q2_Complex(a, b);
		// c_1.print();
		int p = sc.nextInt(), q = sc.nextInt();
		Lab02_Q2_Complex c_2 = new Lab02_Q2_Complex(p, q);
		// c_2.print();

		int choice = sc.nextInt();
		switch (choice) {
			case 1:
				c_1.multiply(c_2);
				break;
			case 2:
				c_1.add(c_2);
				break;
			case 3:
				c_1.subtract(c_2);
				break;
			default:
				System.out.println("Error");
		}
		sc.close();
	}
}