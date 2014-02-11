/**
 * 
 * Class which defines the tic-tac-toe board
 * 
 * @author Andru
 *
 */
public class Board {
	
	/**
	 * 
	 * Size of the board is implicitly 3
	 * 
	 */
	private int size = 3;
	
	/**
	 * 
	 * Actual board, represented as matrix of chars (the chars can be either X or O)
	 * 
	 */
	private char[][] board;
	
	/**
	 * 
	 * Stores number of empty places on the board. Initially, the entire board is empty
	 * 
	 */
	private int emptyPlaces;
	
	/**
	 * 
	 * Constructor for making the board of a specific size 
	 * 
	 */
	public Board(int size) {
		if (size > 1) // size has to be positive and in this case in only makes sense to have size > 1
			this.size = size;
		board = new char[size][size];
		emptyPlaces = size * size;
	}

	/**
	 * 
	 * Default constructor, simply initializes the board as a 3x3 board (using the first constructor) 
	 * 
	 */
	public Board() {
		this(3); // this is a call to the first constructor, with parameter 3 for size
	}
	
	/**
	 * 
	 * Method for checking if the board is full or not
	 * 
	 * @return returns true if board is full, false otherwise
	 */
	public boolean isFull() {
		return (emptyPlaces == 0);
	}
	
	/**
	 * 
	 * Method which checks if a given point is within the bounds of the game
	 * 
	 * @param p	point
	 * @return	returns true if the point is within the bounds or false otherwise
	 */
	private boolean inBounds(Point p) {
		return ((p.getLine() >= 0) && (p.getLine() < size) && (p.getColumn() >= 0) && (p.getColumn() < size));  
	}

	/**
	 * 
	 * Method which checks if a given point on the board is occupied (there is already a character there)
	 * 
	 * @param p	point
	 * @return	returns true if the point on the board is occupied
	 */
	private boolean isOccupied(Point p) {
		return (board[p.getLine()][p.getColumn()] != 0);
	}
	
	/**
	 * 
	 * Method for putting a character on the board.
	 * 
	 * @param p		point where we put a character on the board
	 * @param c		character which we are putting on the board
	 * @return	returns true if move was successful
	 */
	public boolean putCharacter(Point p, char c) {
		if (!inBounds(p) || isOccupied(p))
			return false;
		board[p.getLine()][p.getColumn()] = c;
		emptyPlaces--;
		return true;
	}
	
	/**
	 * 
	 * Method for returning the character of a specific position on the board.
	 * Because of how this function is used, it's easier to specify line and column, rather
	 * than Point.
	 * 
	 * @param line	line coordinate
	 * @param column	column coordinate
	 * @return	the character at point p on the board
	 */
	public char getCharacter(int line, int column) {
		if (!inBounds(new Point(line, column)))
			return 0;
		return board[line][column];
	}
	
	/**
	 * 
	 * Simple getter for board size
	 * 
	 * @return	returns board size
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * 
	 * Method for returning a String representation of the board. Used for printing
	 * 
	 */
	public String toString() {
		String str = "";
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++)
				if (board[i][j] == 0)
					str += '-';
				else
					str += board[i][j];
			str += "\n"; // new line
		}
		return str;
	}
}
