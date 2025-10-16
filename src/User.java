import java.util.Scanner;

public class User {
	public static void main(String[] args) {

		// define Scanner
		Scanner input = new Scanner(System.in);

		// setting user names and accounts

		int First_id = 1000;
		String First_name = "Hamad";

		int Second_id = 1001;
		String Second_name = "Yassir";

		int Third_id = 1002;
		String Third_name = "Khaled";

		// setting total calculations
		// Attention! these variables are used by admin

		int Total_books_borrowed = 0;

		int Total_books_returned = 0;

		float Total_revnue = 0f;

		// this variable is used to stop the do while loop if the entered name is valid
		int Valid_name = 0;

		// The login part for the user
		do {

			System.out.println("We have three registered accounts: ");
			System.out.println("");
			System.out.println("Username ID");
			System.out.println("----------------");
			System.out.println(First_name + "\t ID#" + First_id);
			System.out.println(Second_name + "\t ID#" + Second_id);
			System.out.println(Third_name + "\t ID#" + Third_id);
			System.out.println("");
			System.out.print("Choose one of the available accounts, please enter the username only: ");
			String Username = input.next();
			if (Username.equalsIgnoreCase(First_name) || Username.equalsIgnoreCase(Second_name)
					|| Username.equalsIgnoreCase(Third_name)) {
				System.out.println("");
				System.out.println("Welcome to the library " + Username);
				Valid_name++;
			} else {
				System.out.println("");
				System.out.println("Please choose one of the available accounts!");
				System.out.println("---------------------");

			}
		} while (Valid_name == 0);

		// this variable is used for the exit case,,,
		int Exit = 0;
		// Variables for the user that restart every session

		float Fees_per_session = 0f;
		int Books_borrowed = 0;
		int Books_returned = 0;

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
			int User_action = input.nextInt();
			switch (User_action) {

			case 1:
				if (Books_borrowed < 5) {
					System.out.println("");
					System.out.println("Borrowing a book has a 0.50$ fee for any book in the library you choose.");
					System.out.print("Are you sure you want to borrow a book? (answer \"yes\" or \"no\" please): ");
					String User_answer = input.next();
					if (User_answer.equalsIgnoreCase("yes") || User_answer.equalsIgnoreCase("y")) {
						// updating variables
						Fees_per_session += 0.50f;
						Total_revnue += 0.50f;
						Books_borrowed += 1;
						Total_books_borrowed += 1;

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
					System.out.println("Unfortunatly you cant borrow more than 5,,,");
					System.out.println("Therefore you will be returned to the main user menu.");
					System.out.println("---------------------");
				}
				break;

			case 2:
				if (Books_borrowed > 0) {
					System.out.println("");
					System.out.println("You are going to return one of the books you have borrowed");
					System.out.println("");
					System.out.println("We would like to make it clear that fee will not be returned");
					System.out.print("Are you sure you want to return a book? (answer \"yes\" or \"no\" please): ");
					String User_answer = input.next();
					if (User_answer.equalsIgnoreCase("yes") || User_answer.equalsIgnoreCase("y")) {
						// updating variables
						Total_books_returned += 1;
						Books_returned += 1;

						System.out.println("");
						System.out.println("You have returned on book successfully!");
						System.out.println("---------------------");
					} else {
						System.out.println("");
						System.out.println("Then you will be returned to the main user menu.");
						System.out.println("---------------------");
					}

				} else {
					System.out.println("");
					System.out.println("Oops, it seems that you have not borrowed any books yet!");
					System.out.println(
							"Therefore you will be returned to the main user menu, so you can borrow some books :)");
					System.out.println("---------------------");
				}

				break;

			case 3:
				System.out.println("");
				System.out.println("The number of books borrowed in this seesion: " + Books_borrowed);
				System.out.println("---------------------");

				break;

			case 4:
				System.out.println("");
				System.out.println("Session Summary:");
				System.out.println("----------------");
				System.out.println("Books Borrowed: " + Books_borrowed);
				System.out.println("Books Returned: " + Books_returned);
				System.out.printf("Total Fees: %.2f", Fees_per_session);
				System.out.println("");
				System.out.println("----------------");
				break;

			case 5:
				System.out.println("");
				System.out.println("You are going to Exit this session");
				System.out.println("");
				System.out.println(
						"We would like to make it clear that the actions you did during this session will be deleted!");
				System.out.print("Are you sure you want to Exit the session? (answer \"yes\" or \"no\" please): ");
				String User_answer = input.next();
				if (User_answer.equalsIgnoreCase("yes") || User_answer.equalsIgnoreCase("y")) {
					System.out.println("");
					System.out.println("You have exited the session successfully!");
					System.out.println("---------------------");
					Exit++;
				} else {
					System.out.println("");
					System.out.println("Then you will be returned to the main user menu.");
					System.out.println("---------------------");
				}

				break;

			default:
				System.out.println("Please enter a valid option!");

			}

		} while (Exit == 0);

	}

}
