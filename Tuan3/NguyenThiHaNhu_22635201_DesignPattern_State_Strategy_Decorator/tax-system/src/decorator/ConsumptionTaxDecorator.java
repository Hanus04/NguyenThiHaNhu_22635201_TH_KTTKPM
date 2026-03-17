package decorator;

import strategy.TaxStrategy;

public class ConsumptionTaxDecorator extends TaxDecorator {

    public ConsumptionTaxDecorator(TaxStrategy strategy) {
        super(strategy);
    }

    @Override
    public double calculateTax(double price) {
        return super.calculateTax(price) + price * 0.08; // 8%
    }
}