import java.util.*;

public class EmailApp {

    //Method that creates email object
    public static Email emailObj(){
        Scanner input = new Scanner(System.in);

        //User is prompted to enter details
        System.out.println("Enter first name: ");
        String firstName = input.next();

        System.out.println("Enter last name: ");
        String secondName = input.next();

        Email email = new Email(firstName.toLowerCase(), secondName.toLowerCase());

        return email;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Email email = emailObj();

        //user is promted to pick a number from given list
        System.out.println("Welcome " + email.getName());
        while (true) {
            System.out.println("\nWhat would you like to do: \n1. Profile information \n2. Get password \n3. Update password \n4. Get email capacity \n5. Set email capacity \n6. Set alternate email \n7. Get alternate email \n0. Exit \n");
            String number = input.next();
            try {
                int choice = Integer.parseInt(number);
                if (choice == 0) {
                    System.out.println("Goodbye!");
                    break;
                } else if (choice == 1) {
                    System.out.println(email.info());
                } else if (choice == 2) {
                    System.out.println("Password: " + email.getPassword());
                } else if (choice == 3) {
                    while (true) {
                        System.out.println("Enter new password: ");
                        String newPass = input.next();
                        //checks if new password is equal to current password
                        if (newPass.equals(email.getPassword())) {
                            System.out.println("Password can't be the same as previous password!");
                        } else {
                            System.out.println("Confirm new password: ");
                            String confirm = input.next();
                            //checks if confirmation password is equal to new password
                            if (confirm.equals(newPass)) {
                                //sets new password
                                email.setPassword(confirm);
                                break;
                            } else {
                                System.out.println("Passwords don't match");
                            }
                        }
                    }
                } else if (choice == 4) {
                    System.out.println(email.getEmailCapacity());
                } else if (choice == 5) {
                    System.out.println("Enter new capacity: ");
                    int capacity = input.nextInt();
                    //new email capacity is set
                    email.setEmailCapacity(capacity);
                    System.out.println("Email capacity set!");
                } else if (choice == 6) {
                    while (true) {
                        System.out.println("Enter alternate email");
                        String altEmail = input.next();
                        if (altEmail.contains("@") && altEmail.contains(".com")) {
                            //Sets alternate email
                            email.setAlternateEmail(altEmail);
                            System.out.println("Alternate email set!");
                            break;
                        } else {
                            System.out.println("Invalid email address!");
                        }
                    }
                } else if (choice == 7) {
                    String altEmail = email.getAlternateEmail();
                    //checks if alternate email is empty
                    if (altEmail.isEmpty()) {
                        System.out.println("There is no alternate email");
                    } else {
                        System.out.println("Alternate email: " + altEmail);
                    }
                } else {
                    System.out.println("Incorrect choice, try again!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
        input.close();
    }
}