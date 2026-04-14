public class VNPayPayment implements PaymentStrategy{
    @Override
    public double pay(double amount) {
        System.out.println("Thanh toán VNpay: " + amount);

        return amount * 0.2;
    }
}
