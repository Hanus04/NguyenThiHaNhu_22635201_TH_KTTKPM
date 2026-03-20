package state;

import context.PaymentContext;

public class FailedPaymentState implements PaymentState {

    @Override
    public void handle(PaymentContext context) {
        System.out.println("Trạng thái thất bại: Thanh toán lỗi");
    }
}