package decorator;

import strategy.TaxStrategy;

public class VATDecorator extends TaxDecorator {

    public VATDecorator(TaxStrategy strategy) {
        super(strategy);
    }

    @Override
    public double calculateTax(double price) {
        return super.calculateTax(price) + price * 0.05; // VAT 5%
    }
}