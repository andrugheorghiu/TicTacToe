import java.util.Random;
import java.util.Scanner;

/**
 * 
 * Class which defines the Player type
 * 
 * @author Andru
 *
 */
public class Player {
	
	/**
	 * 
	 * The character this player uses
	 * 
	 */
	private char character;
	
	/**
	 * 
	 * Boolean parameter to specify if current player is human or AI
	 * 
	 */
	private boolean isHuman;
	
	/**
	 * 
	 * Constructor
	 * 
	 * @param character	character for this player
	 * @param playerType	specifier for player type (human or AI player)
	 */
	public Player(char character, String playerType) {
		this.character = character;
		this.isHuman = playerType.toUpperCase().equals("HUMAN");
	}
	
	/**
	 * 
	 * Getter method for player's character
	 * 
	 * @return	returns player's character
	 */
	public char getCharacter() {
		return character;
	}
	
	/**
	 * 
	 * Method for performing an action (a move) as a human player.
	 * Read action from input, if correct execute, otherwise read action again until success.
	 * 
	 * @param board	board on which we are acting
	 * @return	returns the point on the board where the player puts his character
	 */
	private void makeHumanMove(Board board) {
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in);
		int line = -1, column = -1;
		do { // execute the following
			System.out.println("Input line and column: ");
			line = reader.nextInt();    // read line from input
			column = reader.nextInt();  // read column from input
		} while (!board.putCharacter(new Point(line, column), character)); // if can make move stop, otherwise repeat
	}
	
	/**
	 * 
	 * Method for performing an action (a move) as an AI player.
	 * This is implementation just makes a random move.
	 * 
	 * @param board	board on which we are acting
	 */
	private void makeAIMove(Board board) {
		Random generator = new Random(); // random number generator
		int line = -1, column = -1;
		do {
			line = generator.nextInt(board.getSize());
			column = generator.nextInt(board.getSize());
		} while (!board.putCharacter(new Point(line, column), character));
	}
	
	/**
	 * 
	 * Method for performing an action, whether it is done by a human or an AI player
	 * 
	 * @param board	board on which we are acting
	 */
	public void makeMove(Board board) {
		if (isHuman)
			makeHumanMove(board);
		else
			makeAIMove(board);
	}
	
	/**
	 * 
	 * Method used to test if 2 players are equal (they use the same character).
	 * Warning! This is equals method is not "politically correct". There is an equals method
	 * in the Object class which has the signature: boolean equals(Object o).
	 * That is the method we should have implemented (overwritten). However, considering that we are always
	 * comparing players among themselves, there is no reason to complicate this (especially
	 * since inheritance and overwritting methods is not clear at this point).
	 * 
	 * @param p	player which we are comparing with this player
	 * @return	returns true if player p is equal to this player, false otherwise
	 */
	public boolean equals(Player p) {
		return (character == p.character);
	}
	
	/**
	 * 
	 * Return string representation for this player. In this case, just the character he is using
	 * 
	 */
	public String toString() {
		return character + "";
	}
}
