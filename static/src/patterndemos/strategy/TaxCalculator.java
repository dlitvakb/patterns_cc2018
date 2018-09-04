package patterndemos.strategy;

public class TaxCalculator {
    private TaxAlgorithm taxAlgorithm;

    public TaxCalculator(TaxAlgorithm taxAlgorithm) {
        this.taxAlgorithm = taxAlgorithm;
    }

    public float calculate(float input) {
        return this.taxAlgorithm.calculate(input);
    }

    public void setTaxAlgorithm(TaxAlgorithm taxAlgorithm) {
        this.taxAlgorithm = taxAlgorithm;
    }
}
