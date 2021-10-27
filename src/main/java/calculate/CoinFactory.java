package calculate;

import coins.Coins;
import coins.ILS;
import coins.USD;

public class CoinFactory {
    public static ICalculate getCoinInstance(Coins coin){
        if(coin == null){
            return null;
        }
        switch (coin){
            case ILS:
                return new ILS();
            case USD:
                return new USD();
        }
        return null;
    }
}
