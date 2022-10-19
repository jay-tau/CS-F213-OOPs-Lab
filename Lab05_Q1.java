/*
 * Lab 5 - Question 1
 * Create 2 classes 'Stack' and 'Queue'. Both extend the 'Lab05_Q1' class
 *
 * 'Stack' is a data Lab05_Q1 where the LAST element added to it is the FIRST one to be removed. 'Queue' is a data Lab05_Q1 where the FIRST element added to it is the FIRST one to be removed.
 *
 * Both these Lab05_Q1s are to be internally represented by an int array. The internal array is called data and it is defined in the Lab05_Q1 class. Its access type is set to protected. This means that the Sub-Classes can access it.
 *
 * The max size of the Lab05_Q1 is defined and stored in the 'Lab05_Q1' class.
 *
 * You have to implement 4 methods for each of the classes ('Stack' and 'Queue')
 *
 * public boolean push(int e): Adds an element to the Stack/Queue. Returns true if it is successfully added to the Lab05_Q1. False otherwise.
 * public int peek(): Returns the element WITHOUT removing it from the Lab05_Q1. In case the Lab05_Q1 is empty, returns -1
 * public int pop(): Returns AND removes the element from the Lab05_Q1. In case the Lab05_Q1 is empty, returns -1
 * public int size(): Returns the number of elements present in the Lab05_Q
 * NOTE: You might need to create more methods in the Lab05_Q1 class to ensure that code is working. BUT DO ONLY IN THE ALLOWED SPACE
 *
 * You are also to implement a STATIC method in the 'Lab05_Q1' class which takes the name and size of the Lab05_Q1 as input and returns an instance of the specified Lab05_Q1
 *
 * public static Lab05_Q1 createLab05_Q1(String type, int size)
 * Also, override the toString method of ONLY the 'Lab05_Q1' class such that it should return the output of the following format: < TYPE >: < Space Separated Array Elements >
 *
 * Example:
 *
 * If the Lab05_Q1 is a 'Queue', and the elements stored in the array are: [5, 10, 12, 15], the output would be (ignoring the quotes): Queue: 5 10 12 15
 *
 * If the Lab05_Q1 is a 'Stack' and the elements stored in the array are: [] i.e. it's an empty array, the output would be (ignoring the quotes): Stack:
 *
 * HINT: To get the elements stored in the array, you can use the functions already implemented in the respective classes
 *
 * NOTE:
 *
 * DO NOT modify any of the base code. Only add your code in the space mentioned
 * You are NOT ALLOWED to override the toString() method in any class barring the 'Lab05_Q1' class
 * Input Format:
 *
 * The first line will contain a single number ‘m’, denoting the number of Lab05_Q1s in use.
 *
 * The next line will contain 2 space-separated tokens, first being a string which indicates the type of the Lab05_Q1 (Stack/Queue), and the second is an integer which indicates the size of the Lab05_Q1.
 *
 * The next line will contain a single number ‘k’, denoting the number of operations.
 *
 * Next ‘K’ lines follow:
 *
 * Each line contains 3 space-separated tokens denoting an operation.
 *
 * The first token is an integer indicating the index of the Lab05_Q1 being used (0 indexed)
 *
 * The next token is a String denoting the type of operation (push, pop, peek, print)
 *
 * The last token is an integer.
 *
 * NOTE: If the operation to be performed is ‘push’, then this token is the value to be pushed into the Lab05_Q1.
 *
 * Example Test case:
 *
 * INPUTS:
 * 1
 * Stack 10
 * 4
 * 0 push 2
 * 0 push 1
 * 0 pop -1
 * 0 print -1
 *
 * INPUT EXPLANATION:
 * A total of 1 Lab05_Q1 is being used, k=1
 * The Lab05_Q1 is a Stack of size 10
 * 4 operations are to be performed
 * Push the value 2 into Lab05_Q1[0]
 * Push the value 1 into Lab05_Q1[0]
 * Pop a value from Lab05_Q1[0]
 * Print the contents of Lab05_Q1[0]
 *
 * FINAL OUTPUT:
 * true
 * true
 * 1
 * Stack: 2
 *
 * OUTPUT EXPLANATION:
 * There is only a single Lab05_Q1(Stack of size 10) in play here. First, the value 2 is pushed onto this stack successfully, and true is printed.
 * Stack contents: [2]
 * Then, the value 1 is pushed onto this stack successfully, and true is printed.
 * Stack contents: [2, 1]
 * Then an element is popped from the stack. Since a stack if LIFO, the element 1 is popped, and ‘1’ is printed
 * Stack contents: [2]
 * The contents of the stack are printed:
 * Stack: 2
*/

import java.util.Scanner;

class Stack extends Lab05_Q1 {

	private int top_stack; // Points to the element present in the top of the stack

	// HINT:
	// - Adding an element to the top of the stack causes 'top_stack' to increment
	// by 1.
	// - Removing an element from the top of the stack causes 'top_stack' to
	// decrement by 1.

	// ******** START OF YOUR CODE ********
	public Stack(int size) {
		super(size);
		this.top_stack = -1;
	}

	public boolean push(int e) {
		if ((size()) >= max_size) // Check if stack will exceed max_size
			return false;

		top_stack++;
		this.data[top_stack] = e;
		return true;
	}

	public int peek() {
		if (size() <= 0) // If stack is empty
			return -1;

		return data[top_stack];
	}

	public int pop() {
		if (size() <= 0) // If stack is empty
			return -1;

		int temp = data[top_stack];
		top_stack--;
		return temp;
	}

	public int size() {
		return top_stack + 1;
	}
	// ******** END OF YOUR CODE ********

	// This function returns all the elements present in the stack as an array
	public int[] getData() {
		int[] data = new int[size()];
		for (int i = 0; i < size(); i++) {
			data[i] = this.data[i];
		}

		return data;
	}

}

class Queue extends Lab05_Q1 {

	private int front_queue; // Points to the element present in the front of the queue
	private int rear_queue; // Points to the element present in the rear of the queue

	// HINT:
	// - Adding an element to a queue, causes 'rear_queue' to increment by 1.
	// - Removing an element from a queue, causes 'front_queue' to increment by 1.

	// ******** START OF YOUR CODE ********
	public Queue(int size) {
		super(size);
		this.front_queue = 0;
		this.rear_queue = -1;
	}

	public boolean push(int e) {
		if ((rear_queue + 1) > max_size) // Check if queue will exceed max_size
			return false;

		rear_queue++;
		this.data[rear_queue] = e;
		return true;
	}

	public int peek() {
		if (size() <= 0) // If queue is empty
			return -1;

		return data[front_queue];
	}

	public int pop() {
		if (size() <= 0) // If queue is empty
			return -1;

		int temp = data[front_queue];
		front_queue++;
		return temp;
	}

	public int size() {
		return rear_queue - front_queue + 1;
	}
	// ******** END OF YOUR CODE ********

	// This function returns all the elements present in the queue as an array
	public int[] getData() {
		int[] data = new int[size()];
		for (int i = front_queue; i <= rear_queue; i++) {
			data[i - front_queue] = this.data[i];
		}

		return data;
	}
}

public class Lab05_Q1 {

	// This is the internal array which stores the element for the Lab05_Q1.
	protected int[] data;
	protected int max_size;

	public Lab05_Q1(int size) {
		this.max_size = size;
		this.data = new int[10000];
	}

	// ******** START OF YOUR CODE ********
	public static Lab05_Q1 createLab05_Q1(String type, int size) {
		if (type.equals("Stack"))
			return (new Stack(size));
		else if (type.equals("Queue"))
			return (new Queue(size));
		else
			return null;
	}

	public boolean push(int e) {
		if (this instanceof Stack)
			return ((Stack) this).push(e);
		else if (this instanceof Queue)
			return ((Queue) this).push(e);
		else
			return false;
	}

	public int peek() {
		if (this instanceof Stack)
			return ((Stack) this).peek();
		else if (this instanceof Queue)
			return ((Queue) this).peek();
		else
			return -1;
	}

	public int pop() {
		if (this instanceof Stack)
			return ((Stack) this).pop();
		else if (this instanceof Queue)
			return ((Queue) this).pop();
		else
			return -1;
	}

	public int size() {
		if (this instanceof Stack)
			return ((Stack) this).size();
		else if (this instanceof Queue)
			return ((Queue) this).size();
		else
			return -1;
	}
	// ******** END OF YOUR CODE ********

	// This method is overriden by the subclasses. It returns the elements present
	// in the Lab05_Q1 as an array
	public int[] getData() {
		return null;
	}

	@Override
	public String toString() {
		// ******** START OF YOUR CODE ********
		String str = "";
		int[] data = getData();
		if (this instanceof Stack) {
			str += "Stack: ";
			data = ((Stack) this).getData();
		} else if (this instanceof Queue) {
			str += "Queue: ";
			data = ((Queue) this).getData();
		}
		for (int i = 0; i < data.length; i++) {
			str += data[i];
			if (i != data.length - 1)
				str += " ";
		}
		return str;
		// ******** END OF YOUR CODE ********
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int m = Integer.parseInt(sc.nextLine());

		Lab05_Q1[] Lab05_Q1s = new Lab05_Q1[m];

		for (int i = 0; i < m; i++) {
			String[] arr = sc.nextLine().split(" ");
			String type = arr[0];
			int n = Integer.parseInt(arr[1]);
			Lab05_Q1s[i] = Lab05_Q1.createLab05_Q1(type, n);
		}

		int k = Integer.parseInt(sc.nextLine());

		while (k-- > 0) {
			String[] instruction = sc.nextLine().split(" ");
			int idx = Integer.parseInt(instruction[0]);
			String operation = instruction[1];
			int value = Integer.parseInt(instruction[2]);

			if (operation.equals("push")) {
				System.out.println(Lab05_Q1s[idx].push(value));
			}
			if (operation.equals("pop")) {
				System.out.println(Lab05_Q1s[idx].pop());
			}
			if (operation.equals("peek")) {
				System.out.println(Lab05_Q1s[idx].peek());
			}
			if (operation.equals("size")) {
				System.out.println(Lab05_Q1s[idx].size());
			}
			if (operation.equals("print")) {
				System.out.println(Lab05_Q1s[idx]);
			}
		}
		sc.close();
	}
}