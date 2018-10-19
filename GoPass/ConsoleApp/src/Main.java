package src;

import java.util.Scanner;
import static src.Generator.generatePassword;

public class Main {

    public static void main(String[] args) {

        // Declare variables to be used for storage.
        String username;
        String password;
        String choice;
        Scanner scanner = new Scanner(System.in);

        // Print welcome message and prompt for username.
        System.out.println("**************************************");
        System.out.println("********* Welcome to GoPass! *********");
        System.out.println("**************************************");
        System.out.println();
        System.out.println("GoPass generates strong passwords so you don't have to!");
        System.out.println("+ 8 characters in length");
        System.out.println("+ Mixed case");
        System.out.println("+ Alphanumeric");
        System.out.println("+ Special symbols");
        System.out.println("+ Different from your username");
        System.out.println();
        System.out.print("Input your username to get started: ");
        username = scanner.nextLine();
        System.out.println();

        // Generate the password and store it.
        password = generatePassword(username);

        // Print the generated password.
        System.out.println("Your password is " + password);
        System.out.println();
        
        // Offer user to generate new password or quit.
        System.out.print("Generate a new password? (y/n) ");
        choice = scanner.nextLine();
        
        while (choice.equals("y")) {
        	// Generate the password and store it.
        	password = generatePassword(username);

        	// Print the generated password.
        	System.out.println("Your password is " + password);
        	System.out.println();
        
        	// Offer user to generate new password or quit.
        	System.out.print("Generate a new password? (y/n) ");
        	choice = scanner.nextLine();
        }
    }
}
