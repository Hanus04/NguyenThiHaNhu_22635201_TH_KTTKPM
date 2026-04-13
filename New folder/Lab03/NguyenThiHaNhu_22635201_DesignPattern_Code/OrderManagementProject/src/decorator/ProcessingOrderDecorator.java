package decorator;

public class ProcessingOrderDecorator extends OrderDecorator {

    public ProcessingOrderDecorator(OrderComponent order) {
        super(order);
    }

    public void process() {
        super.process();
        System.out.println("Đóng gói và vận chuyển");
    }
}