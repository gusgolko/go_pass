package src;

import java.security.SecureRandom;
import java.util.Arrays;

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

    /**
     * This class keeps track of the strings to avoid and generates the password.
     * @param username can't be part of the password
     * @param f_name can't be part of the password either
     * @param l_name can't be part of the password either
     * @return
     */
    public static String generatePassword(String username, String f_name, String l_name) {

        // This is the character array where we'll store the generated password.
        char[] pass = new char[8];
        // This is the String we'll return.
        String password;

        /*
         * We loop 8 times for each random character.
         * First, we select a random list to pick from using SecureRandom.
         * Then, we generate a random index and concatenate the character
         * at the index to the final password.
         */
        for (int i = 0; i < 8; i++) {
            int current = random_int.nextInt(characters.length);//rand int 0-3
            int index = random_int.nextInt(characters[current].length);//rand int 0-whatever list
            pass[i] =  characters[current][index];
        }

        /* Check if any of the names are contained in the random password
         * to avoid making it vulnerable accidentally.
         */
        if (Arrays.asList(pass).contains(username) || Arrays.asList(pass).contains(f_name) ||
                Arrays.asList(pass).contains(l_name)) {
            // Recursive call to generate a new random password.
            password = generatePassword(username, f_name, l_name);
        }

        password = pass.toString();
        return password;

    }
}
