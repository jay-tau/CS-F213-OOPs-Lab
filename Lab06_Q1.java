/*
 * Lab 6 - Question 1
 * We have two classes:
 *
 * TimeStamp - Read only, and comparable.
 * DataCell - Readable and Writable, and comparable.
 * You have to design two interfaces:
 *
 * ReadOnly - declares a 'int read()' method to read the class's stored value.
 * ReadWrite - declares a 'int read()' and a 'void write(int value)' method to read and write to the class's stored value.
 * Implement these interfaces in the TimeStamp and DataCell classes. Besides this, you must make sure that TimeStamp and DataCell are comparable.
 *
 * Hint: use an inbuilt interface.
 *
 * Once done, you have to complete the following functions in the Driver code class (Q1):
 *
 * void copy(ReadOnly[] src, ReadWrite[] dst, int start, int end) - reads the value from src and writes into dst, from indices start (inclusive) to end (exclusive).
 * Comparable getMax(Comparable[] array) - returns the max of array. This is only possible if the array elements are comparable.
 * Note:
 *
 * DO NOT modify any of the base code. Only add your code in the space mentioned
 * Ignore any warnings your editors give regarding 'Comparable is a raw type'. This is because the Comparable interface is generic; you will learn about generics later. For now, there is no need to worry.
 * Input format:
 *
 * The first line is a single number 'count', which is the number of timestamps and datacells.
 *
 * The next line is the 'count' number of timestamp values, separated by a space.
 *
 * The next line is the 'count' number of datacell values, separated by a space.
 *
 * The next line is the start (inclusive) and end (exclusive) indices for the copy function. start < end <= count.
 *
 * Output format:
 *
 * The first line is the max of the timestamp array.
 *
 * The second line is the max of the datacell array.
 *
 * The third line is the max of the datacell array after copying the timestamp array into it.
 *
 * Sample Input:
 *
 * 4
 * 1 2 9 4
 * 3 6 7 5
 * 1 3
 * Sample Output:
 *
 * 9
 * 7
 * 9
 * Explanation: The max of the timestamp array is 9.
 *
 * The max of the datacell array is 7.
 *
 * The datacell array after copying the timestamp array is {3, 2, 9, 5}, and the max of this array is 9.
 */

import java.util.Scanner;


interface ReadOnly {
	int read();
}

interface ReadWrite {
	int read();
	void write(int value);
}

class TimeStamp implements Comparable, ReadOnly { // Something changes on this line
	private int time;

	public TimeStamp(int time) {
		this.time = time;
	}

	@Override
	public int compareTo(Object o) {
		TimeStamp t = (TimeStamp) o;
		if (this.time > t.time)
			return 1;
		else if (this.time < t.time)
			return -1;
		else
			return 0;
	}

	@Override
	public int read() {
		return this.time;
	}
}

class DataCell implements Comparable, ReadWrite { // Something changes on this line
	private int store;

	public DataCell() {
		store = 0;
	}

	@Override
	public int compareTo(Object o) {
		DataCell d = (DataCell) o;
		if (this.store > d.store)
			return 1;
		else if (this.store < d.store)
			return -1;
		else
			return 0;
	}

	public void write(int value) {
		this.store = value;
	}

	@Override
	public int read() {
		return this.store;
	}
}

public class Lab06_Q1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		// size of timeStamps and dataCells
		int count = in.nextInt();

		// create timeStamps
		TimeStamp[] timeStamps = new TimeStamp[count];
		for (int i = 0; i < count; i++) {
			int value = in.nextInt();
			TimeStamp ts = new TimeStamp(value);
			timeStamps[i] = ts;
		}

		// create dataCells
		DataCell[] dataMem = new DataCell[count];
		for (int i = 0; i < count; i++) {
			DataCell dc = new DataCell();
			int value = in.nextInt();
			dc.write(value);
			dataMem[i] = dc;
		}
		int copyStart = in.nextInt(), copyEnd = in.nextInt();
		in.close();

		System.out.println(((TimeStamp) getMax(timeStamps)).read());
		System.out.println(((DataCell) getMax(dataMem)).read());
		copy(timeStamps, dataMem, copyStart, copyEnd);
		System.out.println(((DataCell) getMax(dataMem)).read());
	}

	static void copy(ReadOnly[] src, ReadWrite[] dst, int start, int end) {
		for (int i = start; i < end; ++i) {
			dst[i].write(src[i].read());
		}
	}

	static Comparable getMax(Comparable[] array) {
		Comparable max = array[0];
		for (int i = 1; i < array.length; ++i) {
			if (array[i].compareTo(max) > 0) {
				max = array[i];
			}
		}
		return max;
	}
}
