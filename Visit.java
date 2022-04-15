package BeautySalon;

//----------------------------------------------------
//Assignment 1 Question 2
//Written by: Matthew Penny #219-5150
//For Application Development 2 (Mobile) - Winter 2022
//----------------------------------------------------

/* My program will create Customers of a beauty salon and generate a bill for their visit. Based on the loyalty
* program of the beauty salon, the customer will receive a discount of 10-20% for the services and a current flat
* rate of 10%, although this can change at a later date. Non member customers will not receive any discount. There
* toString methods to override the default method, and the classes are set up as per instructions given.
*/

import java.util.Date;

public class Visit {

	private Customer customer;
	private Date date;
	private double serviceExpense;
	private double productExpense;

	Visit(String name, Date date) {
		customer.setName(name);
		this.date = date;
	}

	public String getName() {
		return getName();
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getServiceExpense() {
		return serviceExpense;
	}

	public void setServiceExpense(double serviceExpense) {
		this.serviceExpense = serviceExpense;
	}

	public double getProductExpense() {
		return productExpense;
	}

	public void setProductExpense(double productExpense) {
		this.productExpense = productExpense;
	}

	public double getTotalExpense(double productExpense, double serviceExpense, boolean isMember) {
		double totalExpense = productExpense + serviceExpense;

		return totalExpense;
	}

	@Override
	public String toString() {
		return "Visit [Customer = " + customer + ", Date = " + date + ", Service Expense = $" + serviceExpense
				+ ", Product Expense = $" + productExpense + "]";
	}

}
