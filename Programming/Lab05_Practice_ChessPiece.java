
import java.util.Scanner;

public class Lab05_Practice_ChessPiece {
	private int rank;
	private int file;
	private String color;

	/*
	 * The 'Rank' of a piece is the row number of the chess board.
	 * We take the rank to be an integer in the range of 0 to 7 (both inclusive) for
	 * our purposes.
	 *
	 * The 'File' of a piece is the column number of the chess board.
	 * We take the file to be an integer in the range of 0 to 7 (both inclusive) for
	 * our purposes.
	 *
	 * Each piece has a 'color' which is either 'white' or 'black'.
	 */

	public Lab05_Practice_ChessPiece(int rank, int file, String color) {
		this.rank = rank;
		this.file = file;
		this.color = color;
	}

	// Return the rank of the piece
	protected int getRank() {
		// ******** START OF YOUR CODE ********
		return this.rank;
		// ******** END OF YOUR CODE ********
	}

	// Return the file of the piece
	protected int getFile() {
		// ******** START OF YOUR CODE ********
		return this.file;
		// ******** END OF YOUR CODE ********
	}

	// Return the color of the piece
	protected String getColor() {
		// ******** START OF YOUR CODE ********
		return this.color;
		// ******** END OF YOUR CODE ********
	}

	// This function is to be overriden by the subclasses.

	/*
	 * When you learn Abstraction, you can modify this function and class to be
	 * abstract as you will never have a ChessPiece object. You will only have
	 * objects of the individual piece classes.
	 */
	public boolean isValidMove(int destRank, int destFile) {
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = Integer.parseInt(sc.nextLine());

		Lab05_Practice_ChessPiece[] pieces = new Lab05_Practice_ChessPiece[n];
		for (int i = 0; i < n; i++) {
			String[] inputs = sc.nextLine().split(" ");
			String type = inputs[0];
			int rank = Integer.parseInt(inputs[1]);
			int file = Integer.parseInt(inputs[2]);
			String color = inputs[3];

			if (type.equals("king")) {
				pieces[i] = new King(rank, file, color);
			}

			if (type.equals("rook")) {
				pieces[i] = new Rook(rank, file, color);
			}
		}

		int k = Integer.parseInt(sc.nextLine());

		while (k-- > 0) {
			String[] instruction = sc.nextLine().split(" ");
			int idx = Integer.parseInt(instruction[0]);
			int destRank = Integer.parseInt(instruction[1]);
			int destFile = Integer.parseInt(instruction[2]);

			System.out.println(pieces[idx].isValidMove(destRank, destFile));
		}
		sc.close();
	}
}

class King extends Lab05_Practice_ChessPiece {
	public King(int rank, int file, String color) {
		super(rank, file, color);
	}

	/*
	 * This function returns true if the King can move to the final destination
	 * square given the initial position.
	 *
	 * The initial position can be accessed using (super.getRank() &
	 * super.getFile()) methods.
	 *
	 * The King can move one square in any direction.
	 */
	@Override
	public boolean isValidMove(int destRank, int destFile) {
		// ******** START OF YOUR CODE ********
		int sourceRank = super.getRank();
		int sourceFile = super.getFile();

		if (sourceRank == destRank && sourceFile == destFile)
			return false;
		else if (Math.abs(sourceRank - destRank) <= 1 && Math.abs(sourceFile - destFile) <= 1)
			return true;
		else
			return false;
		// ******** END OF YOUR CODE ********
	}
}

class Rook extends Lab05_Practice_ChessPiece {

	public Rook(int rank, int file, String color) {
		super(rank, file, color);
	}

	/*
	 * This function returns true if the Rook can move to the final destination
	 * square given the initial position.
	 *
	 * The initial position can be accessed using (super.getRank() &
	 * super.getFile()) methods.
	 *
	 * The Rook can move any number of squares in a straight line (horizontally or
	 * vertically).
	 */
	@Override
	public boolean isValidMove(int destRank, int destFile) {
		// ******** START OF YOUR CODE ********
		int sourceRank = super.getRank();
		int sourceFile = super.getFile();

		if (sourceRank == destRank && sourceFile == destFile)
			return false;
		else if (sourceRank == destRank || sourceFile == destFile)
			return true;
		else
			return false;
		// ******** END OF YOUR CODE ********
	}
}