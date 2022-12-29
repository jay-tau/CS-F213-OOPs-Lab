/*
 * Lab 6 Q2
 * We have two interfaces:
 *
 * Breakable - For blocks which can be broken into peices.
 * Flammable - For blocks which can be set on fire.
 * We have one abstract class:
 *
 * Block - The base class for all blocks. A block is movable ONLY IF its neither burning nor broken.
 *
 * Two blocks are equal if they are instances of the same class, and have the same position. Your task is to override a method from the Object class to make this work. DO NOT use instanceof
 *
 * We have two classes:
 *
 * Wood - Subclass of Block, and is Breakable and Flammable.
 * Stone - Subclass of Block, and is Breakable.
 * Implement the Breakable and Flammable interfaces in these classes. Once done implement the void makeMovable(Block b) in the Q2 class:
 *
 * Since blocks cannot be moved if burning or broken, you must call the extinguishIt or fixIt methods, according to the Interface that Block b is an instance of.
 *
 * Note:
 *
 * DO NOT modify any of the base code. Only add your code in the space mentione
 *
 * DO NOT use instanceof.
 * Input format:
 *
 * The first line is the type of block (0 = Wood, 1 = Stone).
 *
 * The second line is the starting coordinates of the block.
 *
 * The third line is the destination coordinates of the block.
 *
 * Output format:
 *
 * The first line is the time taken to move the block, after it has been extinguised or fixed.
 *
 * The second line is whether the block is equal to a pre-defined test block, after making it movable.
 *
 * Sample Input:
 *
 * 0
 * 0 0 0
 * 2 2 2
 * Sample Output:
 *
 * 6
 * false
 * Explanation:
 *
 * The computed time to move according to the function is 6.
 *
 * The block is not equal to the test block, since the coordinates do not match.
 */

import java.util.Scanner;

interface Breakable {
	public void fixIt();
}

interface Flammable {
	public void extinguishIt();
}

abstract class Block {
	public int x, y, z;
	protected boolean isBurning, isBroken;

	Block(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
		isBurning = false;
		isBroken = false;
	}

	public int timeToMove(int destx, int desty, int destz) {
		if (isBurning || isBroken)
			return -1;

		return Math.abs(destx - x) + Math.abs(desty - y) + Math.abs(destz - z);
	}

	@Override
	public boolean equals(Object o) {
		if (this.getClass() == Wood.class && o.getClass() == Wood.class) {
			// System.out.println("equals: Wood");
			Wood w = (Wood) o;
			return this.x == w.x && this.y == w.y && this.z == w.z;
		} else if (this.getClass() == Stone.class && o.getClass() == Stone.class) {
			// System.out.println("equals: Stone");
			Stone s = (Stone) o;
			return this.x == s.x && this.y == s.y && this.z == s.z;
		} else {
			// System.out.println("equals: class mismatch");
			return false;
		}
	}
}

class Wood extends Block implements Flammable { // Something changes on this line
	Wood(int x, int y, int z) {
		super(x, y, z);
		isBurning = true;
	}

	@Override
	public void extinguishIt() {
		this.isBurning = false;
	}
}

class Stone extends Block implements Breakable { // Something changes on this line
	Stone(int x, int y, int z) {
		super(x, y, z);
		isBroken = true;
	}

	@Override
	public void fixIt() {
		this.isBroken = false;
	}
}

public class Lab06_Q2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		Block testBlock = new Wood(5, 5, 5);

		Block block;
		int type = in.nextInt();
		int x = in.nextInt(), y = in.nextInt(), z = in.nextInt();

		if (type == 0) {
			block = new Wood(x, y, z);
		} else {
			block = new Stone(x, y, z);
		}

		int destx = in.nextInt(), desty = in.nextInt(), destz = in.nextInt();

		makeMovable(block);
		System.out.println(block.timeToMove(destx, desty, destz));
		System.out.println(block.equals(testBlock));

		in.close();
	}

	private static void makeMovable(Block b) {
		if (b.getClass() == Wood.class)
			((Wood) b).extinguishIt();
		else if (b.getClass() == Stone.class)
			((Stone) b).fixIt();
		else
			System.out.println("Class not Stone or Wood");
	}
}