package src;

import java.util.Scanner;
import java.awt.Toolkit;
import java.awt.datatransfer.*;
import static src.Generator.generatePassword;

public class Main {

    public static void main(String[] args) {

        // Declare variables to be used for storage.
        String username;
        String password;
        String cp;
        int choice;
        boolean go_on = true;
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
        System.out.println("Input your username to get started");
        System.out.print("> ");
        username = scanner.nextLine();
        System.out.println();

        // Generate the password and store it.
        password = generatePassword(username);

        // Print the generated password.
        System.out.println("Your password is " + password);
        System.out.println();
        
        // Enter menu.
        while (go_on) {
        
		    System.out.println("What next?");
		    System.out.println("[1] Copy to clipboard");
		    System.out.println("[2] Generate new password");
		    System.out.println("[0] Exit");
		    System.out.print("> ");
		    choice = scanner.nextInt();
		    System.out.println();
		    
		    switch (choice) {
		    
		    	case 1:
		    		// Get clipboard and set contents to password.
		    		Clipboard cp_brd = Toolkit.getDefaultToolkit().getSystemClipboard();
       			 	StringSelection str_sel = new StringSelection(password);
       				cp_brd.setContents(str_sel, str_sel);
       				break;
       				
       			case 2:
       				// Generate the password and store it.
        			password = generatePassword(username);
        			// Print the generated password.
        			System.out.println("Your password is " + password);
        			System.out.println();
        			break;
        			
        		default:
        			// Exit.
        			go_on = false;
		    }
		}
    }
}
