package convert;

public abstract class Coin implements ICalculate {

    public abstract double getValue();

    public double calculate(double value) {
        return value;
    }
}
