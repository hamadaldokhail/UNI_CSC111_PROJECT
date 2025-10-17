import java.util.Scanner;

public class User {
	public static void main(String[] args) {

		// define Scanner
		Scanner input = new Scanner(System.in);

		// setting user names and accounts

		int firstId = 1000;
		String firstName = "Hamad";

		int secondId = 1001;
		String secondName = "Yassir";

		int thirdId = 1002;
		String thirdName = "Khaled";

		// setting total calculations
		// Attention! these variables are used by admin

		int totalBooksBorrowed = 0;

		int totalBooksReturned = 0;

		float totalRevenue = 0f;

		// this variable is used to stop the do while loop if the entered name is valid
		int validName = 0;

		// The login part for the user
		do {

			System.out.println("We have three registered accounts: ");
			System.out.println("");
			System.out.println("Username ID");
			System.out.println("----------------");
			System.out.println(firstName + "\t ID#" + firstId);
			System.out.println(secondName + "\t ID#" + secondId);
			System.out.println(thirdName + "\t ID#" + thirdId);
			System.out.println("");
			System.out.print("Choose one of the available accounts, please enter the username only: ");
			String userName = input.next();
			if (userName.equalsIgnoreCase(firstName) || userName.equalsIgnoreCase(secondName)
					|| userName.equalsIgnoreCase(thirdName)) {
				System.out.println("");
				System.out.println("Welcome to the library " + userName);
				validName++;
			} else {
				System.out.println("");
				System.out.println("Please choose one of the available accounts!");
				System.out.println("---------------------");

			}
		} while (validName == 0);

		// this variable is used for the exit case,,,
		int exit = 0;
		// Variables for the user that restart every session

		float feesPerSession = 0f;
		int booksBorrowed = 0;
		int booksReturned = 0;
		// this variable (Books_budget) is for keeping the count of the current books
		// with the user, so he could only return what he has.
		int booksBudget = 0;

		// this loop is for the menu and its cases
		do {

			System.out.println("");
			System.out.println("THE MENU:");
			System.out.println("---------------------");
			System.out.println("1.Borrow Book");
			System.out.println("2.Return Book");
			System.out.println("3.View Borrowed Books");
			System.out.println("4.View Session Summary");
			System.out.println("5.Exit to Main Menu");
			System.out.println("---------------------");
			System.out.print("How Can I help You (please enter a number): ");
			int userAction = input.nextInt();
			switch (userAction) {

			// First case, borrowing books
			case 1:
				if (booksBorrowed < 5) {
					System.out.println("");
					System.out.println("Borrowing a book has a 0.50$ fee for any book in the library you choose.");
					System.out.print("Are you sure you want to borrow a book? (answer \"yes\" or \"no\" please): ");
					String userAnswer = input.next();
					if (userAnswer.equalsIgnoreCase("yes") || userAnswer.equalsIgnoreCase("y")) {
						// updating variables
						feesPerSession += 0.50f;
						totalRevenue += 0.50f;
						booksBorrowed += 1;
						totalBooksBorrowed += 1;
						booksBudget += 1;

						System.out.println("");
						System.out.println("You have borrowed one book for 0.50$ successfully!");
						System.out.println("---------------------");
					} else {
						System.out.println("");
						System.out.println("Then you will be returned to the main user menu.");
						System.out.println("---------------------");
					}
				} else {
					System.out.println("");
					System.out.println("Oops, it seems that you have borrowed 5 books, which is the limit.");
					System.out.println("Unfortunatly, you cant borrow more than 5,,,");
					System.out.println("Therefore you will be returned to the main user menu.");
					System.out.println("---------------------");
				}
				break;

			// Second case, returning books
			case 2:
				if (booksBudget > 0) {
					System.out.println("");
					System.out.println("You are going to return one of the books you have borrowed");
					System.out.println("");
					System.out.println("We would like to make it clear that fee will not be returned");
					System.out.print("Are you sure you want to return a book? (answer \"yes\" or \"no\" please): ");
					String userAnswer = input.next();
					if (userAnswer.equalsIgnoreCase("yes") || userAnswer.equalsIgnoreCase("y")) {
						// updating variables
						totalBooksReturned += 1;
						booksReturned += 1;
						booksBudget -= 1;

						System.out.println("");
						System.out.println("You have returned one book successfully!");
						System.out.println("---------------------");
					} else {
						System.out.println("");
						System.out.println("Then you will be returned to the main user menu.");
						System.out.println("---------------------");
					}

				} else {
					System.out.println("");
					System.out.println("Oops, it seems that you dont have any books to return yet!");
					System.out.println(
							"Therefore you will be returned to the main user menu, so you can borrow some books :)");
					System.out.println("---------------------");
				}

				break;

			// Third case, display borrowed books
			case 3:
				System.out.println("");
				System.out.println("The number of books borrowed in this seesion: " + booksBorrowed);
				System.out.println("---------------------");

				break;

			// Fourth case, Session summary
			case 4:
				System.out.println("");
				System.out.println("Session Summary:");
				System.out.println("----------------");
				System.out.println("Books Borrowed: " + booksBorrowed);
				System.out.println("Books Returned: " + booksReturned);
				System.out.printf("Total Fees: %.2f", feesPerSession);
				System.out.println("");
				System.out.println("----------------");
				break;

			// Fifth case, Exit to main menu
			case 5:
				System.out.println("");
				System.out.println("You are going to Exit this session");
				System.out.println("");
				System.out.println(
						"We would like to make it clear that the actions you did during this session will be deleted!");
				System.out.print("Are you sure you want to Exit the session? (answer \"yes\" or \"no\" please): ");
				String userAnswer = input.next();
				if (userAnswer.equalsIgnoreCase("yes") || userAnswer.equalsIgnoreCase("y")) {
					System.out.println("");
					System.out.println("You have exited the session successfully!");
					System.out.println("---------------------");
					exit++;
				} else {
					System.out.println("");
					System.out.println("Then you will be returned to the main user menu.");
					System.out.println("---------------------");
				}

				break;

			default:
				System.out.println("Please enter a valid option!");

			}

		} while (exit == 0);

	}

}
