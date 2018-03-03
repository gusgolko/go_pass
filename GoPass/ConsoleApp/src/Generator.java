package src;

import java.lang.reflect.Array;
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

    // We'll use this array to join all arrays.
    private static char[] allChars;

    /**
     * This class keeps track of the strings to avoid and generates the password.
     * @param username can't be part of the password
     * @param f_name can't be part of the password either
     * @param l_name can't be part of the password either
     * @return password the generated password
     */
    public static String generatePassword(String username, String f_name, String l_name) {

        // This is the character array where we'll store the generated password.
        char[] pass = new char[8];
        // This is the String we'll return.
        String password = "";

        /* We loop 4 times for a random character from each
         * array. Then, we generate a random index and add
         * the character at the index to the final password.
         */
        for (int i = 0; i < 4; i++) {
            int index = random_int.nextInt(characters[i].length);
            pass[i] =  characters[i][index];
        }

        // Join the arrays to select 4 more characters.
        allChars = joinArrays(UPPERCASE, LOWERCASE, NUMBERS, SYMBOLS);

        // Select 4 more characters at random.
        for (int i = 4; i < 8; i++) {
            int index = random_int.nextInt(allChars.length);
            pass[i] =  allChars[index];
        }

        /* Check if any of the names are contained in the random password
         * to avoid making it vulnerable accidentally.
         */
        if (Arrays.asList(pass).contains(username) || Arrays.asList(pass).contains(f_name) ||
                Arrays.asList(pass).contains(l_name)) {
            // Recursive call to generate a new random password.
            password = generatePassword(username, f_name, l_name);
        }

        for (int i = 0; i < pass.length; i++) {
            password += String.valueOf(pass[i]);
        }

        return password;

    }

    /**
     * This class concatenates our character arrays.
     * @param first the first array
     * @param second the second array
     * @param third the third array
     * @param fourth the fourth array
     * @return joined the joined arrays
     */
    public static char[] joinArrays(char[] first, char[] second,
                                        char[] third, char[] fourth) {

        // Get the lengths of the arrays to join.
        int first_len = first.length;
        int second_len = second.length;
        int third_len = third.length;
        int fourth_len = fourth.length;

        /* Create an array of the same type and with the combined length
         * of the input arrays. We assumed they're all of the same type.
         */
        @SuppressWarnings("unchecked")
        char[] joined = (char[]) Array.newInstance(first.getClass().getComponentType(),
                first_len + second_len + third_len + fourth_len);

        // Copy the arrays into the return array using arraycopy().
        System.arraycopy(first, 0, joined, 0, first_len);
        System.arraycopy(second, 0, joined, first_len, second_len);
        System.arraycopy(third, 0, joined, second_len, third_len);
        System.arraycopy(fourth, 0, joined, third_len, fourth_len);

        // Return the joined array.
        return joined;
    }
}
