/*
 * Class: CMSC203 
 * Instructor: Ahmed Tarek 
 * Description: Build an application that will receive a guess and report if your guess is the random number that was generated.  
 * 				Your application will narrow down the choices according to your previous guesses, and continue to prompt you to enter until you guess correctly.   
 * Due: 06/29/2021
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Emran Abbamacha
*/

import java.util.Scanner;

public class RandomNumberGuesser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// public static void main(String args[])
		{
			Scanner keyboard = new Scanner(System.in);
			int randNum, nextGuess, highGuess, lowGuess;
			String userResponse = "Yes";

			do {

				randNum = RNG.rand();
				highGuess = 100;
				lowGuess = 1;

				do {

					System.out.println("Enter your guess: ");
					nextGuess = keyboard.nextInt();
					keyboard.nextLine();

					if (RNG.inputValidation(nextGuess, lowGuess, highGuess)) {
						/*
						 * if (nextGuess <= randNum && (randNum - nextGuess) < (randNum - lowGuess)) {
						 * lowGuess = nextGuess; } if (nextGuess >= randNum && (nextGuess - randNum) <
						 * (highGuess - randNum)) { highGuess = nextGuess; }
						 */
						if (nextGuess > randNum) {
							System.out.println("Number of guesses is " + RNG.getCount());
							highGuess = nextGuess;
							System.out.println("Your guess is too high");
							System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess);

						} else if (nextGuess < randNum) {
							System.out.println("Number of guesses is " + RNG.getCount());
							lowGuess = nextGuess;
							System.out.println("Your guess is too low");
							System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess);

						} else if (nextGuess == randNum) {
							System.out.println("Number of guesses is " + (RNG.getCount()));
							System.out.println("Congratulations, you guessed correctly");
							System.out.println("Try again? (yes or no)");
							String tryAgain = keyboard.nextLine();
							// userResponse = keyboard.nextLine();
							if (tryAgain.equals("yes") || tryAgain.equals("Yes")) {
								userResponse = "Yes";
							} else if (tryAgain.equals("No") || tryAgain.equals("no")) {
								System.out.println("Thanks for playing...");
								userResponse = "No";
							}

						}

					}

				} while (nextGuess != randNum);
				RNG.resetCount();
			}

			while (userResponse.equals("yes") || userResponse.equals("Yes"));
		}
		System.out.println("Made by Emran Abbamacha");
	}
}
