package patterndemos.strategy;

public class FlatPercentTax implements TaxAlgorithm {
    private float percentage;

    public FlatPercentTax(float percentage) {
        this.percentage = percentage;
    }

    @Override
    public float calculate(float input) {
        return input * (1 + this.percentage);
    }
}
