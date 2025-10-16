import java.util.Scanner;

public class User {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//setting user names and accounts 
		
		int First_id = 1000;
		String First_name = "Hamad";
		
		int Second_id = 1001;
		String Second_name = "Yassir";
		
		int Third_id = 1002;
		String Third_name = "Khalid";
		
		//setting total calculations
		
		int Total_books_borrowed = 0;
		
		int Total_books_returned = 0;
		
		float Total_revnue = 0f;
		
		//this variable is used to stop the do while loop if the enterd name is valid
		int Valid_name = 0;
		
		//The login part for the user
		do {
			
			System.out.println("We have three registered accounts accounts: ");
			System.out.println(First_name + ", ID#" + First_id);
			System.out.println(Second_name + ", ID#" + Second_id);
			System.out.println(Third_name + ", ID#" + Third_id);
			System.out.print("Which one is yours, please enter the username only: ");
			String Username = input.next();
			if (Username.equalsIgnoreCase(First_name) || Username.equalsIgnoreCase(Second_name) || Username.equalsIgnoreCase(Third_name)) {
				System.out.println("Welcome to the library " + Username);
				Valid_name++;
			}
			else {
				System.out.println("Please choose one of the available accounts!");
				
			}
		}while (Valid_name == 0);
		
		do {
			
			// Variables for the user that restart every session
			
			float Fees_per_session = 0f;
			int Books_borrowed = 0;
			int Books_returned = 0;
			
			System.out.println("");
			System.out.println("THE MENU:");
			System.out.println("");
			System.out.println("Borrow Book");
			System.out.println("Return Book");
			System.out.println("View Borrowed Books");
			System.out.println("View Session Summary");
			System.out.println("Exit to Main Menu");
			System.out.println("");
			System.out.print("How Can I help You:");
			input.nextLine(); //this is for consuming the line before so we can give input to the program
			String User_action = input.nextLine().trim().toLowerCase();
			switch (User_action) {
			
			case "borrow":
			case "borrow book":
				System.out.println("Borrowing a book has a 0.50$ fee for any book in the library you choose.");
				System.out.print("Are you sure you want to borrow a book (answer \"yes\" or \"no\" please)");
				String User_answer = input.next();
				if (User_answer.equalsIgnoreCase("yes") || User_answer.equalsIgnoreCase("y")) {
					// updating variables
					Fees_per_session += 0.50f;
					Total_revnue += 0.50f;
					Books_borrowed += 1;
					Total_books_borrowed += 1;
					
					System.out.println("You have borrowed on book for 0.50$ successfully!");
				}
				else {
					System.out.println("then you will be returned to the main user menu.");
				}
				break;
				
			case "return book":
				break;
				
			case "view borrowed books":
				break;
			
			case "view session summary":
				break;
			
			case "exit to main menu":
				break;
				
			default:
				System.out.println("Please enter a valid option!");
				
			}
			
		} while(Valid_name == 0);
		
		
		
		
	}

}
