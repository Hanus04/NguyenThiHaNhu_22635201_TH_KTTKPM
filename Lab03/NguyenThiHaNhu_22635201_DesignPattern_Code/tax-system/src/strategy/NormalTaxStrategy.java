package strategy;

public class NormalTaxStrategy implements TaxStrategy {
    @Override
    public double calculateTax(double price) {
        return price * 0.1; // 10%
    }
}