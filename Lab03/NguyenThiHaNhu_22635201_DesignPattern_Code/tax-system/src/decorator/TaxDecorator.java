package decorator;

import strategy.TaxStrategy;

public abstract class TaxDecorator implements TaxStrategy {
    protected TaxStrategy wrappedStrategy;

    public TaxDecorator(TaxStrategy strategy) {
        this.wrappedStrategy = strategy;
    }

    @Override
    public double calculateTax(double price) {
        return wrappedStrategy.calculateTax(price);
    }
}