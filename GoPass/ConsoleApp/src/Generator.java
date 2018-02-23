package src;

import java.security.SecureRandom;

/**
 * This class contains the logic for the strong password generation.
 */
public class Generator {

    // SecureRandom number generator which makes the password harder to guess.
    private static SecureRandom random_int = new SecureRandom();

    // We group the characters to be used into constant strings.
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SYMBOLS = "!?#$%/^&@+-=";

    // We'll use this to select a random list.
    private static String[] characters = {UPPERCASE, LOWERCASE, NUMBERS, SYMBOLS};

    /**
     * This class keeps track of the strings to avoid and generates the password.
     * @param username can't be part of the password
     * @param full_name can't be part of the password either
     * @return
     */
    public static String generatePassword(String username, String full_name) {

        // This is the string where we'll store the generated password.
        String pass = "";

        /*
         * We loop 8 times for each random character.
         * First, we select a random list to pick from using SecureRandom.
         * Then, we generate a random index and concatenate the character
         * at the index to the final password.
         */
        for(int i = 0; i < 8; i++) {
            int current = random_int.nextInt(characters.length);
            int index = random_int.nextInt(characters[current].length());
            pass += characters[current].charAt(index);
        }

        return pass;

    }
}
