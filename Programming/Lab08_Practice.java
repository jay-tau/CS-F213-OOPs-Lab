/*
 * You have to implement a Queue class. The base driver class is given in the question on the left; you have to complete the class. The description for each method is given as comments in the code. Go through them before attempting the problem.
 *
 * Note: There are a few syntax errors as well in the code; correct them else the code will not work. Read the comments in the methods for their description.
 *
 * Some base information:
 *
 * Queue: A queue is defined as a linear data structure that is open at both ends, and the operations are performed in First In First Out (FIFO) order. Front and size are used in this case. FIFO means if you enter 10 20 30 in the queue and then try to remove it from the queue, 10 will be removed as it came in the queue first.
 *
 * Think of it as when we all enter the auditorium for Comedy Night. The first in line gets to enter the auditorium and leave the line.
 *
 * Input Format:
 *
 * 1st Line: Capacity of the queue
 * 2nd Line: String input
 * Rest of the lines: Depending on the number of ‘i’ characters present in the string input in the 2nd line.
 *
 * Meaning of characters in the string
 *
 * i - Input of element in queue
 * d- remove from queue (according to FIFO)
 * f- print first element
 * s- print size
 * t- print if empty or not
 * l- list all elements
 *
 * Sample Test Case
 *
 * Input:
 *
 * 2 iidstl 10 20
 * Output:
 *
 * 10 is removed.
 * 1 is the size.
 * queue is not empty.
 * whole queue listed below.
 * 20
 */

import java.util.*;

class A {
	// There are several errors in the code below apart from the implementation
	// part. Fix them.

	// static int modulo(int a, int b) {
	// return (a >= 0) ? (a % b) : ((a % b) + Math.abs(b));
	// }

	static class queue {
		private int[] data;
		private int front;
		private int size;

		public queue() {
			// This is the default constructor, assign the front and size to 0 and data to a
			// new array of size 10
			this.front = 0;
			this.size = 0;
			this.data = new int[10];
		}

		public queue(int cap) {
			// This is the parameterized constructor, assign the front and size to 0 and
			// data to a new array of size cap
			this.front = 0;
			this.size = 0;
			this.data = new int[cap];
		}

		public int size() {
			// Return size of the queue
			return this.size;
		}

		public boolean isEmpty() {
			// Check if empty
			return (this.size == 0);
		}

		public void add(int val) {
			// Add the value to the queue
			/*
			 * Note: It should print "queue overflow for " + val if the queue is full
			 */
			if (this.size >= this.data.length) {
				System.out.println("queue overflow for " + val);
				return;
			} else {
				int next = ((this.front + this.size) % this.data.length);
				this.data[next] = val;
				this.size++;
			}
		}

		public int remove() {
			// Remove the value from the queue
			/*
			 * Note: It should print "queue underflow" if the queue is empty
			 */
			if (this.size == 0) {
				System.out.println("queue underflow");
				return -1;
			} else {
				int val = this.data[this.front];
				this.front = ((this.front + 1) % this.data.length);
				this.size--;
				return val;
			}
		}

		public int peek() {
			// Return the value at the front of the queue
			/*
			 * Note: It should print "queue underflow" if the queue is empty
			 */
			if (this.size == 0) {
				System.out.println("queue underflow");
				return -1;
			} else {
				return this.data[this.front];
			}
		}

		public void display() {
			// Print the queue
			// data[front:] + data[:front]
			int count = 0;
			for (int i = front; i < this.data.length; i++) {
				if (count == this.size) {
					break;
				}
				count++;
				System.out.print(this.data[i] + " ");
			}
			for (int i = 0; i < front; i++) {
				if (count == this.size) {
					break;
				}
				count++;
				System.out.print(this.data[i] + " ");
			}
			System.out.println();
		}
	}
}

public class Lab08_Practice {
	public static void main(String[] args) {

		/*
		 * Dont Change the code below, this is the driver code. No HARDCODING allowed.
		 * The TAs will be checking for any form of HARDCODING based on the input.
		 */
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		A.queue q = new A.queue(n);
		String str = scn.next();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == 'i') {
				int val = scn.nextInt();
				q.add(val);
			} else if (ch == 'd') {
				int val = q.remove();
				if (val != -1) {
					System.out.print(val);
					System.out.println(" is removed.");
				}
			} else if (ch == 'f') {
				int val = q.peek();
				if (val != -1) {
					System.out.print(val);
					System.out.println(" is peek element.");
				}
			} else if (ch == 's') {
				System.out.print(q.size());
				System.out.println(" is the size.");
			} else if (ch == 't') {
				if (q.isEmpty()) {
					System.out.println("queue is empty.");
				} else {
					System.out.println("queue is not empty.");
				}
			} else if (ch == 'l') {
				System.out.println("whole queue listed below.");
				q.display();
			}
		}
		System.out.println("\nExiting from the Main");
		scn.close();
	}
}
