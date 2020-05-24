package src;

import java.util.Scanner;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Clipboard;

public class Main {

    public static void main(String[] args) {

        // Declare variables to be used for storage.
        String password;
        String choice;
        boolean go_on = true;
        Scanner scanner = new Scanner(System.in);

        // Create a generator factory and a console generator.
        GeneratorFacade generatorFacade = new GeneratorFacade();
        generatorFacade.genPw();

        // Print welcome message.
        Welcome.printMessage();

        // Offer the choice to continue or quit.
        System.out.println("Press 1 to get started");
        System.out.print("> ");
        System.out.println();

        // Generate the password and store it.
        password = generatorFacade.genPw();

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
		    choice = scanner.nextLine();
		    System.out.println();

		    switch (choice) {

                case "1":
                    // Generate the password and store it.
                    password = generatorFacade.genPw();
                    // Print the generated password.
                    System.out.println("Your password is " + password);
                    System.out.println();
                    break;

		        case "2":
		    		// Get clipboard and set contents to password.
		        	StringSelection str_sel = new StringSelection(password);
		    		Clipboard cp_brd = Toolkit.getDefaultToolkit().getSystemClipboard();
       				cp_brd.setContents(str_sel, str_sel);
       				System.out.println("Password copied successfully!");
       				System.out.println();
       				break;

        		default:
        			// Exit.
        			go_on = false;
        			scanner.close();
        			
		    }
		}
    }
}
