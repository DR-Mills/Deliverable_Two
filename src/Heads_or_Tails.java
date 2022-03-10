import java.util.Scanner;
import java.util.Random;

/**
 * @author Dusting Mills
 *
 * Performs a simulated pseudo-random coin-toss (or multiple tosses,
 * based on user input) and shows results of that(those) toss(es)
 * including the percentage of tosses that the user's guess was correct.
 */
public class Heads_or_Tails {
	private final static String welcomeMsg = "Welcome to the major life decision assistant. \n" + "Please type \"heads\" or \"tails\"";
	private final static String unrecognizedMsg = "Unrecognized input. Please enter either \"heads\" or \"tails\". Try again.";
	private final static String howManyMsg = "How many coin-tosses would you like to do?";
	private final static String startFlipMsg = "\nOk, lets start flipping...";
	
	static Scanner scnr = new Scanner(System.in);
	static Random ran = new Random();

	static String headsOrTailsGuess;
	static int numberOfFlips = 0;
	static int correctCount = 0;
	static int percentCorrect = 0;
			
	/**
	 * Displays text to prompt user for input of a "heads" or "tails" guess and 
	 * number of coin tosses the user would like to perform.
	 * Input is stored as variables and passed through methods in Heads_or_Tails class.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		boolean t = true;

		System.out.println(welcomeMsg);
		getValidUserInput(t);

		System.out.println(howManyMsg);
		numberOfFlips = scnr.nextInt();

		System.out.println(startFlipMsg);
		totalFlips();

		System.out.println("\nYour guess, " + headsOrTailsGuess + ", came up " + correctCount
				+ " time(s). \nThis is " + percentCorrect(correctCount, numberOfFlips) + "%.");

		scnr.close();

	}

	private static void getValidUserInput(boolean t) {
		while (t) {
			headsOrTailsGuess = scnr.nextLine();

			if (isChoiceValid(headsOrTailsGuess)) {
				t = false;
			} else {
				System.out.println(unrecognizedMsg);
			}
		}
	}

	// OPERATORS
	/**
	 * Validates user entry of "heads" or "tails" .
	 * 
	 * @param str "heads" or "tails".
	 * @return true if string parameters are met, false otherwise.
	 */
	private static boolean isChoiceValid(String str) {
		if (str.equalsIgnoreCase("heads") || (str.equalsIgnoreCase("tails"))) {
			return true;
		}
		return false;
	}

	/**
	 * Performs headsOrTails() as many times as user indicates with
	 * user input numberOfFlips and increments correctCount variable
	 * by 1 for each correct guess. 
	 */
	private static void totalFlips() {
		for (int i = 0; i < numberOfFlips; i++) {
			String s = headsOrTails();
			System.out.println(s);
			if (s.equalsIgnoreCase(headsOrTailsGuess)) {
				correctCount++;
			}
		}
	}

	/**
	 * Randomly generates a 0 or 1 with Random.nextInt() and assigns that value
	 * to either a "tails" or "heads".
	 * 
	 * @return String "heads" or "tails" based on randomly generated 0 or 1.
	 */
	private static String headsOrTails() {
		int num = ran.nextInt(2);
		String coin = "";
		if (num == 0) {
			coin = "tails";
		} else if (num == 1) {
			coin = "heads";
		}
		return coin;
	}

	/**
	 * Calculates % of two integers.
	 * 
	 * @param a integer correctCount.
	 * @param b integer numberOfFlips.
	 * @return integer cast from percentage calculation of a/b.
	 */
	private static int percentCorrect(int a, int b) {
		return (int) Math.round(a * 100.0 / b);
	}

}
