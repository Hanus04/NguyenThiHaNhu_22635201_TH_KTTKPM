package model;

import strategy.TaxStrategy;
import state.ProductState;

public class Product {
    private String name;
    private double basePrice;
    private TaxStrategy taxStrategy;
    private ProductState state;

    public Product(String name, double basePrice, TaxStrategy taxStrategy) {
        this.name = name;
        this.basePrice = basePrice;
        this.taxStrategy = taxStrategy;
    }

    public void setState(ProductState state) {
        this.state = state;
    }

    public void setTaxStrategy(TaxStrategy taxStrategy) {
        this.taxStrategy = taxStrategy;
    }

    public double calculatePrice() {
        if (state != null) {
            state.handle(this);
        }
        double tax = taxStrategy.calculateTax(basePrice);
        return basePrice + tax;
    }

    public double getBasePrice() {
        return basePrice;
    }
}