/**
 * 
 * Class which defines the GameEngine class. This is the class responsible for binding all elements of the game
 * together and making the game run.
 * 
 * @author Andru
 *
 */
public class GameEngine {
	
	/**
	 * 
	 * The board used for this game
	 * 
	 */
	private Board board;
	
	/**
	 * 
	 * The 2 players who play the game
	 * 
	 */
	private Player playerX, playerO;
	
	/**
	 * 
	 * Constructor initializes board and sets the 2 players
	 * 
	 * @param size	board size
	 * @param playerX	player X
	 * @param playerO	player O
	 */
	public GameEngine(int size, Player playerX, Player playerO) {
		this.playerX = playerX;
		this.playerO = playerO;
		this.board = new Board(size);		
	}
	
	/**
	 * 
	 * Constructor initializes board to default size and sets the 2 players
	 * 
	 */
	public GameEngine(Player playerX, Player playerO) {
		this.playerX = playerX;
		this.playerO = playerO;
		this.board = new Board();
	}

	/**
	 * 
	 * Check if someone has won by completing a line
	 * 
	 * @return	true if there is a complete line on the board, false otherwise
	 */
	private boolean completeLine() {
		boolean hasWon = true;
		for (int line = 0; line < board.getSize(); line++) {
			hasWon = true;
			char firstChar = board.getCharacter(line, 0);
			if (firstChar != 0) {
				for (int column = 1; column < board.getSize(); column++)
					if (board.getCharacter(line, column) != firstChar) {
						hasWon = false;
						break;
					}
				if (hasWon)
					return true;
			} else
				hasWon = false;
		}
		return hasWon;
	}
	
	/**
	 * 
	 * Check if someone has won by completing a column
	 * 
	 * @return	true if there is a complete column on the board, false otherwise
	 */
	private boolean completeColumn() {
		boolean hasWon = true;
		for (int column = 0; column < board.getSize(); column++) {
			hasWon = true;
			char firstChar = board.getCharacter(0, column);
			if (firstChar != 0) {
				for (int line = 1; line < board.getSize(); line++)
					if (board.getCharacter(line, column) != firstChar) {
						hasWon = false;
						break;
					}
				if (hasWon)
					return true;
			} else
				hasWon = false;
		}
		return hasWon;
	}

	/**
	 * 
	 * Check if someone has won by completing a diagonal
	 * 
	 * @return	true if there is a complete diagonal on the board, false otherwise
	 */
	private boolean completeDiagonal() {
		boolean hasWon = true;
		
		// check main diagonal first
		char firstChar = board.getCharacter(0, 0);
		if (firstChar != 0) {
			for (int i = 1; i < board.getSize(); i++)
				if (board.getCharacter(i, i) != firstChar) {
					hasWon = false;
					break;
				}
		} else
			hasWon = false;
		if (hasWon)
			return true;
		
		// if no success, check second diagonal
		hasWon = true;
		firstChar = board.getCharacter(0, board.getSize() - 1);
		if (firstChar != 0) {
			for (int i = 1; i < board.getSize(); i++)
				if (board.getCharacter(i, board.getSize() - i - 1) != firstChar) {
					hasWon = false;
					break;
				}
		} else
			hasWon = false;
		return hasWon;
	}
	
	
	/**
	 * 
	 * Method for checking if someone has won the game
	 * 
	 * @return	returns true if someone won the game, false otherwise
	 */
	private boolean gameWon() {
		return (completeLine() || completeColumn() || completeDiagonal());		
	}

	/**
	 * 
	 * Method for testing whether the game is over or not
	 * 
	 * @return	returns true if game is over, false otherwise
	 */
	private boolean gameOver() {
		if (gameWon())
			return true;
		if (board.isFull())
			return true;
		return false;
	}
	
	/**
	 * 
	 * Method for switching current player with his opponent
	 * 
	 * @param p	current player
	 * @return	returns opponent
	 */
	private Player switchPlayer(Player p) {
		if (p.equals(playerX))
			return playerO;
		else
			return playerX;
	}
	
	/**
	 * 
	 * Method for running the game
	 * 
	 */
	public void run() {
		Player currentPlayer = playerX;
		while (!gameOver()) {
			System.out.println(board);
			currentPlayer.makeMove(board);
			currentPlayer = switchPlayer(currentPlayer);
		}
		System.out.println(board);
		if (gameWon())
			System.out.println("Player " + switchPlayer(currentPlayer) + " has won!");
		else
			System.out.println("Draw!");
	}
}
