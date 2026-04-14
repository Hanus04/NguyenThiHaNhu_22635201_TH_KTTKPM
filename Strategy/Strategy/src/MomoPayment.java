public class MomoPayment implements PaymentStrategy{
    @Override
    public double pay(double amount) {
        System.out.println("Thanh toán momo: " + amount);

        return amount * 0.15;
    }
}
