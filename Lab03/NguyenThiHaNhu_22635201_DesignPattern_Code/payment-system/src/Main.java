import context.PaymentContext;
import strategy.*;
import decorator.*;
import state.*;

public class Main {
    public static void main(String[] args) {

        PaymentContext context = new PaymentContext();

        // ===== STATE =====
        context.setState(new NewPaymentState());

        // ===== STRATEGY =====
        PaymentStrategy strategy = new CreditCardStrategy();

        // ===== DECORATOR =====
        strategy = new DiscountDecorator(strategy);
        strategy = new ProcessingFeeDecorator(strategy);

        context.setStrategy(strategy);

        context.processPayment(1000);

        // chuyển trạng thái
        context.setState(new CompletedPaymentState());
        context.processPayment(1000);
    }
}