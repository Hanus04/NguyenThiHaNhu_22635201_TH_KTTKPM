package decorator;

public class NewOrderDecorator extends OrderDecorator {

    public NewOrderDecorator(OrderComponent order) {
        super(order);
    }

    public void process() {
        super.process();
        System.out.println("Kiểm tra thông tin đơn hàng");
    }
}