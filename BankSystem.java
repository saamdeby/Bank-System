import java.util.Scanner;
import java.time.LocalTime;

public class BankSystem {

    public static void main(String[] args) {

        // Variable definition + Scanner creation

        String CPF = "", name = "", phone = "", email = "", greeting;
        double balance = 0, withdrawal, deposit;
        int option, optionA, optionB, hour = LocalTime.now().getHour();
        boolean registered = false;

        Scanner scanner = new Scanner(System.in);

        // Time-based greeting

        if (hour >= 5 && hour < 12) {
            greeting = "Good morning";
        } else if (hour >= 12 && hour < 18) {
            greeting = "Good afternoon";
        } else {
            greeting = "Good evening";
        }

        // Main menu

        while(true){
            System.out.println("\n" + greeting + ", welcome to the banking system!");
            System.out.println("1- Account registration");
            System.out.println("2- Banking functions");
            System.out.println("3- Exit system");
            System.out.print("Enter an option: ");

            option = scanner.nextInt();
            scanner.nextLine();

            if(option == 3){
                System.out.println(greeting + ", exiting the system...");
                break;
            }

            switch (option) {
                case 1:

                    // Registration structure

                    while (true) {
                        System.out.println("\n" + greeting + ", ACCOUNT REGISTRATION");

                        System.out.print("1- Register name\n"
                                + "2- Register CPF\n"
                                + "3- Register phone\n"
                                + "4- Register email\n"
                                + "5- Check data\n"
                                + "6- Exit registration options\n\n");

                        System.out.print("Enter an option: ");
                        optionA = scanner.nextInt();
                        scanner.nextLine();

                        // Exit registration option

                        if (optionA == 6) {
                            System.out.println("Ending registration session, moving to banking functions");
                            break;
                        }

                        switch (optionA) {

                            case 1:
                                System.out.print("Enter your full name: ");
                                name = scanner.nextLine();
                                registered = true;
                                System.out.printf(greeting + " %s, your name has been registered!\n", name);
                                break;

                            case 2:
                                System.out.print("Enter your CPF: ");
                                CPF = scanner.nextLine();

                                if (CPF.length() != 11) {
                                    System.out.println("Invalid CPF format, CPF must have 11 digits");
                                } else {
                                    System.out.println(greeting + " CPF registered!");
                                }
                                break;

                            case 3:
                                System.out.print("Enter your phone number: (Area code + number) ");
                                phone = scanner.nextLine();

                                if (phone.length() != 11) {
                                    System.out.println("Invalid phone number, phone must have 11 digits");
                                } else {
                                    System.out.println(greeting + " Phone registered!");
                                }
                                break;

                            case 4:
                                System.out.print("Enter your email: ");
                                email = scanner.nextLine();
                                System.out.println(greeting + " Email registered!");
                                break;

                            case 5:
                                System.out.println(greeting + ", Retrieved data: ");
                                System.out.printf("Full name: %s\nCPF: %s\n" +
                                        "Phone: %s\nEmail: %s\n", name, CPF, phone, email);
                                break;

                            default:
                                System.out.println("Invalid option, use one of the menu options!");
                        }
                    }
                    break;

                case 2:
                    if (!registered) {
                        System.out.println("You need to register to use banking functions!");
                        break;
                    }

                    // Banking functions structure

                    while (true) {
                        System.out.println(greeting + ", welcome to banking functions");
                        System.out.println("1- Check balance");
                        System.out.println("2- Make a deposit");
                        System.out.println("3- Make a withdrawal");
                        System.out.println("4- End session");

                        System.out.print("Enter an option: ");
                        optionB = scanner.nextInt();

                        if (optionB == 4) {
                            System.out.println("Returning to the main menu...");
                            break;
                        }

                        switch (optionB) {

                            case 1:
                                System.out.printf("Your current balance: $%.2f\n", balance);
                                break;

                            case 2:
                                System.out.print("Enter the amount you want to deposit: ");
                                deposit = scanner.nextFloat();

                                if (deposit <= 0) {
                                    System.out.println("Invalid amount! The deposit must be greater than zero!\n");
                                } else {
                                    balance += deposit;
                                    System.out.printf(greeting + " %s, $%.2f has been successfully deposited!\n", name, deposit);
                                }
                                break;

                            case 3:
                                if (balance == 0) {
                                    System.out.println("You have no funds to make a withdrawal!");
                                    break;
                                }

                                System.out.print("Enter the amount you want to withdraw: ");
                                withdrawal = scanner.nextFloat();

                                if (withdrawal > balance) {
                                    System.out.println("You do not have this amount in your account!");
                                } else {
                                    balance -= withdrawal;
                                    System.out.printf(greeting + " withdrawal of $%.2f completed, your new balance: $%.2f\n", withdrawal, balance);
                                }
                                break;

                            default:
                                System.out.println("Invalid option, enter a valid option!\n");
                        }
                    }
            }
        }
    }
}
