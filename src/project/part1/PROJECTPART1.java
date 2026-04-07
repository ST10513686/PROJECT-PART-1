/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project.part1;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.regex.Pattern;
/**
 *
 * @author ntatiso
 */
public class PROJECTPART1 {

  
    public static void main(String[] args) {
        
      Scanner scanner = new Scanner(System.in);
      
        System.out.println("Login details");
      
        System.out.println("Enter Usename");
        String username = scanner.nextLine(); 
        
        
        System.out.println("Enter Password");
        String password = scanner.nextLine();
        
        System.out.println("Enter South African cell no");
        String phoneNumber = scanner.nextLine();
        
        if (phoneNumber.contains("+27")){           
            System.out.println("Valid South African cell no");
        }else{
            System.out.println("Invalid South African cell no");
        }
        
        //validating username
        String usernameMessage = validateUsername(username);
        System.out.println("usernameMessage");
        
        
        //validating password
        String passwordMessage = validatePassword(password);
        System.out.println("passwordMessage");
    }
    
    public static String validateUsername(String username){
        if (username.contains("_") && username.length() <=5) {
            return "Username successfully captured";
    } else {
            return "Username is not correctly formated: PLease ensure your username contains an underscore(_) and is no more than five characters in length";
    }
      
}

    public static String validatePassword(String password){
        String regex = "^(?=.*\\d)(?+.*[@#$^&+=!])(?=\\S+$.{8,}$";
        if (Pattern.matches(regex, password)){
            return "Password successfully captured.";
            
        }else{
            
            return "Password is not correctly formated: PLease ensure that the password contains at least eight characters, a capital letter, a number and a special character.";
        }
    }
}