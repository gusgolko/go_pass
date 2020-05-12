package src;

import java.util.Scanner;
import java.awt.Toolkit;
import java.awt.datatransfer.*;

public class Main {

    public static void main(String[] args) {

        // Declare variables to be used for storage.s
        String username;
        String password;
        String cp;
        int choice;
        boolean go_on = true;
        Scanner scanner = new Scanner(System.in);

        // Create a generator factory and a console generator.
        GeneratorFactory generatorFactory = new GeneratorFactory();
        Generator genConsole = generatorFactory.getGenerator("console");

        // Print welcome message.
        System.out.println();
        System.out.println("**************************************");
        System.out.println("********* Welcome to GoPass! *********");
        System.out.println("**************************************");
        System.out.println();
        System.out.println("GoPass generates strong passwords so you don't have to!");
        System.out.println("+ 8 characters in length");
        System.out.println("+ Mixed case");
        System.out.println("+ Alphanumeric");
        System.out.println("+ Special symbols");
        System.out.println();

        // Offer the choice to continue or quit.
        System.out.println("Press 1 to get started");
        System.out.print("> ");
        username = scanner.nextLine();
        System.out.println();

        // Generate the password and store it.
        password = genConsole.generatePassword();

        // Print the generated password.
        System.out.println("Your password is " + password);
        System.out.println();

        // Enter main loop.
        while (go_on) {

		    System.out.println("What next?");
		    System.out.println("[1] Generate new password");
		    System.out.println("[2] Copy to clipboard");
		    System.out.println("[0] Exit");
		    System.out.print("> ");
		    choice = scanner.nextInt();
		    System.out.println();

		    switch (choice) {

                case 1:
                    // Generate the password and store it.
                    password = genConsole.generatePassword();
                    // Print the generated password.
                    System.out.println("Your password is " + password);
                    System.out.println();
                    break;

		        case 2:
		    		// Get clipboard and set contents to password.
		    		Clipboard cp_brd = Toolkit.getDefaultToolkit().getSystemClipboard();
       			 	StringSelection str_sel = new StringSelection(password);
       				cp_brd.setContents(str_sel, str_sel);
       				System.out.println("Password copied successfully!");
       				break;

        		default:
        			// Exit.
        			go_on = false;
		    }
		}
    }
}
