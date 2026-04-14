public class PaymentConext {
    private PaymentStrategy strategy;

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public double pay(double amount){
        return strategy.pay(amount);
    }
}
