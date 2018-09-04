package patterndemos.strategy;

public class FlatAdditionTax implements TaxAlgorithm {
    private float addition;

    public FlatAdditionTax(float addition) {
        this.addition = addition;
    }

    @Override
    public float calculate(float input) {
        return input + this.addition;
    }
}
