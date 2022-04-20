package PasswordGenerator;

import java.util.Random;

public class PasswordGenerator {

	/*
	 * A method that takes in the String array of the three chosen words and
	 * compares them to each other. If there is no match, it returns true, else
	 * returns false.
	 */
	public static boolean differentWords(String array[]) {
		String word = array[0], word2 = array[1], word3 = array[2];
		boolean good = true;

		if (word.equals(word2) || word.equals(word3) || word2.equals(word3)) {
			good = false;
		} else {
			good = true;
		}
		return good;

	}

	/*
	 * A method that checks for length of password between 8 and 16 characters.
	 * Returns true if yes, false if no.
	 */

	public static boolean lengthOfPassword(String password) {
		int passwordLength = password.length();

		if (passwordLength >= 8 && passwordLength <= 16) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * a method to return true if the word is only a single character, false if more
	 * than one character.
	 */

	public static boolean checkWordLength(String word) {
		if (word.length() == 1) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * A method that checks for at least one capital letter. I used flag and break,
	 * the flag increments with each capital and if there is more than one there is
	 * no point in continuing so we break the loop. I used the ASCII values to check
	 * for the capitals. I checked in several places to ensure that charAt() is a
	 * String method.
	 */
	public static boolean hasCapitalLetter(String password) {
		int flag = 0;

		for (int i = 0; i < password.length(); i++) {
			if ((password.charAt(i) >= 65) && (password.charAt(i) <= 90))
				flag++;
		}
		if (flag >= 1) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * A method that checks for at least one lower case letters. I used flag and
	 * break, the flag increments with at each lower case letter, if there is more
	 * than one there is no point in continuing so we break the loop. I used the
	 * ASCII values to check for the letter. Again, checked in many places to ensure
	 * that charAt() is a String method.
	 */
	public static boolean hasLowercaseLetters(String password) {
		int flag = 0;

		for (int i = 0; i < password.length(); i++) {
			if ((password.charAt(i) >= 97) && (password.charAt(i) <= 122))
				flag++;
		}
		if (flag == 1) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * A method that checks for at least one lower case letters. I used flag and
	 * break, the flag increments with at each lower case letter, if there is more
	 * than one there is no point in continuing so we break the loop. I used the
	 * ASCII values to check for the special characters. I checked for all just to
	 * be sure that nothing was missed. Again, checked in many places to ensure that
	 * charAt() is a String method.
	 */
	public static boolean hasSpecialCharacter(String password) {
		int flag = 0;

		for (int i = 0; i < password.length(); i++) {
			if ((password.charAt(i) == '@') || (password.charAt(i) == '!') || ((password.charAt(i) >= 58)
					&& (password.charAt(i) <= 64))) {
				flag++;
			}
		}
		if (flag == 1) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		Random random = new Random();
		String chosenLine = "she@ a had by! she a lol; why\n a Had \"EAT\n She By";
		int singleCharCount = 0, newLineCount = 0;
		String wordArray[] = chosenLine.split(" ");
		// an array to hold the words separately for checking if they are the same
		String substringArray[] = new String[3];

		int randomWordInt = 0;
		String word = "", threeWords = "", newLine = "\n";

		// for loop from 0 to 2 to take in the three words required for the password.
		for (int i = 0; i < 3;) {

			randomWordInt = random.nextInt(wordArray.length);
			word = wordArray[randomWordInt]; // randomly choose a word

			if (checkWordLength(word) == false && word.contains(newLine) == false) {
				threeWords += word;
				substringArray[i] = word;
				i++;
				continue;
			} else if (checkWordLength(word) == true) {
				singleCharCount++;
				continue;
			} else if (word.contains(newLine) == true) {
				newLineCount++;
				continue;
			}
		}

		System.out.println(chosenLine);
		System.out.println(threeWords);
		System.out.println(singleCharCount);
		System.out.println(newLineCount);
		System.out.println("Password has different words: " + differentWords(substringArray));
		System.out.println("Password is between 8 and 16 chars: " + lengthOfPassword(threeWords));
		System.out.println("Password has only one capital letter: " + hasCapitalLetter(threeWords));
		System.out.println("Password has only one lower letter: " + hasLowercaseLetters(threeWords));
		System.out.println("Password has only one special character: " + hasSpecialCharacter(threeWords));

	}
}