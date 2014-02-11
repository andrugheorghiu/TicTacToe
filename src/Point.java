/**
 * 
 * Class which defines the type Point, used to mark positions on the board.
 * 
 * @author Andru
 *
 */
public class Point {
	
	/**
	 * 
	 * Board coordinates
	 * 
	 */
	private int line, column;
	
	/**
	 * 
	 * Constructor
	 * 
	 * @param line	line coordinate
	 * @param column	column coordinate
	 */
	public Point(int line, int column) {
		this.line = line;
		this.column = column;
	}
	
	/**
	 * 
	 * Simple getter for line
	 * 
	 * @return	returns this point's line coordinate
	 */
	public int getLine() {
		return line;
	}
	
	/**
	 * 
	 * Simple getter for column
	 * 
	 * @return	returns this point's column coordinate
	 */
	public int getColumn() {
		return column;
	}
}