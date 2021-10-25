import java.util.Scanner;


public class CurrencyCalculator {

    private static int input;
    private static double amount;
    private static double rate;
    private static String startOver = "Y";

    public static void main(String[] args){
        //Only show once
        System.out.println("Welcome to currency converter");
        while (startOver == "Y" || startOver == "y") {
            FirstScreen();
        //If the input was correct and get the rate
            switch (input) {
                case 1:
                    //USD
                    Coin USDcurrency = new USD();
                    rate = USDcurrency.getValue();
                    break;
                case 2:
                    //ILS
                    Coin ILScurrency = new ILS();
                    rate = ILScurrency.getValue();
                    break;
                default:
                    //in case niether 1 or 2 was the input
                    System.out.println("The invalid input was entered");
                    FirstScreen();
            }
        //Based on the rate calculate the conversion total
            if (rate == 3.52) {
                //USD
                SecondScreen();
                USD total = new USD();
                ThirdScreen();
                System.out.println(total.calculate(amount));
                System.out.println(StartOver());
            } else if (rate == 0.28) {

                //ILS
                SecondScreen();
                ILS total = new ILS();
                ThirdScreen();
                System.out.println(total.calculate(amount));
                System.out.println(StartOver());
            } else System.out.println("Start over!");
        }
        if (startOver != "Y" || startOver != "y")
        FourthScreen();

    }
    //Welcome Screen with input of currency choice
    public static Integer FirstScreen(){
        System.out.println("Please choose an option (1/2):");
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextInt();
        return input;
    }
    //Second screen with input of amount
    public static double SecondScreen(){
        System.out.println("Please enter an amount to convert");
        Scanner scanner = new Scanner(System.in);
        amount = scanner.nextDouble();
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
        System.out.println("Thanks for using our currency converter");
    }
}
