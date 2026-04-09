/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project.part1;
import java.util.Scanner;

/**
 *
 * @author ntatiso
 */
public class PROJECTPART1 {
//added basic input
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String cellPhoneNumber;

    public PROJECTPART1(String firstName, String lastName, String userName, String password, String cellPhoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
    }

    public boolean checkUserName() {
        return userName.contains("_") && userName.length() <= 5;
    }

    public boolean checkPasswordComplexity() {
        String regex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z0-9]).{8,}$";
        return password.matches(regex);
    }

    public boolean checkCellPhoneNumber() {
        String regex = "^\\+\\d{1,3}\\d{1,10}$";
        return cellPhoneNumber.matches(regex);
    }

    // added Registration input
    public String registerUser() {
        if (!checkUserName()) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }

        if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
//cellphone validation
        if (!checkCellPhoneNumber()) {
            return "Cell phone number incorrectly formatted or does not contain international code; please correct the number and try again.";
        }

        return "User has been registered successfully.";
    }

    // Login check
    public boolean loginUser(String enteredUserName, String enteredPassword) {
        return this.userName.equals(enteredUserName) && this.password.equals(enteredPassword);
    }

    // Login message
    public String returnLoginStatus(boolean loginSuccess) {
        if (loginSuccess) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== REGISTRATION ===");

        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter username: ");
        String userName = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Enter cell phone number: ");
        String cellPhoneNumber = scanner.nextLine();

        PROJECTPART1 user = new PROJECTPART1(firstName, lastName, userName, password, cellPhoneNumber);

        if (user.checkUserName()) {
            System.out.println("Username successfully captured.");
        } else {
            System.out.println("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.");
        }

        if (user.checkPasswordComplexity()) {
            System.out.println("Password successfully captured.");
        } else {
            System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
        }

        if (user.checkCellPhoneNumber()) {
            System.out.println("Cell number successfully captured.");
        } else {
            System.out.println("Cell phone number incorrectly formatted or does not contain international code; please correct the number and try again.");
        }

        System.out.println(user.registerUser());

        System.out.println("\n=== LOGIN TO THE ACCOUNT USING THE SAME USERNAME AND PASSWORD ===");

        System.out.print("Enter username: ");
        String enteredUserName = scanner.nextLine();

        System.out.print("Enter password: ");
        String enteredPassword = scanner.nextLine();

        boolean loginSuccess = user.loginUser(enteredUserName, enteredPassword);

        System.out.println(user.returnLoginStatus(loginSuccess));

        scanner.close();
    }
}

