package decorator;

import strategy.PaymentStrategy;

public class ProcessingFeeDecorator extends PaymentDecorator {

    public ProcessingFeeDecorator(PaymentStrategy strategy) {
        super(strategy);
    }

    @Override
    public void pay(double amount) {
        double fee = amount * 0.02;
        double total = amount + fee;
        System.out.println("Phí xử lý: " + fee);
        super.pay(total);
    }
}