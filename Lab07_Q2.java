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