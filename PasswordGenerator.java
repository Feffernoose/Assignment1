package PasswordGenerator;

import java.util.Random;

public class PasswordGenerator {
	// a method to return true if the word is only a single character, false if more than one character
	public static boolean checkWordLength(String word) {
		if (word.length() == 1) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		Random random = new Random();
		String chosenLine = "she a had the i lol why\n a has\n \"EAT\n";
		int singleCharCount = 0, newLineCount = 0;
		String wordArray[] = chosenLine.split(" ");
		int randomWordInt = 0;
		String word = "", threeWords = "", newLine = "\n";
		
		// for loop from 1 to 3 to take in the three words required for the password.
		for (int i = 1; i <= 3; ) {
			
			randomWordInt = random.nextInt(wordArray.length);
			word = wordArray[randomWordInt]; // randomly choose a word

			if (checkWordLength(word) == false && word.contains(newLine) == false) {
				threeWords += word;
				i++;
				continue;
			}
			else if (checkWordLength(word) == true) {
				singleCharCount++;
				continue;
			}
			else if (word.contains(newLine) == true) {
				newLineCount++;
				continue;
			}
		}
		System.out.println(chosenLine);
		System.out.println(threeWords);
		System.out.println(singleCharCount);
		System.out.println(newLineCount);
	
	}
}