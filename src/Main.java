import java.io.FileWriter;  // For writing to a file
import java.io.File;        // For reading a file
import java.io.IOException; // Handles file errors
import java.util.Scanner;   // For user input and reading files

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create Scanner for user input
        boolean running = true; // Controls the loop

        while (running) {
            // Display menu
            System.out.println("\nChoose an option:");
            System.out.println("1. Input new record");
            System.out.println("2. Show saved records");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt(); // Get user's choice
            scanner.nextLine(); // Clear newline character

            if (choice == 1) {
                // User inputs new record
                System.out.print("Full Name: ");
                String fullName = scanner.nextLine();

                System.out.print("Birthdate (YYYY-MM-DD): ");
                String birthdate = scanner.nextLine();

                System.out.print("Civil Status: ");
                String civilStatus = scanner.nextLine();

                System.out.print("Address: ");
                String address = scanner.nextLine();

                // Format the data to be saved
                String output = "Full Name: " + fullName + "\n" +
                        "Birthdate: " + birthdate + "\n" +
                        "Civil Status: " + civilStatus + "\n" +
                        "Address: " + address + "\n\n";

                try {
                    // Write the info to file (append mode)
                    FileWriter writer = new FileWriter("UserInfo.txt", true);
                    writer.write(output);
                    writer.close();
                    System.out.println("Record saved to UserInfo.txt");
                } catch (IOException e) {
                    System.out.println("Error saving file.");
                }

            } else if (choice == 2) {
                // Show records from file
                try {
                    File file = new File("UserInfo.txt");
                    Scanner fileScanner = new Scanner(file);

                    System.out.println("\n--- Saved Records ---");
                    while (fileScanner.hasNextLine()) {
                        System.out.println(fileScanner.nextLine()); // Print each line
                    }

                    fileScanner.close();
                } catch (IOException e) {
                    System.out.println("Error reading file or file does not exist.");
                }

            } else if (choice == 3) {
                // Exit the program
                System.out.println("Exiting application...");
                running = false; // Break the loop
            } else {
                // Invalid input
                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }

        scanner.close(); // Close scanner before ending
    }
}
