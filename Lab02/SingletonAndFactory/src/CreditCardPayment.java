public class CreditCardPayment implements Payment {

    public void pay(double amount) {
        System.out.println("Pay " + amount + " using Credit Card");
    }
}