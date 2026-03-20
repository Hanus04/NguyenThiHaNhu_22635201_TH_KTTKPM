package decorator;

import strategy.PaymentStrategy;

public class DiscountDecorator extends PaymentDecorator {

    public DiscountDecorator(PaymentStrategy strategy) {
        super(strategy);
    }

    @Override
    public void pay(double amount) {
        double discount = amount * 0.1;
        double total = amount - discount;
        System.out.println("Giảm giá: " + discount);
        super.pay(total);
    }
}