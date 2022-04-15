package BeautySalon;

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
		double totalExpense = 0.0;
		return totalExpense;
	}

	@Override
	public String toString() {
		return "Visit [Customer = " + customer + ", Date = " + date + ", Service Expense = $" + serviceExpense
				+ ", Product Expense = $" + productExpense + "]";
	}

}
