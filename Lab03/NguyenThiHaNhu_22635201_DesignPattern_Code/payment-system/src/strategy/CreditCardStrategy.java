package strategy;

public class CreditCardStrategy implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán bằng thẻ tín dụng: " + amount);
    }
}