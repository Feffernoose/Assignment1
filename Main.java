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

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Formatter center = new Formatter(); // Used to easily format opening banner
		NumberFormat totalBillAmount = NumberFormat.getCurrencyInstance(Locale.CANADA_FRENCH); // Used to properly
																								// format for Quebec
		String welcome = "Welcome to the New You Beauty Salon!";
		Date date = new Date();
		int menuChoice = 0;
		boolean exit = true, isMember = false;
		String customerName = "", membershipLevel = "", membershipStatus = "";

		System.out.printf("%101s%n", "*****-----*****-----*****-----*****-----*****");
		System.out.println();
		System.out.println(center.format("%97s", welcome));
		System.out.println();
		System.out.printf("%101s%n", "*****-----*****-----*****-----*****-----*****");
		System.out.println();

		System.out.println(
				"What would you like to do?\n1 - Create a new client\n2 - Calculate discount level\n3 - Generate bill for customer\n"
						+ "4 - Quit program");
		do {
			System.out.println("Enter your choice: ");
			menuChoice = Integer.parseInt(input.nextLine());

			switch (menuChoice) {

			case 1:
				System.out.println("Enter name of new customer: ");
				customerName = input.nextLine();
				System.out.println();
				Customer customer = new Customer(customerName);
				
				System.out.println("Is " + customerName + " a Member? Yes or No");
				membershipStatus = input.nextLine();
				
				if (membershipStatus.equalsIgnoreCase("yes")) {
					customer.setMember(true);
				} else {
					customer.setMember(false); 
				}
				if (customer.isMember() == true) {
				System.out.println("What level is " + customerName + "'s Membership level?");
				membershipLevel = input.nextLine();
				customer.setMemberType(membershipLevel);
				System.out.println(customer.toString());
				} else {
				System.out.println(customer.toString());
				}
				System.out.println();
				System.out.println("What would you like to do?\n1 - Create a new client\n2 - Set Membership Level\n"
						+ "3 - Calculate discount level\n4 - Generate bill for customer\n5 - Quit program");
				break;

			case 2:
				break;

			case 3:
				break;

			case 4:
				break;

			case 5:
				System.out.println("Thank you for using our Beauty Salon program. Have a wonderful day!");
				exit = !exit;
				break;

			}
		} while (exit);
	}

}
