package BeautySalon;

// ----------------------------------------------------
//Assignment 1 Question 2
// Written by: Matthew Penny #219-5150
// For Application Development 2 (Mobile) - Winter 2022
// ----------------------------------------------------

/* My program will create Customers of a beauty salon and generate a bill for their visit. Based on the loyalty
 * program of the beauty salon, the customer will receive a discount of 10-20% for the services and a current flat
 * rate of 10%, although this can change at a later date. Non member customers will not receive any discount. There
 * toString methods to override the default method, and the classes are set up as per instructions given.
 */

public class Customer {

	// Data members are set as private to provide abstraction. isMemeber is set to
	// false as a default as a new Customer
	// is less likely to be a member.
	private String name;
	private boolean isMember = false;
	private String memberType;

	// Constructor sets name of the Customer at time of creation
	public Customer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isMember() {
		return isMember;
	}

	public void setMember(boolean isMember) {
		this.isMember = isMember;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	@Override
	public String toString() {
		return "Customer [ Name = " + name + ", Member Status = " + isMember + ", Member Type = " + memberType + "]";
	}
}
