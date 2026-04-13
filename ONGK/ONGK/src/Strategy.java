interface PaymentStrategy {
    void pay(double amount);
}

class CashPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán tiền mặt: " + amount);
    }
}

class VNPayPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán qua VNPay: " + amount);
    }
}

class MomoPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán qua Momo: " + amount);
    }
}

class PaymentContext {
    private PaymentStrategy strategy;

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void pay(double amount) {
        strategy.pay(amount);
    }
}

public class StrategyMain {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        context.setStrategy(new CashPayment());
        context.pay(100000);

        context.setStrategy(new VNPayPayment());
        context.pay(250000);

        context.setStrategy(new MomoPayment());
        context.pay(500000);
    }
}