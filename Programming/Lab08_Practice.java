
import java.util.*;

class A {
	// There are several errors in the code below apart from the implementation
	// part. Fix them.

	// static int modulo(int a, int b) {
	// 	return (a >= 0) ? (a % b) : ((a % b) + Math.abs(b));
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
