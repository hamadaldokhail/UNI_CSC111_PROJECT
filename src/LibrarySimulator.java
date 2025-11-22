// https://github.com/hamadaldokhail/UNI_CSC111_PROJECT
// Khaled Abdulaziz Alquwaizany ID 446106134
// Yasser Abdullah Albusairy	ID 446104619
// Hamed Ahmed Aldkhyyal		ID 446103564

import java.util.Scanner;

public class LibrarySimulator {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		String choice;
		String choose;

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
				// These are the user variables
				Member m1 = new Member(1000, "Hamad", 0);
				Member m2 = new Member(1001, "Yassir", 0);
				Member m3 = new Member(1002, "Khaled", 0);

				// This is a placeholder for the logged in member
				Member currentMember = null;

				// this variable is used to stop the do while loop if the entered name is valid
				int validName = 0;

				// The login part for the user
				do {

					System.out.println("We have three registered accounts: ");
					System.out.println("");
					System.out.println("Username ID");
					System.out.println("----------------");
					System.out.println(m1.getName() + "\t ID#" + m1.getId());
					System.out.println(m2.getName() + "\t ID#" + m2.getId());
					System.out.println(m3.getName() + "\t ID#" + m3.getId());
					System.out.println("----------------");
					System.out.print("Choose one of the available accounts, please enter the username only: ");
					String userName = input.next();

					if (userName.equalsIgnoreCase(m1.getName())) {
						currentMember = m1;
						validName++;
					} else if (userName.equalsIgnoreCase(m2.getName())) {
						currentMember = m2;
						validName++;
					} else if (userName.equalsIgnoreCase(m3.getName())) {
						currentMember = m3;
						validName++;
					}

					if (validName > 0) {
						System.out.println("------------------------\n");
						System.out.println("Welcome to the Library " + currentMember.getName());
					} else {
						System.out.println("");
						System.out.println("Please choose one of the available accounts!");
						System.out.println("---------------------\n");
					}
				} while (validName == 0);

				// this variable is used for the user menu,,,
				String userAction;
				String userAnswer;
				// this variable is used for exiting the user loop
				int exit = 0;
				// Variables for the user that restart every session

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
					
						currentMember.borrowOne();
						break;

					// Second case, returning books
					case "2":
						currentMember.returnOne();
						break;

					// Third case, display borrowed books
					case "3":
						currentMember.viewBorrowedCount();
						break;

					// Fourth case, Session summary
					case "4":
						currentMember.displayStatistics();
						break;

					// Fifth case, Exit to main menu
					case "5":
						System.out.println("");
						System.out.println("You are going to Exit this session");
						System.out.println("");
						System.out.println(
								"We would like to make it clear that the actions you did during this session will be deleted!");
						System.out.print(
								"Are you sure you want to Exit the session? (answer \"yes\" or \"no\" please): ");
						userAnswer = input.next();
						if (userAnswer.equalsIgnoreCase("yes") || userAnswer.equalsIgnoreCase("y")) {
							System.out.println("");
							System.out.println("You have exited the session successfully!");
							System.out.println("---------------------\n");
							currentMember.reset();
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
					System.out.println("Hint: type exit to Return to Main Menu.\n");
					System.out.println("---To access to Administrator Menu---\n");
					System.out.print("Enter admin username: ");
					username = input.next();

					System.out.print("Enter password: ");
					password = input.next();

					if (username.equalsIgnoreCase("admin") && password.equals("admin")) {
						do {
							System.out.println("\nTHE Administrator MENU:");
							System.out.println("---------------------");
							System.out.println("1. View Total Revenue");
							System.out.println("2. Most Frequent Operation");
							System.out.println("3. View Total View Borrowed");
							System.out.println("4. Exit to Main Menu");
							System.out.println("---------------------");
							System.out.print("Enter a number please: ");
							choice = input.next();

							switch (choice) {
							case "1":
								System.out.printf("\nTotal Revenue: %.2f $\n", Member.TotalRevenue);
								System.out.println("---------------------");
								break;
							case "2":

								if (Member.TotalBorrows > Member.TotalReturns) {
									System.out
											.println("\nThe Most Frequent Operation is Borrow: " + Member.TotalBorrows);
									System.out.println("---------------------");
								} else if (Member.TotalReturns > Member.TotalBorrows) {
									System.out.println(
											"\nThe Most Frequent Operation is Renturn: " + Member.TotalReturns);
									System.out.println("---------------------");
								} else {
									System.out.println("\nBorrow And Return are equal: " + Member.TotalBorrows);
									System.out.println("---------------------");
								}
								break;
							case "3":
								System.out.println("\nThe Total View Borrowed is: " + Member.TotalViewBorrowed);
								break;
							case "4":
								System.out.println("\nReturning to Main Menu\n");
								break;
							default:
								System.out.println("Invalid option. Please Try again");
							}

						} while (!choice.equals("4"));
					}

					else if (username.equalsIgnoreCase("exit") || password.equals("exit")) {
						System.out.println("Returning to Main Menu\n");
						break;
					} else {
						System.out.println("\nusername or password is incorrect");
						System.out.println("Please try again");
						System.out.println("---------------------\n");
					}
				}	while ( !username.equalsIgnoreCase("admin") || !password.equals("admin") );

				break;
			} // Administrator case end
			case "3":
				break;
			default:
				System.out.println("Invalid option. Please Try again\n");
			} // switch end
		} // do end
		while (!choose.equals("3"));
		System.out.println("Thank you for using our Library Simulator.");
		System.out.println("Goodbye.");
		input.close();
	}// main end
}// class end
