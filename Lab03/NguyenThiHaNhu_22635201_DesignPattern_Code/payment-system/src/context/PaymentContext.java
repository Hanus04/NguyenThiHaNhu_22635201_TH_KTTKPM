package context;

import strategy.PaymentStrategy;
import state.PaymentState;

public class PaymentContext {

    private PaymentState currentState;
    private PaymentStrategy strategy;

    public void setState(PaymentState state) {
        this.currentState = state;
    }

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void processPayment(double amount) {
        // State xử lý trước
        if (currentState != null) {
            currentState.handle(this);
        }

        // Strategy + Decorator xử lý thanh toán
        if (strategy != null) {
            strategy.pay(amount);
        }
    }
}