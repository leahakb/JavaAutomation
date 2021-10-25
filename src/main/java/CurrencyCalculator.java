import java.util.Scanner;


public class CurrencyCalculator {

    private static int input;
    private static double amount;
    private static double rate;

    public static void main(String[] args){

        FirstScreen();

        switch(input){
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

        if (rate == 3.52) {
            SecondScreen();
            USD total = new USD();
            ThirdScreen();
            System.out.println(total.calculate(amount));
        }
        else if (rate == 0.28){
            SecondScreen();
            ILS total = new ILS();
            ThirdScreen();
            System.out.println(total.calculate(amount));
        }
        else System.out.println("Start over!");


    }
    //Welcome Screen with imput of currency choice
    public static Integer FirstScreen(){
        System.out.println("Welcome to currency converter");
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
}
