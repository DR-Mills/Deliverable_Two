import java.util.Scanner;
import java.util.Random;

public class Heads_or_Tails {
	static Scanner scnr = new Scanner(System.in);
	static Random ran = new Random();

	static String headsOrTailsGuess = "";
	static int numberOfFlips = 0;
	static int correctCount = 0;
	static int percentCorrect = 0;
	static boolean t = true;

	public static void main(String[] args) {

		// welcome message. Requires correct input before proceeding
		while (t) {
			System.out
					.println("Welcome to the major life decision assistant. \n" + "Please type \"heads\" or \"tails\"");
			
			headsOrTailsGuess = scnr.nextLine();

			if (isChoiceValid(headsOrTailsGuess)) {
				t = false;
			} else {
				System.out.println("Unrecognized input. Please enter either \"heads\" or \"tails\" only.\n");
			}
		}
		
		System.out.println("How many coin-tosses would you like to do?");

		numberOfFlips = scnr.nextInt();

		System.out.println("Ok, lets start flipping...");
		
		totalFlips();
		
		System.out.println("Original Guess: " + headsOrTailsGuess + ". Total Flips: " + numberOfFlips + ". Correct: "
				+ correctCount);
		
		// percentCorrect();
		// System.out.println("Your guess, " + headsOrTailsGuess + ", came up " +
		// correctCount + " times. This is equal to " + percentCorrect + "%.");
		scnr.close();

	}

	// OPERATORS
	// validates user entry of "heads" or "tails"
	public static boolean isChoiceValid(String str) {
		if (str.equalsIgnoreCase("heads") || (str.equalsIgnoreCase("tails"))) {
			return true;
		}
		return false;
	}

	// performs headsOrTails() as many times as user indicates via numberOfFlips
	// variable and increments counter for correct guesses
	public static void totalFlips() {
		for (int i = 0; i < numberOfFlips; i++) {
			String s = headsOrTails();
			System.out.println(s);
			if (s.equalsIgnoreCase(headsOrTailsGuess)) {
				correctCount++;
			}
		}
	}

	// Returns String "heads" or "tails" based on randomly generated 0 or 1
	public static String headsOrTails() {
		int num = ran.nextInt(2);
		String coin = "";
		if (num == 0) {
			coin = "tails";
		}
		else if (num == 1) {
			coin = "heads";
		}
		return coin;
	}

	// percent correct calculator
	public static void percentCorrect() {
		percentCorrect = correctCount / numberOfFlips * 100;
	}

}
