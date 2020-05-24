package src;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Helper class containing array and string manipulation
 * methods to help us build our password.
 */
public class PasswordBuilder {

    /**
     * This method concatenates our character arrays.
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
        Collections.shuffle(shuffled, Generator.getRandom_int());

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
