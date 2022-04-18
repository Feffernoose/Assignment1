package BeautySalon;

//----------------------------------------------------

//Assignment 1 Question 2
//Written by: Matthew Penny #219-5150
//For Application Development 2 (Mobile) - Winter 2022
//----------------------------------------------------

import java.util.Date;
import java.util.Formatter;
import java.util.Locale;
import java.text.NumberFormat;

public class Main {

	/*
	 * I created 3 different customers to show the different levels of customer, one
	 * Premium, one Gold and one non-member. I used Formatter for the banner and
	 * NumberFormat to use the proper money format for Quebec.
	 */

	public static void main(String[] args) {
		// Created a Date object to output correct date each time.
		Date date = new Date();
		Formatter center = new Formatter(); // Used to easily format opening banner
		NumberFormat totalBillAmount = NumberFormat.getCurrencyInstance(Locale.CANADA_FRENCH);

		// Welcome message, Date object and the rest of the variables needed to run
		// through the program.
		String welcome = "Welcome to the New You Beauty Salon!";


		// Welcome banner
		System.out.printf("%101s%n", "*****-----*****-----*****-----*****-----*****");
		System.out.println();
		System.out.println(center.format("%97s", welcome));
		System.out.println();
		System.out.printf("%101s%n", "*****-----*****-----*****-----*****-----*****");
		System.out.println();

		// Creating a Customer of Premium level of membership
		Visit customer1 = new Visit("Matthew", date);
		customer1.setProductExpense(900.00);
		customer1.setServiceExpense(1200.00);
		customer1.setMember(true);
		customer1.setMemberType("premium");

		// Because of the overridden toString in Visit, the output will be from the
		// Visit class
		System.out.println(customer1.toString());
		System.out.println("The total cost of " + customer1.getName() + "'s visit was "
				+ totalBillAmount.format(customer1.calculateTotalExpense()) + "\n\n");

		// Creating a Customer of Gold level of membership
		Visit customer2 = new Visit("Genevieve", date);
		customer2.setProductExpense(1700.00);
		customer2.setServiceExpense(800.00);
		customer2.setMember(true);
		customer2.setMemberType("gold");

		// Because of the overridden toString in Visit, the output will be from the
		// Visit class
		System.out.println(customer2.toString());
		System.out.println("The total cost of " + customer2.getName() + "'s visit was "
				+ totalBillAmount.format(customer2.calculateTotalExpense()) + "\n\n");

		// Creating a Customer of no level of membership
		Visit customer3 = new Visit("Luke", date);
		customer3.setProductExpense(1700.00);
		customer3.setServiceExpense(800.00);
		customer3.setMember(false);
		customer3.setMemberType("not a member");

		// Because of the overridden toString in Visit, the output will be from the
		// Visit class
		System.out.println(customer3.toString());
		System.out.println("The total cost of " + customer3.getName() + "'s visit was "
				+ totalBillAmount.format(customer3.calculateTotalExpense()) + "\n\n");
		
		System.out.println("Thank you for using our Beauty Salon program. Have a wonderful day!");
		
	}

}
