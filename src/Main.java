/**
 * 
 * Main class. Program entry point
 * 
 * @author Andru
 *
 */
public class Main {
	
	/**
	 * 
	 * Initialize game engine from input arguments
	 * 
	 * @param args	input arguments
	 */
	public static GameEngine initialize(String[] args) {
		if (args.length > 3 || args.length < 2) {
			System.out.println("Invalid number of arguments");
			System.exit(1);
		}
		if (!(args[0].toUpperCase().equals("HUMAN") || args[0].toUpperCase().equals("AI"))) {
			System.out.println("First argument must be either \"human\" or \"ai\"");
			System.exit(1);
		}
		if (!(args[1].toUpperCase().equals("HUMAN") || args[1].toUpperCase().equals("AI"))) {
			System.out.println("Second argument must be either \"human\" or \"ai\"");
			System.exit(1);
		}
		try {
			if (args.length == 3) {
				int size = Integer.parseInt(args[2]);
				return new GameEngine(size, new Player('X', args[0]), new Player('O', args[1]));
			}
		} catch (Exception e) {
			System.out.println("Third argument is not integer");
			System.exit(1);
		}
		return new GameEngine(new Player('X', args[0]), new Player('O', args[1]));
	}

	/**
	 * 
	 * The main method. This is where everything begins.
	 * 
	 * @param args	command line arguments
	 */
	public static void main(String[] args) {
		GameEngine ge = initialize(args);
		ge.run();
	}
}