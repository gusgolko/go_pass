package src;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
            int index = random_int.nextInt(characters[i].length);
            pass[i] =  characters[i][index];
        }

        // Join the arrays to select 4 more characters by joining them 2 by 2.
        letters = joinArrays(UPPERCASE, LOWERCASE);
        symbols = joinArrays(NUMBERS, SYMBOLS);
        allChars = joinArrays(letters, symbols);

        // Select 4 more characters at random.
        for (int i = 4; i < 8; i++) {
            int index = random_int.nextInt(allChars.length);
            pass[i] =  allChars[index];
        }

        // Shuffle the array and convert it to an ArrayList.
        shuffled = shuffle(pass);

        // Convert the shuffled characters to a string.
        password = arrListToString(shuffled);

        // Return the password.
        return password;

    }

    /**
     * This class concatenates our character arrays.
     * @param first the first array
     * @param second the second array
     * @return joined the joined arrays
     */
    public static char[] joinArrays(char[] first, char[] second) {

        // Get the lengths of the arrays to join.
        int first_len = first.length;
        int second_len = second.length;

        /* Create an array of the same type and with the combined length
         * of the input arrays. We assumed they're all of the same type.
         */
        char[] joined = (char[]) Array.newInstance(first.getClass().getComponentType(),
                first_len + second_len);

        // Copy the arrays into the return array using arraycopy().
        System.arraycopy(first, 0, joined, 0, first_len);
        System.arraycopy(second, 0, joined, first_len, second_len);

        // Return the joined array.
        return joined;


    }

    /**
     * This method takes a character array and returns a shuffled ArrayList.
     * @param unshuffled the array to be shuffled
     * @return shuffled the shuffled list
     */
    public static ArrayList<Character> shuffle(char[] unshuffled) {

        // Create a new ArrayList.
        List<Character> shuffled = new ArrayList<Character>();

        // Add the characters to the ArrayList.
        for (char c : unshuffled) {
            shuffled.add(c);
        }

        // Shuffle the ArrayList using the SecureRandom seed.
        Collections.shuffle(shuffled, random_int);

        // Return the shuffled list.
        return (ArrayList<Character>) shuffled;
    }

    /**
     * This method takes in a character ArrayList and converts it
     * to a string.
     * @param inputArrList character ArrayList to convert to string
     * @return resulting_string the resulting string
     */
    public static String arrListToString(ArrayList<Character> inputArrList) {

        // This is where we'll store our return string.
        String resulting_string;

        // New StringBuilder we'll use to convert the ArrayList to a string.
        StringBuilder builder = new StringBuilder(inputArrList.size());

        // Append all the shuffled characters
        for(Character c : inputArrList) {
            builder.append(c);
        }

        // Convert the result to string.
        resulting_string = builder.toString();

        // Return the result.
        return resulting_string;
    }
}
