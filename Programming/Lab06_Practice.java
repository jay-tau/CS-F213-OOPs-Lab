/*
 * Lab 6 - Practice Question
 *
 * We have two classes:
 * Circle - Accepts radius, calculates area, and is comparable. Comparison is done using radius.
 * Rectangle - Accepts length and width, calculates area, and is comparable. Comparison is done using area. You must make sure that Circle and Rectangle types are comparable.
 * Hint: use an inbuilt interface.
 *
 * Once done, you have to complete the following function in the Driver code class: Comparable boolean isEquivalent(Comparable ele1, Comparable ele2) - returns true if ele1 and ele2 are equivalent.
 *
 * Note:
 * DO NOT modify any of the base code. Only add your code in the space mentioned
 * Ignore any warnings your editors give regarding 'Comparable is a raw type'. This is because the Comparable interface is generic; you will learn about generics later. For now, there is no need to worry.
 *
 * Input format:
 *
 * The first line is the radius of two circles.
 * The second line is the length and width of the first rectangle.
 * The third line is the length and width of the second rectangle.
 *
 * Output format:
 * The first line is 'true' if the circles are equivalent.
 * The second line is 'true' if the rectangles are equivalent.
 *
 * Sample Input:
 * 2 3
 * 4 5
 * 5 4
 *
 *  Sample Output:
 * false
 * true
 *
 * Explanation:
 * The first circle has a radius of 2 and the second circle has a radius of 3. They are not equivalent.
 * The first rectangle has a length of 4 and a width of 5. The second rectangle has a length of 5 and a width of 4. They have the same area and are equivalent.
 */

import java.util.Scanner;

class Circle implements Comparable<Object> { // Something changes on this line
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public int compareTo(Object o) {
        Circle c = (Circle) o;
        if (this.radius > c.radius)
            return 1;
        else if (this.radius < c.radius)
            return -1;
        else
            return 0;
    }
}

class Rectangle implements Comparable<Object> { // Something changes on this line
    private int length, width;

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int getArea() {
        return length * width;
    }

    @Override
    public int compareTo(Object o) {
        Rectangle r = (Rectangle) o;
        if (this.getArea() > r.getArea())
            return 1;
        else if (this.getArea() < r.getArea())
            return -1;
        else
            return 0;
    }
}

public class Lab06_Practice {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // accept 2 circles
        Circle c1 = new Circle(in.nextInt());
        Circle c2 = new Circle(in.nextInt());

        // accept 2 rectangles
        Rectangle r1 = new Rectangle(in.nextInt(), in.nextInt());
        Rectangle r2 = new Rectangle(in.nextInt(), in.nextInt());
        in.close();

        // compare circles
        System.out.println(isEquivalent(c1, c2));

        // compare rectangles
        System.out.println(isEquivalent(r1, r2));
    }

    static boolean isEquivalent(Comparable<Object> ele1, Comparable<Object> ele2) {
        return ele1.compareTo(ele2) == 0;
    }
}