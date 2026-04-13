package state;

import context.PaymentContext;

public class NewPaymentState implements PaymentState {

    @Override
    public void handle(PaymentContext context) {
        System.out.println("Trạng thái mới tạo: Đang chờ chọn phương thức");
    }
}