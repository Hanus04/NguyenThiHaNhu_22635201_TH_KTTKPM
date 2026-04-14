//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        PaymentConext context = new PaymentConext();

        context.setStrategy(new CashPayment());
        double result1 = context.pay(5000);
        System.out.println("Kết quả: " + result1);

        context.setStrategy(new VNPayPayment());
        double result2 = context.pay(5000);
        System.out.println("Kết quả: " + result2);
    }
}