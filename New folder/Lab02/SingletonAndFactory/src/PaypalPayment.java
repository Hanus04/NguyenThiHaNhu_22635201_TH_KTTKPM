public class PaypalPayment implements Payment {

    public void pay(double amount) {
        System.out.println("Pay " + amount + " using PayPal");
    }
}