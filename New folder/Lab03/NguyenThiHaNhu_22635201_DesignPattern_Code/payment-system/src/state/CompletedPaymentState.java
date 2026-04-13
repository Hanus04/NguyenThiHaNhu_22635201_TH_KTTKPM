package state;

import context.PaymentContext;

public class CompletedPaymentState implements PaymentState {

    @Override
    public void handle(PaymentContext context) {
        System.out.println("Trạng thái hoàn tất: Giao dịch thành công");
    }
}