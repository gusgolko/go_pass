package src;

import java.security.SecureRandom;
import java.util.ArrayList;

/**
 * This class contains the logic for the strong password generation.
 */
public class Generator {

    // SecureRandom number generator which makes the password harder to guess.
    private static SecureRandom random_int = new SecureRandom();

    // We group the characters to be used into constant character arrays.
    private static final char[] UPPERCASE = {'A', 'B', 'C', 'D', 'E', 'F', 'G',
            'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
            'V', 'W', 'X', 'Y', 'Z'};
    private static final char[] LOWERCASE = {'a', 'b', 'c', 'd', 'e', 'f', 'g',
            'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
            'v', 'w', 'x', 'y', 'z'};
    private static final char[] NUMBERS = {'0', '1', '2', '3', '4', '5', '6',
            '7', '8', '9'};
    private static final char[] SYMBOLS = {'!', '?', '#', '$', '%', '/', '^',
            '&', '@', '+', '-', '='};

    // We'll use this to select a random list.
    private static char[][] characters = {UPPERCASE, LOWERCASE, NUMBERS, SYMBOLS};

    // We'll use these arrays to join all arrays.
    private static char[] allChars, letters, symbols;

    /**
     * This class keeps track of the strings to avoid and generates the password.
     * @return password the generated password
     */
    public String generatePassword() {

        // This is the character array where we'll store the generated password.
        char[] pass = new char[8];
        // This is the String we'll return.
        String password;
        // We'll store the shuffled array here.
        ArrayList<Character> shuffled;

        /* We loop 4 times for a random character from each
         * array. Then, we generate a random index and add
         * the character at the index to the final password.
         */
        for (int i = 0; i < 4; i++) {
            int index = getRandom_int().nextInt(characters[i].length);
            pass[i] =  characters[i][index];
        }

        // Join the arrays to select 4 more characters by joining them 2 by 2.
        letters = PasswordBuilder.joinArrays(UPPERCASE, LOWERCASE);
        symbols = PasswordBuilder.joinArrays(NUMBERS, SYMBOLS);
        allChars = PasswordBuilder.joinArrays(letters, symbols);

        // Select 4 more characters at random.
        for (int i = 4; i < 8; i++) {
            int index = getRandom_int().nextInt(allChars.length);
            pass[i] =  allChars[index];
        }

        // Shuffle the array and convert it to an ArrayList.
        shuffled = PasswordBuilder.shuffle(pass);

        // Convert the shuffled characters to a string.
        password = PasswordBuilder.arrListToString(shuffled);

        // Return the password.
        return password;

    }

    /**
     * Getter method for the SecureRandom number generator.
     * @return the number generator
     */
	public static SecureRandom getRandom_int() {
		return random_int;
	}

	/**
	 * Setter method for the SecureRandom number generator.
	 * @param random_int
	 */
	public static void setRandom_int(SecureRandom random_int) {
		Generator.random_int = random_int;
	}
    
}
