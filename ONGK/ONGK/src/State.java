interface OrderState {
    void handle(OrderContext context);
}

class OrderContext {
    private OrderState state;

    public OrderContext(OrderState state) {
        this.state = state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public void next() {
        state.handle(this);
    }
}

class PendingState implements OrderState {
    @Override
    public void handle(OrderContext context) {
        System.out.println("Đơn hàng đang chờ xác nhận -> chuyển sang ĐANG GIAO");
        context.setState(new ShippingState());
    }
}

class ShippingState implements OrderState {
    @Override
    public void handle(OrderContext context) {
        System.out.println("Đơn hàng đang giao -> chuyển sang HOÀN THÀNH");
        context.setState(new DoneState());
    }
}

class DoneState implements OrderState {
    @Override
    public void handle(OrderContext context) {
        System.out.println("Đơn hàng đã hoàn thành, không chuyển tiếp nữa.");
    }
}

public class StateMain {
    public static void main(String[] args) {
        OrderContext order = new OrderContext(new PendingState());
        order.next();
        order.next();
        order.next();
    }
}