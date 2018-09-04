package patterndemos;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import patterndemos.strategy.FlatAdditionTax;
import patterndemos.strategy.FlatPercentTax;
import patterndemos.strategy.TaxCalculator;

public class StrategyTest {
    @Test
    public void testStrategy() {
        TaxCalculator calculator = new TaxCalculator(new FlatPercentTax(0.21f));

        assertEquals(calculator.calculate(100f), 121f);

        calculator.setTaxAlgorithm(new FlatAdditionTax(10));

        assertEquals(calculator.calculate(100), 110f);
    }
}
