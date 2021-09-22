import java.util.Scanner;

public class MovieDriver {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		Movie userInput = new Movie();

		System.out.println("Enter the name of a movie");

		String userMovie = keyboard.nextLine();
		userInput.setTitle(userMovie);

		System.out.println("Enter the rating of the movie");
		String userRating = keyboard.nextLine();
		userInput.setRating(userRating);

		System.out.println("Enter the number of tickets sold for this movie");
		int userTickets = keyboard.nextInt();
		userInput.setSoldTickets(userTickets);

		System.out.println(userInput.toString());
		keyboard.nextLine();

		System.out.println("Do you want to enter another? (y or n)");
		String userResponse = keyboard.nextLine();

		while (userResponse.contains("y")) {

			Movie anotherInput = new Movie();

			System.out.println("Enter the name of a movie");

			String newMovie = keyboard.nextLine();
			anotherInput.setTitle(newMovie);

			System.out.println("Enter the rating of the movie");
			String newRating = keyboard.nextLine();
			anotherInput.setRating(newRating);

			System.out.println("Enter the number of tickets sold for this movie");
			int newTickets = keyboard.nextInt();
			anotherInput.setSoldTickets(newTickets);

			System.out.println(anotherInput.toString());
			keyboard.nextLine();
			System.out.println("Do you want to enter another? (y or n)");
			String newResponse = keyboard.nextLine();
			if (newResponse.contains("n")) {
				System.out.println("Goodbye");
				break;
			}
		}

		if (userResponse.contains("n")) {
			System.out.println("Goodbye");
		}
	}
}
