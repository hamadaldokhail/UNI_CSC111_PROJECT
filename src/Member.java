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

	public void viewBorrowedCount() {
		System.out.println(borrowedCount);
	}// end viewBorrowedCount

	public boolean borrowOne() {
		return true;
	}// end borrowOne

	public boolean returnOne() {
		return true;
	}// end returnOne

	public void displayStatistics() {
		System.out.println(this.getName() + "\t ID#" + this.getId());
		System.out.println("Number of book currently borrowed: " + this.borrowedCount);
		System.out.println("How many times did the user borrow a book: " + numBorrows);
		System.out.println("How many times did the user return a book: " + numReturns);
		System.out.println("The total fees incured: " + sessionFees);

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
