//https://github.com/hamadaldokhail/UNI_CSC111_PROJECT_PHASE1
// Khaled Abdulaziz Alquwaizany ID 446106134
// Yasser Abdullah Albusairy	ID 446104619
// Hamed Ahmed Aldkhyyal		ID 446103564

public class Member {

	private int id;
	private String name;
	private int borrowedCount;
	private int numViewBorrowed;
	private int numBorrows;
	private int numReturns;
	private double sessionFees;

	public double TotalRevenue;
	public int TotalViewBorrowed;
	public int TotalBorrows;
	public int TotalReturns;

	public Member(int id, String name, int borrowedCount) {
		this.id = id;
		this.name = name;
		this.borrowedCount = borrowedCount;
	}// end parameters

	private boolean canBorrow() {
		if (borrowedCount < 5)
			return true;
		else
			return false;
	}// end canBorrow

	private boolean canReturn() {
		if (borrowedCount > 0)
			return true;
		else
			return false;
	}// end canBorrow

	public boolean borrowOne() {
		if (canBorrow() == true) {
			System.out.println("");
			System.out.println("You have borrowed one book for 0.50$ successfully!");
			System.out.println("---------------------");
			sessionFees += 0.50f;
			TotalRevenue += 0.50f;
			numBorrows += 1;
			TotalBorrows += 1;
			borrowedCount += 1;
			return true;
		} else
		{
			System.out.println("");
			System.out.println("Oops, it seems that you have borrowed 5 books, which is the limit.");
			System.out.println("Unfortunatly, you cant borrow more than 5,");
			System.out.println("Therefore you will be returned to the main user menu.");
			System.out.println("---------------------");
			return false;
		}

	}// end borrowOne

	public boolean returnOne() {
		if (canReturn() == true) {
			System.out.println("");
			System.out.println("You have returned one book successfully!");
			System.out.println("---------------------");
			TotalReturns += 1;
			numReturns += 1;
			borrowedCount -= 1;
			return true;
			}
		else {
			System.out.println("");
			System.out.println("Oops, it seems that you dont have any books to return yet!");
			System.out.println("Therefore you will be returned to the main user menu, so you can borrow some books :)");
			System.out.println("---------------------");
			return false;
		}
	}// end returnOne
	
	public void viewBorrowedCount() {
		System.out.println("");
		System.out.println("The number of borrowed books that you have: " + borrowedCount);
		System.out.println("---------------------");
		numViewBorrowed += 1;
	}// end viewBorrowedCount


	public void displayStatistics() {
		System.out.println("");
		System.out.println("Session Summary:");
		System.out.println("----------------");
		System.out.println(this.getName() + "\t ID#" + this.getId());
		System.out.println("");
		System.out.println("Books Borrowed: " + numBorrows);
		System.out.println("Books Returned: " + numReturns);
		System.out.printf("Total Fees: %.2f $", sessionFees);
		System.out.println("");
		System.out.println("----------------");

	}// end displayStatistics

	public void reset() {
		
		borrowedCount = 0;
		numBorrows = 0;
		numReturns = 0;
		sessionFees = 0;

	}// end reset

	public int getId() {
		return id;
	}// end getId

	public String getName() {
		return name;
	}// end getName

}// end class
