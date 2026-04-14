public class CashPayment implements PaymentStrategy{

    @Override
    public double pay(double amount) {
        System.out.println("Thanh toán tiền mặt: " + amount);

        return amount * 0.1;
    }
}
