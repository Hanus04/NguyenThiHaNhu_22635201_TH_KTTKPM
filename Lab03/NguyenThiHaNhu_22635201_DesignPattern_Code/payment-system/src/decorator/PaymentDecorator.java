package decorator;

import strategy.PaymentStrategy;

public abstract class PaymentDecorator implements PaymentStrategy {
    protected PaymentStrategy wrappedStrategy;

    public PaymentDecorator(PaymentStrategy strategy) {
        this.wrappedStrategy = strategy;
    }

    @Override
    public void pay(double amount) {
        wrappedStrategy.pay(amount);
    }
}