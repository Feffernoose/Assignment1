package BeautySalon;

import java.util.Scanner;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;
import java.text.NumberFormat;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);	
		Formatter center = new Formatter();  //Used to easily format opening banner
		NumberFormat totalBillAmount = NumberFormat.getCurrencyInstance(Locale.CANADA_FRENCH); //Used to properly format for Quebec
		String welcome = "Welcome to the New You Beauty Salon!"; 
		Date date = new Date();


		System.out.printf("%101s%n", "*****-----*****-----*****-----*****-----*****");
		System.out.println();
		System.out.println(center.format("%97s",welcome));
		System.out.println();
		System.out.printf("%101s%n", "*****-----*****-----*****-----*****-----*****");
		System.out.println();
	}

}
