package BeautySalon;
//----------------------------------------------------

//Assignment 1 Question 2
//Written by: Matthew Penny #219-5150
//For Application Development 2 (Mobile) - Winter 2022
//----------------------------------------------------

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;
import java.text.NumberFormat;

public class Main2 {
/* Created a second Main class to run it as a menu based program. I wanted to simulate the usage of the program.
 * User can create multiple visits for different customers of different membership levels and output the correct 
 * bill total as well as showing a proper welcome and goodbye message as well as closing the Scanner.
 * 
 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// Created a Date object to output correct date each time.
		Date date = new Date();
		Formatter center = new Formatter(); // Used to easily format opening banner
		// used NumberFormat to format the dollar amount correctly
		NumberFormat totalBillAmount = NumberFormat.getCurrencyInstance(Locale.CANADA_FRENCH); 

		// Welcome message, Date object and the rest of the variables needed to run through the program.
		String welcome = "Welcome to the New You Beauty Salon!";
		int menuChoice = 0;
		double products = 0, services = 0;
		boolean exit = false;
		String customerName = "", membershipLevel = "", membershipStatus = "";

		// Welcome banner
		System.out.printf("%101s%n", "*****-----*****-----*****-----*****-----*****");
		System.out.println();
		System.out.println(center.format("%97s", welcome));
		System.out.println();
		System.out.printf("%101s%n", "*****-----*****-----*****-----*****-----*****");
		System.out.println();

		System.out.println("What would you like to do:\n1 - Create a bill for the visit\n2 - Exit program\n");
		do {
			System.out.print("Enter your choice: \t");
			menuChoice = Integer.parseInt(input.nextLine());

			switch (menuChoice) {

			case 1:
				System.out.print("Enter name of customer: ");
				customerName = input.nextLine();
				System.out.println();
				Visit customer = new Visit(customerName, date);

				System.out.println("Is " + customer.getName() + " a Member? Y or N");
				membershipStatus = input.nextLine();

				if (membershipStatus.equalsIgnoreCase("y")) {
					customer.setMember(true);
				} else if (membershipStatus.equalsIgnoreCase("n")){
					customer.setMember(false);
				}

				if (customer.isMember() == true) {
					
					System.out.println("What level is " + customer.getName() + "'s Membership level?");
					membershipLevel = input.nextLine();
					customer.setMemberType(membershipLevel);

					System.out.println("How much did " + customer.getName() + " spend on products?");
					products = Integer.parseInt(input.nextLine());
					customer.setProductExpense(products);

					System.out.println("How much did " + customer.getName() + " spend on services?");
					services = Integer.parseInt(input.nextLine());
					customer.setServiceExpense(services);

					System.out.println(customer.toString());
					System.out.println("\nThe total cost of " + customer.getName() + "'s visit was "
							+ totalBillAmount.format(customer.calculateTotalExpense()));

				} else {
					
					customer.setMemberType("Not a Member");
					System.out.println("How much did " + customer.getName() + " spend on products?");
					products = Integer.parseInt(input.nextLine());
					customer.setProductExpense(products);

					System.out.println("How much did " + customer.getName() + " spend on services?");
					services = Integer.parseInt(input.nextLine());
					customer.setServiceExpense(services);

					System.out.println(customer.toString());
					System.out.println("The total cost of " + customer.getName() + "'s visit was "
							+ totalBillAmount.format(customer.calculateTotalExpense()) + "\n");

				}
				System.out.println();
				System.out.println("What would you like to do:\n1 - Create a bill for the visit\n2 - Exit program\n");
				break;

			case 2:
				System.out.println("Thank you for using our Beauty Salon program. Have a wonderful day!");
				exit = !exit;
				break;

			}

		} while (exit = !exit);
		input.close();
	}

}
