/*
 * We have three classes - Shape, Circle, Rectangle.
 *
 * You have to complete the abstract class, Shape, by adding the following abstract methods:
 *
 * public double getArea()
 *
 * public boolean fitOtherShape(Shape shape)
 *
 * For the Circle class, you have to extend the Shape class and add the following:
 *
 * Create the constructor with the given parameters.
 * Implement the getArea method for the circle and return a double value (rounded upto two decimal places).
 * Implement the fitOtherShape method, where the method checks whether the current circle can fit another circle or a rectangle inside it. (Perfect Overlap is allowed)
 * Override the toString method by returning the following “Circle <name> having area <value>”
 * Do the same work for Rectangle class.
 *
 * For the public class Question2, implement the following method:
 *
 * public static void smallerShapes(int index, Shapes[] shapes) : Array shapes have all the input shapes. Method should print the count of the shapes that can fit inside the shape at the given index. It should also print each shape in order, as they appear in the shapes array.
 *
 * Note:
 *
 * DO NOT modify any of the base code. Only add your code in the space mentioned.
 * <Tag> denotes that they have to be replaced with the respective input.
 * Input format:
 *
 * The first line is the number of shapes to be input.
 * For every shape, there are 2 lines:
 *
 * First line is the shape type, whether Circle or Rectangle
 *
 * Second line is the name and radius, for Circle and name, length and width for Rectangle.
 *
 * Last line is the index of the shape that is to be compared with other shapes, other than itself. (indexed from 1)
 * Output format:
 *
 * The first line displays the number of shapes that can fit inside shapes[index]
 *
 * The next lines print the shapes that can fit inside.
 * Sample Input:
 *
 * 3
 * Circle
 * c1 2
 * Rectangle
 * r1 4 4
 * Circle
 * c2 3
 * 2
 * Sample Output:
 *
 * 1
 * Circle c1 having area 12.57
 * Explanation:
 *
 * Rectangle r1 has to be compared with other shapes, as index is 2.
 *
 * Circle c1 can fit inside Rectangle since the diameter of the circle is 4 and length and width of the rectangle is also 4.
 *
 * Circle c2 has a larger diameter, i.e, 6 so it can’t fit inside the rectangle.
 */

import java.util.Scanner;

abstract class Shape {
	private final String name;

	public Shape(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public abstract double getArea();

	public abstract boolean fitOtherShape(Shape shape);
}

class Circle extends Shape {
	private int radius;

	public Circle(String name, int radius) {
		super(name);
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}

	@Override
	public double getArea() {
		double true_area = Math.PI * (this.radius * this.radius);
		double rounded_area = Math.round(true_area * 100.0) / 100.0;
		return rounded_area;
	}

	@Override
	public boolean fitOtherShape(Shape shape) {
		if (shape instanceof Circle) {
			Circle c = (Circle) shape;
			if (this.radius >= c.getRadius())
				return true;
		} else if (shape instanceof Rectangle) {
			Rectangle r = (Rectangle) shape;
			if (this.radius >= ((Math.sqrt((r.getLength() * r.getLength()) + (r.getWidth() * r.getWidth()))) / 2))
				return true;
		} else {
			System.out.println("Circle.fitOtherShape recieved an unknown shape");
		}
		return false;
	}

	@Override
	public String toString() {
		return ("Circle " + this.getName() + " having area " + this.getArea());
	}
}

class Rectangle extends Shape {
	private int length, width;

	public Rectangle(String name, int length, int width) {
		super(name);
		this.length = length;
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public int getWidth() {
		return width;
	}

	@Override
	public double getArea() {
		double true_area = this.length * this.width;
		double rounded_area = Math.round(true_area * 100.0) / 100.0;
		return rounded_area;
	}

	@Override
	public boolean fitOtherShape(Shape shape) {
		if (shape instanceof Circle) {
			Circle c = (Circle) shape;
			if ((2 * c.getRadius()) <= Math.min(this.getLength(), this.getWidth()))
				return true;
		} else if (shape instanceof Rectangle) {
			Rectangle r = (Rectangle) shape;
			if ((this.getLength() >= r.getLength()) && (this.getWidth() >= r.getWidth()))
				return true;
		} else {
			System.out.println("Rectangle.fitOtherShape recieved an unknown shape");
		}
		return false;
	}

	public String toString() {
		return ("Rectangle " + this.getName() + " having area " + this.getArea());
	}
}

public class Lab07_Q2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Shape[] shapes = new Shape[n];
		for (int i = 0; i < n; i++) {
			shapes[i] = in.next().equals("Circle") ? new Circle(in.next(), in.nextInt())
					: new Rectangle(in.next(), in.nextInt(), in.nextInt());
		}
		smallerShapes(in.nextInt() - 1, shapes);
		in.close();
	}

	public static void smallerShapes(int index, Shape[] shapes) {
		int count = 0;
		Shape fixed_shape = shapes[index];
		for (int i = 0; i < shapes.length; i++) {
			if (i == index)
				continue;
			Shape current_shape = shapes[i];
			if (fixed_shape.fitOtherShape(current_shape)) {
				count++;
			}
		}
		System.out.println(count);
		for (int i = 0; i < shapes.length; i++) {
			if (i == index)
				continue;
			Shape current_shape = shapes[i];
			if (fixed_shape.fitOtherShape(current_shape)) {
				System.out.println(current_shape.toString());
			}
		}
	}
}