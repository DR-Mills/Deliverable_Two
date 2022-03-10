import java.util.Scanner;
import java.util.Random;

public class Heads_or_Tails {
	
	private final static String welcomeMsg = "Welcome to the major life decision assistant. Please enter \"heads\" or \"tails\"";
	private final static String invalidInputMsg = "Unrecognized input. Please enter either \"heads\" or \"tails\" only. Try again\n";
	private final static String tossCountMsg = "How many coin-tosses would you like to do?";
	private final static String startFlipMsg = "\nOk, start flipping...";

	static Scanner scnr = new Scanner(System.in);
	static Random ran = new Random();

	static String headsOrTailsGuess = "";
	static int numberOfFlips = 0;
	static int correctCount = 0;
	static int percentCorrect = 0;

	public static void main(String[] args) {
		System.out.println(welcomeMsg);

		validateUserInput();

		System.out.println(tossCountMsg);
		numberOfFlips = scnr.nextInt(); //fix me: valid the user entry is an integer - in case of user enters a string! 
		                                //reference link:https://stackoverflow.com/questions/3059333/validating-input-using-java-util-scanner
		System.out.println(startFlipMsg);
		totalFlips();

		System.out.println("\nYour guess, " 
				+ headsOrTailsGuess + ", came up " 
				+ correctCount + " time(s). \nThat's "
				+ percentCorrect(correctCount, numberOfFlips) + "%.");

		scnr.close();

	}

	// validates user input. if input is invalid, prompt message to ask try again
	private static void validateUserInput() {
		boolean isValid = true;
		while (isValid) {
			headsOrTailsGuess = scnr.nextLine();

			if (isChoiceValid(headsOrTailsGuess)) {
				isValid = false;
			} else {
				System.out.print(invalidInputMsg);
			}
		}
	}

	// OPERATORS
	// validates user entry of "heads" or "tails"
	private static boolean isChoiceValid(String str) {
		return str.equalsIgnoreCase("heads") || (str.equalsIgnoreCase("tails"));
	}

	// performs headsOrTails() as many times as user indicates via numberOfFlips
	// variable and increments counter for correct guesses
	private static void totalFlips() {
		for (int i = 0; i < numberOfFlips; i++) {
			String s = headsOrTails();
			System.out.println(s); // output each flip result
			if (s.equalsIgnoreCase(headsOrTailsGuess)) {
				correctCount++; // increment the counter
			}
		}
	}

	// Returns String "heads" or "tails" based on randomly generated 0 or 1
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

	// percent correct calculator
	private static int percentCorrect(int a, int b) {
		return (int) Math.round(a * 100.0 / b);
	}

}
