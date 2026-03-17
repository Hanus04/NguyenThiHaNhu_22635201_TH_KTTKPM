package decorator;

public class CancelledOrderDecorator extends OrderDecorator {

    public CancelledOrderDecorator(OrderComponent order) {
        super(order);
    }

    public void process() {
        super.process();
        System.out.println("Hủy đơn và hoàn tiền");
    }
}