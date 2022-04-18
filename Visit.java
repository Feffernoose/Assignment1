package BeautySalon;

//----------------------------------------------------
//Assignment 1 Question 2
//Written by: Matthew Penny #219-5150
//For Application Development 2 (Mobile) - Winter 2022
//----------------------------------------------------

/* The Visit class extends the Customer class. The expenses are set in this class as well as the date of the
 * visits. I also placed the total bill calculation in this class. 
*/

import java.util.Date;

public class Visit extends Customer {

	private Customer customer;
	private Date date;
	private double serviceExpense;
	private double productExpense;

	public Visit(String name, Date date) {
		super(name);
		customer = new Customer(name);
		this.date = date;
	}

	public String getName() {
		return customer.getName();
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

	@Override
	public String toString() {
		return "Customer Name = " + super.getName() + ", Date = " + date + ", Member Type = " + super.getMemberType() +
				" Service Expense = $" + serviceExpense + ", Product Expense = $" + productExpense + "]";
	}

	// Visit is supposed to output the total expense of a customers visit. Will need to get the memberType,
	// if the customer is not a member, price is calculated without any discounts.
	public double calculateTotalExpense() {
		
		double totalExpense = 0.0;
		double productDiscountRate = DiscountRate.getProductDiscountRate(this.getMemberType());
		double serviceDiscountRate = DiscountRate.getServiceDiscountRate(this.getMemberType());
		if (this.getMemberType() != null) {
		totalExpense = this.productExpense - (this.productExpense * productDiscountRate) + this.serviceExpense
				- (this.serviceExpense * serviceDiscountRate);
		} else {
			totalExpense = this.productExpense + this.serviceExpense;
		}
		return totalExpense;
	}

}
