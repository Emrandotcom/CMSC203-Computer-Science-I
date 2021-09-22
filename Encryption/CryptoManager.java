/*
 * Class: CMSC203 
 * Instructor: Ahmed Tarek 
 * Description: Write a Java program to encrypt and decrypt a phrase using two similar approaches, each insecure by modern standards.  
 * 			    The first approach is called the Caesar Cipher, and is a simple “substitution cipher” where characters in a message are shifted over and replaced by a substitute character.
 * 				The second approach, due to Giovan Battista Bellaso (b 1505, d 1581), uses a key word, where each character in the word specifies the offset for the corresponding character in the message, with the key word wrapping around as needed.    
 *		  
 * Due: 07/13/2021
 * Platform/compiler: Eclipse IDE
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Emran Abbamacha
*/

public class CryptoManager {

	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII
	 * codes according to the LOWER_BOUND and UPPER_BOUND characters
	 * 
	 * @param plainText a string to be encrypted, if it is within the allowable
	 *                  bounds
	 * @return true if all characters are within the allowable bounds, false if any
	 *         character is outside
	 */
	public static boolean stringInBounds(String plainText) {

		boolean validString = true;
		for (int i = 0; i < plainText.length(); i++) {

			char character = plainText.charAt(i);
			if (character < LOWER_BOUND || character > UPPER_BOUND) {
				validString = false;
			}
		}

		return validString;

	}

	/**
	 * Encrypts a string according to the Caesar Cipher. The integer key specifies
	 * an offset and each character in plainText is replaced by the character
	 * \"offset\" away from it
	 * 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key       an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {

		if (!stringInBounds(plainText)) {
			return "";
		}

		String caesarEncryption = "";

		for (int i = 0; i < plainText.length(); i++) {

			char character = plainText.charAt(i);
			int encryptedCharacterInt = (int) character + key;

			while (encryptedCharacterInt > UPPER_BOUND) {
				encryptedCharacterInt -= RANGE;
			}

			caesarEncryption += (char) encryptedCharacterInt;
		}

		return caesarEncryption;
	}

	/**
	 * Encrypts a string according the Bellaso Cipher. Each character in plainText
	 * is offset according to the ASCII value of the corresponding character in
	 * bellasoStr, which is repeated to correspond to the length of plainText
	 * 
	 * @param plainText  an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character
	 *                   by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {

		String bellasoEncryption = "";
		int bellassoStringCount = bellasoStr.length();
		int upperBound = (int) UPPER_BOUND;

		for (int i = 0; i < plainText.length(); i++) {

			char character = plainText.charAt(i);
			int encryptedCharacterInt = (int) character + (int) bellasoStr.charAt(i % bellassoStringCount);

			while (encryptedCharacterInt > upperBound) {
				encryptedCharacterInt -= RANGE;
			}

			bellasoEncryption += (char) encryptedCharacterInt;
		}

		return bellasoEncryption;
	}

	/**
	 * Decrypts a string according to the Caesar Cipher. The integer key specifies
	 * an offset and each character in encryptedText is replaced by the character
	 * \"offset\" characters before it. This is the inverse of the encryptCaesar
	 * method.
	 * 
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key           an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {

		String caesarDecryption = "";

		for (int i = 0; i < encryptedText.length(); i++) {

			char character = encryptedText.charAt(i);
			int decryptedCharacterInt = (int) character - key;

			while (decryptedCharacterInt < LOWER_BOUND) {
				decryptedCharacterInt += RANGE;
			}

			caesarDecryption += (char) decryptedCharacterInt;
		}

		return caesarDecryption;
	}

	/**
	 * Decrypts a string according the Bellaso Cipher. Each character in
	 * encryptedText is replaced by the character corresponding to the character in
	 * bellasoStr, which is repeated to correspond to the length of plainText. This
	 * is the inverse of the encryptBellaso method.
	 * 
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr    an uppercase string that specifies the offsets,
	 *                      character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {

		String bellasoDecryption = "";

		int bellasoStringCount = bellasoStr.length();
		int lowerBound = (int) LOWER_BOUND;

		for (int i = 0; i < encryptedText.length(); i++) {

			char character = encryptedText.charAt(i);
			int decryptedCharacterInt = (int) character - (int) bellasoStr.charAt(i % bellasoStringCount);

			while (decryptedCharacterInt < lowerBound) {
				decryptedCharacterInt += RANGE;
			}

			bellasoDecryption += (char) decryptedCharacterInt;
		}

		return bellasoDecryption;
	}
}