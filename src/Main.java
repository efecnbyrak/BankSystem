import model.User;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static UserController userController = new UserController();
    private static Scanner in = new Scanner(System.in);
    private static int totalValue = 5000; // This is just test value.
    //This data will be retrieved from the database.

    public static void main(String[] args) {
        System.out.println("-Welcome to PhyBerk Bank-");
        startUp();
    }
    public static void startUp(){
        System.out.println("Pls Enter Your Choose : ");
        System.out.println("1 -> Login");
        System.out.println("2 -> Sign Up");
        byte userChoose = in.nextByte();
        if(userChoose == 1) {
            loginUp();
        } else if (userChoose == 2) {
            signUp();
        }else {
            System.out.println("Pls enter a correct value.");
            startUp();
        }
    }
    public static void loginUp(){
        System.out.println("Pls Enter SSN Number : ");
        long ssn= 0;
        try {
            ssn = in.nextLong();
        }catch (InputMismatchException e){
            System.out.println("Pls Enter a Number.");
            in.nextLine();
            loginUp();
            return;
        }
        System.out.println("Pls Enter Password : ");
        String password = in.next();

        User user = userController.findBySsn(ssn);

        if(user != null){
            if(user.getPassword().equals(password)){
                System.out.println("Login Succesful. Welcome, " + user.getName() + "!");
                loginMade();
            }else{
                System.out.println("Wrong Password. Pls Try Again.");
                loginUp();
            }
        }else{
            System.out.println("No user found with this SSN.");
            signUp();
        }
    }
    public static void signUp(){
        System.out.print("Enter First Name : ");
        String name = in.next();
        System.out.print("Enter Last Name : ");
        String surname = in.next();
        System.out.print("Enter SSN : ");
        long ssn = 0;
            try {
                ssn = in.nextLong();
            }catch (InputMismatchException e){
                System.out.println("Pls Enter a Number");
                in.nextLine();
                signUp();
                return;
            }
        System.out.print("Enter Password : ");
        String password = in.next();
        if(password.length() >= 8) {
            User user = new User(name, surname, ssn, password);
            userController.saveUser(user);
            System.out.println("User Succesfully Registered.");
            loginUp();
        }else{
            System.out.println("User Could Not Be Saved");
            System.out.println("Pls Try Again");
            signUp();
        }
    }
    public static void loginMade(){

        System.out.println("Pls Choose Your Process");
        System.out.println("1 -> Withdrawal");
        System.out.println("2 -> Deposit");
        System.out.println("3 -> Balance Viewing");
        System.out.println("4 -> Account Deletion");
        System.out.println("5 -> Exit");
        byte choose = in.nextByte();
        switch (choose){
            case 1-> withdrawal();
            case 2-> deposit();
            case 3-> balanceViewing();
            case 4-> accountDeletion();
            case 5-> System.exit(0);
            default -> {
                System.out.println("Pls Enter Correct Value.");
                loginMade();
            }
        }
    }
    public static void withdrawal(){
        System.out.println("Your Balance : " + totalValue);
        System.out.print("Enter the amount you wish to withdraw : \n-> ");
        int withdrawValue = in.nextInt();
        int lastBalance = totalValue - withdrawValue;
        if(lastBalance < 0){
            System.out.println("You cannot withdraw an amount of money greater than your balance.");
            withdrawal();
        }else{
            System.out.println("The process was completed successfully.");
            System.out.println("New Balance is " + lastBalance);
            loginMade();
        }

    }
    public static void deposit(){
        //BURADAN DEVAM EDİCEM
    }
    public static void balanceViewing(){

    }
    public static void accountDeletion(){

    }
}