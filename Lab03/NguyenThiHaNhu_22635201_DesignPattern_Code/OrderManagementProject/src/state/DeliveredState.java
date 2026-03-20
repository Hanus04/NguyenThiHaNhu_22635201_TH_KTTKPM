package state;

public class DeliveredState implements OrderState {
    @Override
    public void handle(Order order) {
        System.out.println("Đã giao hàng thành công");
    }
}