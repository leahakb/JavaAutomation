import convert.*;
//for input
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;
//for array
import java.util.ArrayList;
//for file manipulation
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class CurrencyCalculator {

    private static int input;
    private static double amount;
    private static double rate;
    private static String startOver = "Y";

    public static void main(String[] args){
        //create an array for the list of results
        ArrayList <Double>conversions = new ArrayList<>();
        //Only show once
        System.out.println("Welcome to currency converter");
        while (startOver.equals("Y") || startOver.equals("y")) {
            FirstScreen();
        //If the input was correct and get the rate
            switch (input) {
                case 1:
                    //USD
                    try {
                        Coin USDCurrency = new USD();
                        rate = USDCurrency.getValue();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    //ILS
                    try {
                        Coin ILSCurrency = new ILS();
                        rate = ILSCurrency.getValue();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    //in case either 1 or 2 was the input
                    System.out.println("The invalid input was entered");
                    FirstScreen();
            }
        //Based on the rate calculate the conversion total
            if (rate == 3.52) {
                //USD
                SecondScreen();
                USD total = new USD();
                ThirdScreen();
                //add a converted amount to an array
                conversions.add(total.calculate(amount));
                System.out.println(total.calculate(amount));
                StartOver();
            } else if (rate == 0.28) {

                //ILS
                SecondScreen();
                ILS total = new ILS();
                ThirdScreen();
                //add a converted amount to an array
                conversions.add(total.calculate(amount));
                System.out.println(total.calculate(amount));
                StartOver();
            } else System.out.println("Start over!");
        }
        //if startOver is not Y or y
        FourthScreen();
            //write to file
        String filePath = "C:\\Users\\Yelena\\IdeaProjects\\JavaAutomation\\src\\main\\results.txt";
        try (BufferedWriter toFile = new BufferedWriter(new FileWriter(filePath))){
            for (Double conversion: conversions){
                toFile.write(String.valueOf(conversion));
                toFile.write((System.lineSeparator()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
            //print from file

        try {
            String fileContent = new String(Files.readAllBytes(Paths.get(filePath)));
            System.out.println("Your conversions were as follows:");
            System.out.println(fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //Welcome Screen with input of currency choice
    public static Integer FirstScreen(){
        System.out.println("Please choose an option (1/2):");
        System.out.println("1. Dollars to Shekels");
        System.out.println("2. Shekels to Dollars");
        try {
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Input Mismatch! Try Again");
            FirstScreen();
        }
        return input;
    }
    //Second screen with input of amount
    public static double SecondScreen(){
        System.out.println("Please enter an amount to convert");
        try {
            Scanner scanner = new Scanner(System.in);
            amount = scanner.nextDouble();
        }
        catch (Exception e) {
            System.out.println("Input Mismatch! Try Again");
            SecondScreen();
    }
        return amount;
    }
    //Third screen with conversion calculation
    public static void ThirdScreen(){
        System.out.println("The converted amount is: " );
    }
    //Start Over screen
    public static String StartOver(){
        System.out.println("Do you want to calculate another conversion? (Y/N)");
        Scanner scanner = new Scanner(System.in);
        startOver = scanner.next();
        return startOver;
    }
    public static void FourthScreen(){
        System.out.println("Thanks for using our currency converter!");
    }
}
