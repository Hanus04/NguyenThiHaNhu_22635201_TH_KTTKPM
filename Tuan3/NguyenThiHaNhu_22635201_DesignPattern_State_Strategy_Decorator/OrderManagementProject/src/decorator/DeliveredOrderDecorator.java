package decorator;

public class DeliveredOrderDecorator extends OrderDecorator {

    public DeliveredOrderDecorator(OrderComponent order) {
        super(order);
    }

    public void process() {
        super.process();
        System.out.println("Đã giao hàng");
    }
}