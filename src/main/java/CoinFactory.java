//import Convert.*;
public class CoinFactory {
    public static ICalculate getCoinInstance(Coins coin){
        if(coin == null){
            return null;
        }
        switch (coin){
            case Coins.ILS:
                return new ILS();
            case Coins.USD:
                return new USD();
        }
        return null;
    }
}
