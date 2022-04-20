package PasswordGenerator;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordGenerator2 {

	public String generateLine(String book[][][]) {
		Random random = new Random();

		// First step is choosing page number, paragraph number and line number by using
		// Random class and nextInt() method
		String chosenLine = "";

		// do / while loop runs once and checks against the amount of paragraphs and
		// lines. If they go out of bounds, the randomizer for each runs again.
		do {

			// using this variable to set the range of pages, starting from 0 and excluding
			// length
			int pageLength = book.length;
			int randomPageNumber = random.nextInt(pageLength); // generate a page number

			int paragraphAmount = book[randomPageNumber].length; // generate a paragraph number up to number of
																	// paragraphs on random page
			int randomParagraphNumber = random.nextInt(paragraphAmount);

			int lineAmount = book[randomPageNumber][randomParagraphNumber].length;
			int randomLineNumber = random.nextInt(lineAmount);

			// once these three are generated, we can look at the line that is chosen
			chosenLine = book[randomPageNumber][randomParagraphNumber][randomLineNumber];

		} while (chosenLine == null);
		return chosenLine;
	}

	// a method to return true if the word is only a single character, false if more
	// than one character
	public static boolean checkWordLength(String word) {
		if (word.length() == 1) {
			return true;
		} else {
			return false;
		}
	}

	// A method that takes in the String array of the three chosen words and
	// compares them to each other.
	// If there is no match, it returns true, else returns false
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

	// A method that checks for length of password between 8 and 16 characters.
	// Returns true if yes,
	// false if no.
	public static boolean lengthOfPassword(String password) {
		int passwordLength = password.length();

		if (passwordLength >= 8 && passwordLength <= 16) {
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
		Pattern specialCharacters = Pattern.compile("[$&+,:;?@#|'<>.^*()%!-]");
		Matcher matcher = specialCharacters.matcher(password);
		boolean isContainingSpecialCharacter = matcher.find();
		
		for (int i = 0; i < password.length(); i++) {
			if ((password.charAt(i) == '@') && (password.charAt(i) == '!') && (password.charAt(i) == '"')
					&& (password.charAt(i) <= 64)) {
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

		// http://www.gutenberg.org/cache/epub/19033/pg19033.txt
		final String[][][] book = { { { "ALICE was beginning to get very tired of sitting by her sister on the\n",
				"bank, and of having nothing to do. Once or twice she had peeped into the\n",
				"book her sister was reading, but it had no pictures or conversations in\n",
				"it, \"and what is the use of a book,\" thought Alice, \"without pictures or\n", "conversations?\"\n" },
				{ "So she was considering in her OWN mind (as well as she could, for the\n",
						"day made her feel very sleepy and stupid), whether the pleasure of\n",
						"making a daisy-chain would be worth the trouble of getting up and\n",
						"picking the daisies, when suddenly a White Rabbit with pink eyes ran\n", "close by her.\n" },
				{ "There was nothing so very remarkable in that, nor did Alice think it so\n",
						"very much out of the way to hear the Rabbit say to itself, \"Oh dear! Oh\n",
						"dear! I shall be too late!\" But when the Rabbit actually took a watch\n",
						"out of its waistcoat-pocket and looked at it and then hurried on, Alice\n",
						"started to her feet, for it flashed across her mind that she had never\n",
						"before seen a rabbit with either a waistcoat-pocket, or a watch to take\n",
						"out of it, and, burning with curiosity, she ran across the field after\n",
						"it and was just in time to see it pop down a large rabbit-hole, under\n",
						"the hedge. In another moment, down went Alice after it!" } },
				{ { "\"WHAT a curious feeling!\" said Alice. \"I must be shutting up like a\n", "telescope!\"\n" },
						{ "And so it was indeed! She was now only ten inches high, and her face\n",
								"brightened up at the thought that she was now the right size for going\n",
								"through the little door into that lovely garden.\n" },
						{ "After awhile, finding that nothing more happened, she decided on going\n",
								"into the garden at once; but, alas for poor Alice! When she got to the\n",
								"door, she found she had forgotten the little golden key, and when she\n",
								"went back to the table for it, she found she could not possibly reach\n",
								"it: she could see it quite plainly through the glass and she tried her\n",
								"best to climb up one of the legs of the table, but it was too slippery,\n",
								"and when she had tired herself out with trying, the poor little thing\n",
								"sat down and cried.\n" },
						{ "\"Come, there's no use in crying like that!\" said Alice to herself rather\n",
								"sharply. \"I advise you to leave off this minute!\" She generally gave\n",
								"herself very good advice (though she very seldom followed it), and\n",
								"sometimes she scolded herself so severely as to bring tears into her\n", "eyes.\n" },
						{ "Soon her eye fell on a little glass box that was lying under the table:\n",
								"she opened it and found in it a very small cake, on which the words \"EAT\n",
								"ME\" were beautifully marked in currants. \"Well, I'll eat it,\" said\n",
								"Alice, \"and if it makes me grow larger, I CAN reach the key; and if it\n",
								"makes me grow smaller, I can creep under the door: so either way I'll\n",
								"get into the garden, and I don't care which happens!\"\n" },
						{ "She ate a little bit and said anxiously to herself, \"Which way? Which\n",
								"way?\" holding her hand on the top of her head to feel which way she was\n",
								"growing; and she was quite surprised to find that she remained the same\n",
								"size. So she set to work and very soon finished off the cake." } },
				{ { "The King and Queen of Hearts were seated on their throne when they\n",
						"arrived, with a great crowd assembled about them--all sorts of little\n",
						"birds and beasts, as well as the whole pack of cards: the Knave was\n",
						"standing before them, in chains, with a soldier on each side to guard\n",
						"him; and near the King was the White Rabbit, with a trumpet in one hand\n",
						"and a scroll of parchment in the other. In the very middle of the court\n",
						"was a table, with a large DISH of tarts upon it. \"I wish they'd get the\n",
						"trial done,\" Alice thought, \"and hand 'round the refreshments!\"\n" },
						{ "The judge, by the way, was the King and he wore his crown over his great\n",
								"wig. \"That's the jury-box,\" thought Alice; \"and those twelve creatures\n",
								"(some were animals and some were birds) I suppose they are the jurors.\"\n" },
						{ "Just then the White Rabbit cried out \"Silence in the court!\"\n" },
						{ "\"HERALD! read the accusation!\" said the King." } } };

		PasswordGenerator2 password = new PasswordGenerator2();

		Random random = new Random();

		// First step is choosing page number, paragraph number and line number by using
		// Random class and nextInt() method
		/*
		 * String chosenLine = "";
		 * 
		 * // do / while loop runs once and checks against the amount of paragraphs and
		 * // lines. If they go out of bounds, the randomizer for each runs again. do {
		 * 
		 * // using this variable to set the range of pages, starting from 0 and
		 * excluding // length int pageLength = book.length; int randomPageNumber =
		 * random.nextInt(pageLength); // generate a page number
		 * 
		 * int paragraphAmount = book[randomPageNumber].length; // generate a paragraph
		 * number up to number of // paragraphs on random page int randomParagraphNumber
		 * = random.nextInt(paragraphAmount);
		 * 
		 * int lineAmount = book[randomPageNumber][randomParagraphNumber].length; int
		 * randomLineNumber = random.nextInt(lineAmount);
		 * 
		 * // once these three are generated, we can look at the line that is chosen
		 * chosenLine = book[randomPageNumber][randomParagraphNumber][randomLineNumber];
		 * 
		 * } while (chosenLine == null); Creating a set of variables to initiate the
		 * first 2 counts and start the rest of the steps to generate an acceptable
		 * password. There is a String array that will hold the chosenLine There is also
		 * a integer that holds the length of that array.
		 */

		String chosenLine = password.generateLine(book);
		int singleCharCount = 0, newLineCount = 0;
		String wordArray[] = chosenLine.split(" ");
		int randomWordInt = 0;
		String word = "", threeWords = "", newLine = "\n";
		String substringArray[] = new String[3]; // an array to hold the words separately for checking if they are the
		// same
		// for loop from 1 to 3 to take in the three words required for the password.
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
		// test prints, get rid of these later
		System.out.println(threeWords);
		System.out.println(singleCharCount);
		System.out.println(newLineCount);

		// NOw we need to pass those three words through a bunch of methods. If it
		// returns false or whatever back to generating new three words
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
