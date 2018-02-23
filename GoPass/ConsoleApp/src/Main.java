package src;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Declare variables to be used for storage.
        String username;
        String full_name;
        Scanner scanner = new Scanner(System.in);

        // Print welcome message and prompt for username and full name.
        System.out.println("Welcome to GoPass!");
        System.out.println();
        System.out.println("GoPass generates strong passwords so you don't have to!");
        System.out.println("+ 8 characters in length");
        System.out.println("+ Mixed case");
        System.out.println("+ Alphanumeric");
        System.out.println("+ Special symbols");
        System.out.println("+ Different from your username and name");
        System.out.println();
        System.out.print("Input your username to get started: ");
        username = scanner.nextLine();
        System.out.println();
        System.out.print("Input your name and surname: ");
        full_name = scanner.nextLine();
        System.out.println();

        // Test code that prints the username and name back on the console.
        System.out.println("Your username is: " + username);
        System.out.println("Your name is: " + full_name);
    }
}
