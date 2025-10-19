// Khaled Abdulaziz ALquwaizany ID 446106134
// Yasser Abdullah Albusairy	ID 446104619
// Hamad Ahmed Aldokhail		ID 446103564

import java.util.Scanner;

public class LibrarySimulator {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		String choice;
		String choose;
		int totalBooksBorrowed = 0;
		int totalBooksReturned = 0;
		float totalRevenue = 0f;
		
		System.out.println("---Welcome to the Library---\n");

		do {
			System.out.println("THE MAIN MENU:");
			System.out.println("---------------------");
			System.out.println("1.Login As User");
			System.out.println("2.Login As Administrator");
			System.out.println("3.Exit");
			System.out.println("---------------------");
			
			System.out.print("Enter a number please: ");
			choose = input.next();
			System.out.println("---------------------\n");

			switch (choose) {

			case "1": {
				int firstId = 1000;
				String firstName = "Hamad";

				int secondId = 1001;
				String secondName = "Yassir";

				int thirdId = 1002;
				String thirdName = "Khaled";



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
					System.out.println("----------------");
					System.out.print("Choose one of the available accounts, please enter the username only: ");
					String userName = input.next();
					if (userName.equalsIgnoreCase(firstName) || userName.equalsIgnoreCase(secondName)
							|| userName.equalsIgnoreCase(thirdName)) {
						System.out.println("------------------------\n");
						System.out.println("Welcome to the Library " + userName);
						validName++;
					} else {
						System.out.println("");
						System.out.println("Please choose one of the available accounts!");
						System.out.println("---------------------\n");

					}
				} while (validName == 0);

				// this variable is used for the user menu,,,
				String userAction;
				String userAnswer;
				//this variable is used for exiting the user loop
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
					System.out.println("THE USER MENU:");
					System.out.println("---------------------");
					System.out.println("1.Borrow Book");
					System.out.println("2.Return Book");
					System.out.println("3.View Borrowed Books");
					System.out.println("4.View Session Summary");
					System.out.println("5.Exit to Main Menu");
					System.out.println("---------------------");
					System.out.print("How Can I help You (Enter a number please): ");
					userAction = input.next();
					switch (userAction) {

					// First case, borrowing books
					case "1":
						if (booksBorrowed < 5) {
							System.out.println("");
							System.out.println("Borrowing a book has a 0.50$ fee for any book in the library you choose.");
							System.out.print("Are you sure you want to borrow a book? (answer \"yes\" or \"no\" please): ");
							userAnswer = input.next();
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
					case "2":
						if (booksBudget > 0) {
							System.out.println("");
							System.out.println("You are going to return one of the books you have borrowed");
							System.out.println("");
							System.out.println("We would like to make it clear that fee will not be returned");
							System.out.print("Are you sure you want to return a book? (answer \"yes\" or \"no\" please): ");
							userAnswer = input.next();
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
					case "3":
						System.out.println("");
						System.out.println("The number of books borrowed in this session: " + booksBorrowed);
						System.out.println("---------------------");

						break;

					// Fourth case, Session summary
					case "4":
						System.out.println("");
						System.out.println("Session Summary:");
						System.out.println("----------------");
						System.out.println("Books Borrowed: " + booksBorrowed);
						System.out.println("Books Returned: " + booksReturned);
						System.out.printf("Total Fees: %.2f $", feesPerSession);
						System.out.println("");
						System.out.println("----------------");
						break;

					// Fifth case, Exit to main menu
					case "5":
						System.out.println("");
						System.out.println("You are going to Exit this session");
						System.out.println("");
						System.out.println(
								"We would like to make it clear that the actions you did during this session will be deleted!");
						System.out.print("Are you sure you want to Exit the session? (answer \"yes\" or \"no\" please): ");
						userAnswer = input.next();
						if (userAnswer.equalsIgnoreCase("yes") || userAnswer.equalsIgnoreCase("y")) {
							System.out.println("");
							System.out.println("You have exited the session successfully!");
							System.out.println("---------------------\n");
							exit += 1;
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

				break;
			} // users case end
			case "2": {
				String username, password;
				do {
					System.out.println("Hint: type \"admin\" for both (username, and password) to Enter");
					System.out.println("Or type exit to Return to Main Menu.\n");
					System.out.println("---To access to Administrator Menu---\n");
					System.out.print("Enter admin username: ");
					username = input.next();

					System.out.print("Enter passowrd: ");
					password = input.next();

					if (username.equalsIgnoreCase("admin") && password.equals("admin")) {
						do {
							System.out.println("\nTHE Administrator MENU:");
							System.out.println("---------------------");
							System.out.println("1. View Total Revenue");
							System.out.println("2. Most Frequent Operation");
							System.out.println("3. Exit to Main Menu");
							System.out.println("---------------------");
							System.out.print("Enter a number please: ");
							choice = input.next();

							switch (choice) {
							case "1":
								System.out.printf("\nTotal Revenue: %.2f $\n", totalRevenue);
								System.out.println("---------------------");
								break;
							case "2":

								if (totalBooksBorrowed > totalBooksReturned) {
									System.out.println("\nThe Most Frequent Operation is Borrow: " + totalBooksBorrowed);
									System.out.println("---------------------");
								} else if (totalBooksReturned > totalBooksBorrowed) {
									System.out.println("\nThe Most Frequent Operation is Renturn: " + totalBooksReturned);
									System.out.println("---------------------");
								} else {
									System.out.println("\nBorrow And Return are equal: " + totalBooksBorrowed);
									System.out.println("---------------------");}
								break;
							case "3":
								System.out.println("Returning to Main Menu\n");
								break;
							default:
								System.out.println("Invalid option. Please Try again");
							}

						} while (!choice.equals("3"));
					}

					else if (username.equalsIgnoreCase("exit") || password.equals("exit")) {
						System.out.println("Returning to Main Menu\n");
					} else {
						System.out.println("\nusername or passowrd is incorrect");
						System.out.println("Please try again");
						System.out.println("---------------------\n"); 
					}
				}

				while (!username.equalsIgnoreCase("exit")
						&& (!username.equalsIgnoreCase("admin") || !password.equals("admin")));

				break;
			} // Administrator case end
			case "3": break;
			default:
				System.out.println("Invalid option. Please Try again\n");
			} // switch end
		} // do end
		while (!choose.equals("3"));
		System.out.println("Thank you for using our Library simulator.");
		System.out.println("Goodbye.");
		input.close();
	}// main end
}
