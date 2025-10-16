import java.util.Scanner;

public class Administrator {
	public static void main(String[] Args) {

		Scanner input = new Scanner(System.in);
		String username, password;
		do {
			System.out.println("--- To accses to Administrator Menu ---\n");
			System.out.println("Hint: write admin for both to Enter");
			System.out.println("Or write exit to Return to Main Menu.\n");
			System.out.print("Enter admin username: ");
			username = input.next();

			System.out.print("Enter passowrd: ");
			password = input.next();

			if (username.equalsIgnoreCase("admin") && password.equals("admin")) {
				int choice;
				float TotalRevenue = 1.5f;
				int Borrow = 8;
				int Return = 8;
				do {
					System.out.println("\n--- Administrator Menu ---\n");
					System.out.println("1. View Total Revenue");
					System.out.println("2. Most Frequent Operation");
					System.out.println("3. Exit to Main Menu");
					System.out.println("\nNote: You must Enter a Number!");
					System.out.print("Enter your Choice: ");
					choice = input.nextInt();

					switch (choice) {
					case 1:
						System.out.printf("Total Revenue: %.2f credit\n", TotalRevenue);
						break;
					case 2:

						if (Borrow > Return) {
							System.out.println("The Most Frequent Operation is Borrow: " + Borrow);
						} else if (Return > Borrow) {
							System.out.println("The Most Frequent Operation is Renturn: " + Return);
						} else
							System.out.println("Borrow And Return is equal: " + Borrow);
						break;
					case 3:
						System.out.println("Returning to Main Menu");
						break;
					default:
						System.out.println("Invalid Choice. Please Try again");
					}

				} while (choice != 3);
			}

			else if (username.equalsIgnoreCase("exit") || password.equals("exit")) {
				System.out.println("Returning to Main Menu\n");
			} else {
				System.out.println("\nusername or passowrd is incorrect");
				System.out.println("Please try again\n");
			}
		}

		while (!username.equalsIgnoreCase("exit")
				&& (!username.equalsIgnoreCase("admin") || !password.equals("admin")));

