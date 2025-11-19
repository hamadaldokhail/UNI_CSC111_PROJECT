
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
		return true;
	}// end canBorrow

	private boolean canReturn() {
		return true;
	}// end canBorrow

	public void viewBorrowedCount() {

	}// end viewBorrowedCount

	public boolean borrowOne() {
		return true;
	}// end borrowOne

	public boolean returnOne() {
		return true;
	}// end returnOne
	
	public void displayStatistics() {
		
	}// end displayStatistics
	
	public void reset() {
		
	}// end reset

}// end class