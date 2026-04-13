public class Main {

    public static void main(String[] args) {

        // Singleton
        PaymentConfig config = PaymentConfig.getInstance();
        config.showConfig();

        System.out.println("----- Payment Examples -----");

        // Factory - Credit Card
        Payment payment1 = PaymentFactory.createPayment("creditcard");
        payment1.pay(100);

        // Factory - PayPal
        Payment payment2 = PaymentFactory.createPayment("paypal");
        payment2.pay(200);

        // Factory - Momo
        Payment payment3 = PaymentFactory.createPayment("momo");
        payment3.pay(300);
    }
}